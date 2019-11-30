/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webcrawler.api;

import com.example.webcrawler.async.AsyncJavascriptLibs;
import com.example.webcrawler.models.Model;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import static java.util.stream.Collectors.toList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 *
 * @author Redi
 */

@Service
public class ApiService {
        public ArrayList<Model> getGooglePosts(String url) throws IOException, Exception {     
            
            ArrayList<Model> response = new ArrayList<>();
            
//          Get google result page  
            Document document = Jsoup.connect(url).get();
//          Parse above page to get all div elements with class g  
            Elements linksOnPage = document.select("div.g");
//          Open threadpool for parallel call    
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(linksOnPage.size());           
            List<Future<ArrayList<String>>> resultList = new ArrayList<>();     
//          Foreach element get url to retrieve javascript libs
            for (Element element : linksOnPage) {
//              url of the post  
                String googleLink = element.getElementsByTag("cite").text().split(" › ")[0];
                if (!googleLink.equals("")) {
                    AsyncJavascriptLibs calculator  = new AsyncJavascriptLibs(googleLink);
                    Future<ArrayList<String>> result = executor.submit(calculator);
                    resultList.add(result);
                }
            }

            HashMap<String, Integer> countLibs = new HashMap<>();
//          Read response from parallel threads
            for(Future<ArrayList<String>> javascriptLibs : resultList) {
                
                for (String libName : javascriptLibs.get()) {         
                    String libActualName = libName.split("/")[libName.split("/").length-1];
                    if (countLibs.containsKey(libActualName)){
                        int occurance = countLibs.get(libActualName) + 1;
                        countLibs.put(libActualName, occurance);
                    }else{            
                        countLibs.put(libActualName, 1);
                    }
                }
            }
//          close threadpool  
            executor.shutdown();            
            
//          sort hashMap and get top 5
            List<Entry<String, Integer>> top5 = countLibs.entrySet().stream()
                                    .sorted(comparing(Entry::getValue, reverseOrder()))
                                    .limit(5)
                                    .collect(toList());
            
           
//          read top5 list  
            for (Entry<String, Integer> entry : top5) {
                Model model = new Model();
                model.setLibCount(entry.getValue());
                model.setJavascriptLib(entry.getKey());
                    
                response.add(model);
            }

        return response;
    }
}

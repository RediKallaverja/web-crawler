/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webcrawler.async;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Redi
 */
public class AsyncJavascriptLibs implements Callable<ArrayList<String>> {

    private final String url;

    public AsyncJavascriptLibs(String url) {
        this.url = url;
    }
    
    @Override
    public ArrayList<String> call(){
        ArrayList<String> response = new ArrayList<>();
       
        String newUrl = url;
        if (!url.substring(0, 4).equals("http")) {
            newUrl = "http://" + url;
        }        
        try {
            Document document = Jsoup.connect(newUrl).get();
            Elements scriptsOnPage = document.select("script");
            for (Element element : scriptsOnPage) {
                String src = element.attr("src");
                if (src.equals("")) {
                    continue;
                }
                response.add(src);        
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}

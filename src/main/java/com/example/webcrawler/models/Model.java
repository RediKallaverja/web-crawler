/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webcrawler.models;

/**
 *
 * @author Redi
 */
public class Model {
    private int libCount;
    private String javascriptLib;

    public Model() {
    }

    public Model(int libCount, String javascriptLib) {
        this.libCount = libCount;
        this.javascriptLib = javascriptLib;
    }    

    public int getLibCount() {
        return libCount;
    }

    public void setLibCount(int libCount) {
        this.libCount = libCount;
    }

    public String getJavascriptLib() {
        return javascriptLib;
    }

    public void setJavascriptLib(String javascriptLib) {
        this.javascriptLib = javascriptLib;
    }
    
}

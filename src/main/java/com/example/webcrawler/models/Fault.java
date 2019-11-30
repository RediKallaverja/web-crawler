/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webcrawler.models;

/**
 *
 * @author rkallaverja
 */
public class Fault {
    private String name;
    private String desc;
    private int reasonCode;

    public Fault(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Fault() {
    }
    
    public Fault(String name, String desc, int reasonCode) {
        this.name = name;
        this.desc = desc;
        this.reasonCode = reasonCode;
    }

    public int getReasonCode() {
        return reasonCode;
    }

    public void setResonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    } 
}

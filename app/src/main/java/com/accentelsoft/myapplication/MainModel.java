package com.accentelsoft.myapplication;

/**
 * Designed and Developed by Mohammad suhail ahmed on 17/05/2021
 */
public class MainModel {
    private String tab_name;
    private String label;

    public MainModel(String tab_name,String label){
        this.tab_name = tab_name;
        this.label = label;
    }

    public void setTab_name(String tab_name) {
        this.tab_name = tab_name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTab_name() {
        return tab_name;
    }

    public String getLabel() {
        return label;
    }
}

package com.quikr.locatorFinder;

import java.util.HashMap;

public class Application {
    public static void main(String[] args){
        XMLReader xmlReader = new XMLReader();
        HashMap<String ,String > l = xmlReader.getDOMElements("HomePageElements.xml");
        for(String s:l.keySet()){
            System.out.println(s+" : "+l.get(s));
        }
    }
}

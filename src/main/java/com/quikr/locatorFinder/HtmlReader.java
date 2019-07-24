package com.quikr.locatorFinder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class HtmlReader {

    public Document read(String weburl,String inputFile){
        Document doc =null;
        UrlReader reader=new UrlReader();
        try {
            reader.HtmlReader(weburl,inputFile);
            doc = Jsoup.parse(new File(inputFile),"ISO-8859-1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }


}

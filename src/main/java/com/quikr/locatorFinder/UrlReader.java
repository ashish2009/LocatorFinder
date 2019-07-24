package com.quikr.locatorFinder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlReader {


        public  void  HtmlReader(String Url,String input) throws IOException

        {

            URL obj=new URL(Url);

            //URLConnection con=obj.openConnection();

            HttpURLConnection con=(HttpURLConnection) obj.openConnection();

            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            con.setUseCaches(false);

            con.connect();

            InputStream in=con.getInputStream();

            int i;

            File file = new File(input);

            FileWriter fileWriter = new FileWriter(file, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            do

            {

                i=in.read();

                if(i!=-1)

                {

                    printWriter.print((char)i);

                }

            }while(i!=-1);

            printWriter.close();

        }

    }

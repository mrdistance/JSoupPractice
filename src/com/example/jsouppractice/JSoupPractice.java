package com.example.jsouppractice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSoupPractice {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.imdb.com/chart/top").timeout(6000).get(); //Get the webpage
        Elements body = doc.select("tbody.lister-list");                                //Get the correct part of document
        System.out.println(body.select("tr").size());                                           //Get number of tr elements

        for(Element e: body.select("tr")) {                                                     //Loop over every tr element
            String img = e.select("td.posterColumn img").attr("src");         //Grab img tag inside td element with class posterColumn, then grab src attribute in img element
            //String title = e.select("td.posterColumn img").attr("alt");                       //Get alt text from image (Title)
            String title = e.select("td.titleColumn a").text();                         //Get raw text from inside anchor element inside td with class title column
            String year = e.select("td.titleColumn span.secondaryInfo").text();         //Get raw text from inside td and span with specified classes
            String rating = e.select("td.ratingColumn.imdbRating").text();              //Get raw text from inside td with classes ratingColumn and imdbRating (td class = "ratingColumn imdbRating")
            System.out.println(img);
            System.out.println(title + " " + year + " " + rating);
        }
    }
}

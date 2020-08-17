package com.sinsy.fntp.WangyiRank;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class GetTheWangyiRankList{
     public  Document getDocument (String url){
         try {
        	 //5000是设置连接超时时间，单位ms
             return Jsoup.connect(url).timeout(5000).get();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }
     public static void main(String[] args) {
        System.out.println(new GetTheWangyiRankList().GetWangyidianji());
         }
     public String GetWangyidianji() {
    	 Document doc = new GetTheWangyiRankList().getDocument("https://news.163.com/rank/");
         // 获取目标HTML代码
         Elements e1= doc.select("[class=tabContents active]").select("table");
         String news = "";
         int count = e1.select("[class=red]").size();
         int number=1;
         for(int i = 0;i<20;i++) {
        	 Elements elements2 = e1.select("a");
        	 String today = elements2.get(i).text();
        	 System.out.println("  [ "+number+" ]  "+today);
        	 news +="  [ "+number+" ]  "+today+"\n";
        	 number++;
         }
         return news;
     }
     public String GetWangyiNo2() {
    	 Document doc = new GetTheWangyiRankList().getDocument("https://news.163.com/rank/");
         // 获取目标HTML代码
         Elements e1= doc.select("[class=tabContents active]").select("table");
         String news = "";
         int count = e1.select("[class=red]").size();
         int number=1;
         for(int i = 0;i<20;i++) {
        	 Elements elements2 = e1.select("a");
        	 String today = elements2.get(i).text();
        	 System.out.println("  [ "+number+" ]  "+today);
        	 news +="  [ "+number+" ]  "+today+"\n";
        	 number++;
         }
         return news;
     }
}
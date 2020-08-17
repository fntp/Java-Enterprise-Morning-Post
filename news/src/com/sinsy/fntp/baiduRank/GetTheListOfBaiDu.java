package com.sinsy.fntp.baiduRank;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class GetTheListOfBaiDu{
     public  Document getDocument (String url){
         try {
             return Jsoup.connect(url).timeout(5000).get();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }
     public static void main(String[] args) {
         System.out.println(new GetTheListOfBaiDu().GetNewsBySevenDays());
         }
     public String getNewsBynow(){
//       GetTheRankList t = new GetTheRankList();
       Document doc = new GetTheListOfBaiDu().getDocument("http://top.baidu.com/buzz?b=1");
       // 获取目标HTML代码
       Elements thefirstElement = doc.select("[class=list-table]");
       int count = thefirstElement.select("[class=list-title]").size();
       //今天
       int number = 1;
       String news = "";
       for(int i = 0;i<count;i++) {
      	 Elements elements2 = thefirstElement.select("[class=list-title]");
      	 String today = elements2.get(i).text();
      	 System.out.println("  [ "+number+" ]   "+today);
      	 news+="  [ "+number+" ]   "+today+"\n";
      	 number++;
       }
//       System.out.println(count);
	return news;
       }
     public String GetNewsByToday() {
    	  Document doc = new GetTheListOfBaiDu().getDocument("http://top.baidu.com/buzz?b=341&c=513&fr=topbuzz_b1_c513");
    	  Elements thefirstElement = doc.select("[class=list-table]");
    	  int count = thefirstElement.select("[class=list-title]").size();
    	  int number = 1;
          String news = "";
          for(int i = 0;i<count;i++) {
           	 Elements elements2 = thefirstElement.select("[class=list-title]");
           	 String today = elements2.get(i).text();
           	 System.out.println("  [ "+number+" ]   "+today);
           	 news+="  [ "+number+" ]   "+today+"\n";
           	 number++;
            }
     	return news;
     }
     public String GetNewsBySevenDays() {
   	  Document doc = new GetTheListOfBaiDu().getDocument("http://top.baidu.com/buzz?b=42&c=513&fr=topbuzz_b341_c513");
   	  Elements thefirstElement = doc.select("[class=list-table]");
   	  int count = thefirstElement.select("[class=list-title]").size();
   	  int number = 1;
         String news = "";
         for(int i = 0;i<count;i++) {
          	 Elements elements2 = thefirstElement.select("[class=list-title]");
          	 String today = elements2.get(i).text();
          	 System.out.println("  [ "+number+" ]   "+today);
          	 news+="  [ "+number+" ]   "+today+"\n";
          	 number++;
           }
    	return news;
    }
    /**
     * GetTheRankList t = new GetTheRankList();
         Document doc = new GetTheListOfBaiDu().getDocument("http://top.baidu.com/buzz?b=1");
         // 获取目标HTML代码
         Elements thefirstElement = doc.select("[class=list-table]");
         int count = thefirstElement.select("[class=list-title]").size();
         //今天
         int number = 1;
         for(int i = 0;i<count;i++) {
        	 Elements elements2 = thefirstElement.select("[class=list-title]");
        	 String today = elements2.get(i).text();
        	 System.out.println("  [ "+number+" ]   "+today);
        	 number++;
         }
//         System.out.println(count);
     */
}
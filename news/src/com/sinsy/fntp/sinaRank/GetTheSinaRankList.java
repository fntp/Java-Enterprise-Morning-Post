package com.sinsy.fntp.sinaRank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sinsy.fntp.WangyiRank.GetTheWangyiRankList;

public class GetTheSinaRankList {
//	http://news.sina.com.cn/hotnews/
    public  Document getDocument (String url){
        try {
       	 //5000是设置连接超时时间，单位ms
            return Jsoup.connect(url)
            		.header("cookie", "tid=6EXH//wTrRqb0tixWStVkmPcLV7+ZHkFwvhoz80GxgU=__095	;SUBP=0033WrSXqPxfM72-Ws9jqgMF55529P9D9WWx9-JcTVcjkcFeeqxPA2W9	;SINAGLOBAL=3924717167654.235.1597065831270;ULV=1597065831279:1:1:1:3924717167654.235.1597065831270:	;SL_GWPT_Show_Hide_tmp=1;SL_wptGlobTipTmp=1;SUB=_2AkMobhgqf8NxqwJRmPAWxW7jbIl0zwvEieKeMunxJRMxHRl-yT9kqhI-tRB6A-42xWJMUZAKbmj-PyOVqtIpTehOguaR;SRT=D.QqHBTrs6RcYeVdRtOeYoWr9NUPBBP3YQi-98Ndnn5eW-MdbbN-PiWdutNbHi5mYNUCsuPDbhVdYHIQMNAZSBIOAp5EW1OPPTA4k8Udfk4GbLPeErNQB4SdYLS3PY4X77%2AB.vAflW-P9Rc0lR-ykKDvnJqiQVbiRVPBtS%21r3J8sQVqbgVdWiMZ4siOzu4DbmKPWQ5D%21kNci4PcigT-iFSdPo5EBBJbVu;SRF=1597151005")
            		.header("Accept-Language", "zh-CN,zh;q=0.9")
            		.header("referer", "https://passport.weibo.com/visitor/visitor")
            		.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36")
            		.header("Connection", "keep-alive")
            		.timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String GetSinaDianji() {
   	 Document doc = new GetTheWangyiRankList().getDocument("http://news.sina.com.cn/hotnews/");
        // 获取目标HTML代码
        Elements e1= doc.select("[id=Con11]").select("table");
        String news = "";
        int count = e1.select("[class=ConsTi]").size();
        int number=1;
        for(int i = 0;i<count;i++) {
       	 Elements elements2 = e1.select("a");
       	 String today = elements2.get(i).text();
       	 System.out.println("  [ "+number+" ]  "+today);
       	 news +="  [ "+number+" ]  "+today+"\n";
       	 number++;
        }
        return news;
    }
    public static void main(String[] args) {
      	 Document doc = new GetTheWangyiRankList().getDocument("http://news.sina.com.cn/hotnews/");
         // 获取目标HTML代码
         Elements e1= doc.select("[id=Con11]").select("table");
         int count = e1.select("td").size();
         System.out.println(count);
	}
}

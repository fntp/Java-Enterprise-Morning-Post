package com.sinsy.fntp.where;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Location{
	public static void main(String[] args) {
		System.out.println(new Location().getV4IP());
		System.out.println(new Location().SplitTheJson());
//		System.out.println(new Location().loadJson("https://free-api.heweather.net/s6/weather/now?location=auto_ip&key=db86a5196f304e52a4369818c5182e60"));
//		System.out.println(new Location().SplitTheJson2(param));
	}

	public  String getV4IP(){
		String ip = "";
		String chinaz = "http://ip.chinaz.com";
		
		StringBuilder inputLine = new StringBuilder();
		String read = "";
		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedReader in = null;
		try {
			url = new URL(chinaz);
			urlConnection = (HttpURLConnection) url.openConnection();
		    in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			while((read=in.readLine())!=null){
				inputLine.append(read+"\r\n");
			}
			//System.out.println(inputLine.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
		Matcher m = p.matcher(inputLine.toString());
		if(m.find()){
			String ipstr = m.group(1);
			ip = ipstr;
			//System.out.println(ipstr);
		}
		return ip;
}
	public static String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
        	e.printStackTrace(); 
        } 
        return json.toString();
    }
	public String SplitTheJson() {
		String json=new Location().loadJson("https://free-api.heweather.net/s6/weather/now?location=auto_ip&key=db86a5196f304e52a4369818c5182e60");
		json=json.replace("{","[");
		json=json.replace("\"", "");
		json=json.replace("[HeWeather6:[[basic:[", "");
		String regex1 = ",admin_area:(.*?),";
		String regex2 = ",location:(.*?),";
		String regex3 = ",cond_txt:(.*?),";
		String regex4 = ",tmp:(.*?),";
		String location = "",weather="";
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher m = pattern1.matcher(json);
		while (m.find()) {  
            int i = 1;  
           location+=m.group(i);
            i++;  
        } 
		Pattern pattern2= Pattern.compile(regex2);
		Matcher m2 = pattern2.matcher(json);
		while (m2.find()) {  
            int i = 1;  
           location+=m2.group(i)+" ";
            i++;  
        } 
		Pattern pattern3= Pattern.compile(regex3);
		Matcher m3 = pattern3.matcher(json);
		while (m3.find()) {  
            int i = 1;  
           weather+=m3.group(i)+" ";
            i++;  
        } 
		Pattern pattern4= Pattern.compile(regex4);
		Matcher m4 = pattern4.matcher(json);
		while (m4.find()) {  
            int i = 1;  
           weather+=m4.group(i)+" ¡æ";
            i++;  
        } 
		return location+weather;
	}
	public String SplitTheJson2(String json) {
		String regex = "[(.*?)]";
		String param ="";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(json);
		while (m.find()) {  
            int i = 1;  
            param+=m.group(i)+"\n";
            i++;  
        } 
		return param;
	}
}
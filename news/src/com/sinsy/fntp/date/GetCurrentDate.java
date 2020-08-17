package com.sinsy.fntp.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentDate {
public static void main(String[] args) {
	System.out.println(new GetCurrentDate().GetDate());
	
}
 public String GetDate() {
	 Date date = new Date(); 
	 SimpleDateFormat simple = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ");
	 System.out.println(simple.format(date));  
	 return simple.format(date);
 }
}

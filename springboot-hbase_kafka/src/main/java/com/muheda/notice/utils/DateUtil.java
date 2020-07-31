package com.muheda.notice.utils;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	private static Logger log = Logger.getLogger(DateUtil.class);
	
	public static final String dtLong  = "yyyyMMddHHmmss";
	public static final String simple  = "yyyy-MM-dd HH:mm:ss";
	public static final String dtShort = "yyyyMMdd";

	public static String getOrderNum() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}

	public static String getDateFormatter() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	public static String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(date);
	}

	public static String getThree() {
		Random rad = new Random();
		return String.valueOf(rad.nextInt(1000));
	}
	public static Date String2Date(String date,String forMat) throws ParseException{
		 Date ret=null;
		 Date dateGet= new SimpleDateFormat(forMat).parse(date); 
		 String a ="yyyy-MM-dd";
		 ret=dateGet;
		return ret;
		
	}
	
	public static String addDay(Date nowDate,int dayNum,String format) throws ParseException{
		 String ret=null;
		 SimpleDateFormat sf = new SimpleDateFormat(format);
	      Date  d  =  new Date(nowDate.getTime()+24*3600*1000*dayNum);    
	      ret= sf.format(d);  
	      return ret;
	}
	
	public static String minusDay(Date nowDate, int dayNum, String forMat)  throws ParseException{
		String ret = null;
		SimpleDateFormat sFormat = new SimpleDateFormat(forMat);
		Date date = new Date(nowDate.getTime()-24*3600*1000*dayNum);
		ret = sFormat.format(date);
		return ret;
	}
	
	public static String Date2String(Date date,String forMat){
		 String ret=null;
		 ret = new SimpleDateFormat(forMat).format(date);
		 return ret;
	}

	public static void main(String[] args) throws ParseException {
		/* String forMat ="yyyy-MM-dd";
		 Date date2= DateUtil.String2Date("2005-06-09", forMat);
		 log.info(DateUtil.addDay(date2, 1, forMat));;*/
	     Date date=new Date();
	    log.info( DateUtil.Date2String(date, "yyyyMMddHHmmss"));
	    log.info( DateUtil.Date2String(date, "yyyymmdd'T'HHMMSS"));
	    log.info(DateUtil.minusDay(new Date(), 7, "yyyyMMddHHmmss"));
		 
		 
	}
	
	
	

}

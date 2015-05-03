package com.panda.base;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TimeApply中主要是关于时间的一些应用。
 * 在与Mysql数据库打交道的时候，在建表的时候一般都是使用Timestamp类即 2011-1-14 08:11:00
 * 在编程的时候，会遇到关于时间的两个类java.util.Date及java，sql.Date
 * 类间之间的转换
 * 
 * @author Administrator
 *
 */
public class TimeApply {
	
//	 1.Calendar 转化 String 
	public String calendar2String(){
		
//		Calendar类是个抽象类，因此本身不能被实例化，然而在却创建了Calendar 的对象，但并不是抽象类可以创建对象
//		这个对象并不是Calendar 自身实例，而是其子类实例，这是在getInstance方法内部其实是实例化了GregorianCalendar 对象并返回了
//		这里还反映了一种设计模式，很多模式里都用到getInstance方法来生成一对象，类中static 变量和方法可通过 类名.××访问
//		Calendar   getInstance()          使用默认时区和语言环境获得一个日历。   
//		Calendar   getInstance(Locale aLocale)          使用默认时区和指定语言环境获得一个日历。   
//		Calendar   getInstance(TimeZone zone)          使用指定时区和默认语言环境获得一个日历。   
//		Calendar   getInstance(TimeZone zone, Locale aLocale)          使用指定时区和语言环境获得一个日
		
		Calendar calendat = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendat.getTime());
	}

//	2.String 转化Calendar
	public Calendar string2Calendar(String str){
		//String str="2010-5-27";
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	 
//	Date 转化String
	public String date2String(Date time){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(time);//new Date());
	}
	 
//	String 转化Date
	public Date string2Date(){
		String str="2010-5-27";
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	 
//	Date 转化Calendar
	public Calendar date2Calendar(Date time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);//new java.util.Date());
		return calendar;
	}
	 
//	Calendar转化Date
	public Date calendar2Date(Calendar calendar){
		return (Date)calendar.getTime();
	} 
	 
//	String 转成 Timestamp
	public Timestamp string2Timestamp(String time){
		 return Timestamp.valueOf(time);//"2011-1-14 08:11:00");
	}
	 
//	Timestamp 转成 String
	public String timestamp2String(Timestamp ts){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		Timestamp ts = Timestamp.valueOf("2011-1-14 08:11:00");
		return sdf.format(ts);
	}
	 
//	Timestamp和Date多数用法是一样的。
//	Date 转 TimeStamp
	public Timestamp date2TimeStamp(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(date);
		return Timestamp.valueOf(time);
	}
	 
//	Calendar日期运算 
	public void calendrOther(){		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new java.util.Date());//设置当前日期为开始日期
		calendar.add(Calendar.YEAR, 2);   //日期加2年
		System.out.println(calendar.getTime());
		calendar.add(Calendar.DATE, -30); //日期加30天
		System.out.println(calendar.getTime());
		calendar.add(Calendar.MONTH, 3);  //日期加3个月
		System.out.println(calendar.getTime());
	}
	
	public java.sql.Date dateutil2sql(java.util.Date utildate){
		return new java.sql.Date(utildate.getTime());
	}
	public java.util.Date datesql2util(java.sql.Date sqldate){
		return new java.util.Date(sqldate.getTime());
	}
	public static void main(String[] args) {
		//...
	}
}

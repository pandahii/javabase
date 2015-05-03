package com.panda.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

/**
 * 描述：String 字符串的一些常规使用
 * 1.大小写变换！
 * 2.截断
 * 3.翻转
 * 4.转换
 * 	 1.整型转换
 * 	 2.时间转化
 * @author PDH
 */
public class StringApply {
	/**1.大小写变换！
	 * 描述：大写变小写
	 * @param 大写字符串
	 * @return 小写字符串
	 */
	public String writeBig2Small(String big){
//		if(!"null".equals(String.valueOf(big)))//类型转换，如果传入为空，转换后得到字符串null
//			return big.toLowerCase();//全字符转换为小写
//		else
//			return "null";
		return big.toLowerCase();
	}
	/**
	 * 描述：大写变小写
	 * @param 小写字符串
	 * @return 大写字符串
	 */
	public String writeSmall2Big(String small){
//		if(!"null".equals(String.valueOf(small)))//类型转换，如果传入为空，转换后得到字符串null
//			return small.toUpperCase();//全字符转换为大写
//		else
//			return "null";
		return small.toUpperCase();
	}
	//字符串截断，到目前为止我接触最多的是取扩展名，获取url中部分串
	/**2.截断
	 * 描述：获取文件扩展名
	 * @param 文件名
	 * @return
	 */
	public String getStringExtension(String str){
//		截断，取得最后.字符的为止，截断从该位置+1起之后的字符
//		if(null!=str){
//			String extension = str.substring(str.lastIndexOf(".")+1, str.length());
//			return extension;
//		}
//		else
//			return "null";
		return str.substring(str.lastIndexOf(".")+1, str.length());
	}
	public String getStringUrlHead(String url){
//		http://localhost:8080/index.html
//		String head = url.substring(0, url.indexOf("://"));
//		return head;
		return url.substring(0, url.indexOf("://"));
	}
	/**3.翻转
	 * @param str
	 * @return
	 */
	public String getStringMirror(String str){
	     StringBuffer sab=new StringBuffer(str); 
		return sab.reverse().toString();
	}
	//关于String与其他类型之间的转换，遇到常见的转换有
	//String -> int -> String
	//String -> double -> String
	//String -> date -> String
	//String -> Ob -> String 如json，这时使用到Gson这个包
	public int string2Int(String str){
		//使用之前str不为null，在此不做判断，如果str为null，那么程序将会抛出java.lang.NullPointerException异常
		return Integer.parseInt(str);
	}
	public String int2String(int i){
		//使用之前str不为null，在此不做判断，如果str为null，那么程序将会抛出java.lang.NullPointerException异常
		//使用String.valueOf(xx);xx可以为null，那么转换的字符串为“null”，直接强制转换则可能会抛出不支持类型转换异常		
		return String.valueOf(i);
	}
	public Date string2Date(String time){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			return sf.parse(time);
		} catch (ParseException e) {
			System.out.println("转换的时间--"+time+"格式不正确，请确认：yyyy-MM-dd HH:mm:ss");
			e.printStackTrace();
		}
		return null;
	}
	public String date2String(Date time){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sf.format(time);
	}
	public Tips string2Object(String json){
		//json = "{"":"","":""}"
		Gson gson = new Gson();
		return gson.fromJson(json, Tips.class);
	}
	public String object2String(Tips s){
		Gson gson = new Gson();
		return gson.toJson(s);
	}
	public static void main(String[] args) { 
		StringApply sa = new StringApply();
//		System.out.println(sa.getStringExtension(null));
//		System.out.println(sa.getStringUrlHead("https://localhost:8080/index.html"));
//		System.out.println(sa.getStringMirror("1"));
		System.out.println(sa.date2String(new Date()));
	}
	class Tips{
		private String status;
		private String msg;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public void print(){
			System.out.print("this Status :"+this.status+"\n"
						   + "this Msg    :"+this.msg+"\n");
		}
	}
	
}

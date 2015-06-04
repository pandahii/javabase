package com.panda.base;

public class YiEx {
	/*
	 * (1+10^10)
	 * 
	 * */
	
	
	public static void main(String[] args) {
		long y=10000000000L;
		String s = Long.toBinaryString(y);
		System.out.println(s+"\n"+s.length());
		int n = s.length();
		
	}
}

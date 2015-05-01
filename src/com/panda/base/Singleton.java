package com.panda.base;

/**
 * 描述：单实例
 * @author pdh
 */
public class Singleton {
	private Singleton(){}
	///在自己内部定义自己一个实例，是不是很奇怪?
	//意这是private只供内部调用
	private static Singleton instance=new Singleton();
	//这里提供了一个供外部访问本class的静态方法，可以直接访问
	public static Singleton getInstance(){
		return instance;
	}
	public static void main(String[] args) {
		
	}
}

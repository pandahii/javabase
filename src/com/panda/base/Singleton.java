package com.panda.base;

/**
 * ��������ʵ��
 * @author pdh
 */
public class Singleton {
	private Singleton(){}
	///���Լ��ڲ������Լ�һ��ʵ�����ǲ��Ǻ����?
	//������privateֻ���ڲ�����
	private static Singleton instance=new Singleton();
	//�����ṩ��һ�����ⲿ���ʱ�class�ľ�̬����������ֱ�ӷ���
	public static Singleton getInstance(){
		return instance;
	}
	public static void main(String[] args) {
		
	}
}

package com.panda.thinkinjava;

import java.util.Random;

/**
 * ʱ�临�Ӷ�ΪO��n��
 * �������ɵĶ�ά�����в���K�Ƿ����
 * @author panda
 */
public class QArray {
	int N = 10000;//N*N������ռ�ڴ�ӦС��jvm�����ڴ棬�������ʱ���׳�jvm�ڴ治���쳣
	Random ran = new Random();
	
	/**
	 * �����������ɵĶ�ά����
	 * @return
	 */
	public int[][] createArray(){
		int[][] arr = null;
		arr=new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr[i][j] = ran.nextInt(9)+1;
				if(i>0&&j>0)
					arr[i][j] += arr[i-1][j] > arr[i][j-1] ? arr[i-1][j] : arr[i][j-1];
				else if(i==0&&j>0)
					arr[i][j] += arr[i][j-1]; 
				else if(i>0&&j==0)
					arr[i][j] += arr[i-1][j];
			}
		}
		return arr;
	}
	
	public void p(int[][] arr){
		int n = arr.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
	}
	
	/**
	 * ��������arr�Ƿ����k
	 * @param arr
	 * @param k
	 */
	public void search(int[][] arr,int k){
//		p(arr);
		if(null==arr){
			System.out.println("����Ϊ��");
			return;
		}
		int x = arr.length-1,y=0,n=0;
		//int k = ran.nextInt(arr[x][x]);
		long star = new java.util.Date().getTime();
		while(x>=0&&y<arr.length){
//			System.out.println(x+","+y);
			if(arr[x][y]>k)
				x--;
			else if(arr[x][y]<k)
				y++;
			else{	
				n++;
				System.out.println("����"+n+"����arr["+x+"]["+y+"]=k="+arr[x][y]+"="+k);
				x--;
				y++;
			}
		}
		long end = new java.util.Date().getTime();
		if(n==0){
			System.out.println("������"+n+"����arr[][]=k="+k);
		}
//		System.out.println("��ʱ "+end+"-"+star+"="+((end-star)));
	}
	
	public static void main(String[] args) {
		QArray q = new QArray();
		int [][] arr = {};
		q.search(arr,10);
		q.search(q.createArray(),10);
		q.search(q.createArray(),-1);
		q.search(null,10);
	}
}

package com.panda.thinkinjava;

import java.util.Random;

/**
 * 时间复杂度为O（n）
 * 递增规律的二维数组中查找K是否存在
 * @author panda
 */
public class QArray {
	int N = 10000;//N*N矩阵所占内存应小于jvm运行内存，矩阵过大时将抛出jvm内存不足异常
	Random ran = new Random();
	
	/**
	 * 创建递增规律的二维数组
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
	 * 搜索数组arr是否存在k
	 * @param arr
	 * @param k
	 */
	public void search(int[][] arr,int k){
//		p(arr);
		if(null==arr){
			System.out.println("数组为空");
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
				System.out.println("存在"+n+"数组arr["+x+"]["+y+"]=k="+arr[x][y]+"="+k);
				x--;
				y++;
			}
		}
		long end = new java.util.Date().getTime();
		if(n==0){
			System.out.println("不存在"+n+"数组arr[][]=k="+k);
		}
//		System.out.println("耗时 "+end+"-"+star+"="+((end-star)));
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

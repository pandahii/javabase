package com.panda.thinkinjava;

public class BinPrint {
	public static void pBinInt(String s, int i) {
	   System.out.println(
	     s + ", int: " + i + ", binary: ");
	   System.out.print("   ");
	   pBinInt(i);
	 }
	public static void pBinInt(int i) {
		for(int j = 31; j >=0; j--){
			if(((1 << j) &  i) != 0)
				System.out.print("1");
		     else
		       System.out.print("0");
			if(j%4==0)
				System.out.print(" ");
		}
		System.out.println();
	}
	public static void pBinLong(String s, long l) {
	   System.out.println(
	     s + ", long: " + l + ", binary: ");
	   System.out.print("   ");
	   pBinLong(l);
	 }
	public static void pBinLong(long l) {
		for(int i = 63; i >=0; i--){
			if(((1L << i) & l) != 0)
				System.out.print("1");
			else
				System.out.print("0");
			if(i%4==0)
				System.out.print(" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		java.util.Random rand = new java.util.Random();
	    int i = rand.nextInt();
	    int j = rand.nextInt();
	    pBinInt("-1", -1);
	    pBinInt("+1", +1);
	    int maxpos = 2147483647;
	    pBinInt("maxpos", maxpos);
	    int maxneg = -2147483648;
	    pBinInt("maxneg", maxneg);
	    pBinInt("i", i);
	    pBinInt("~i", ~i);
	    pBinInt("-i", -i);
	    pBinInt("j", j);
	    pBinInt("i & j", i & j);
	    pBinInt("i | j", i | j);
	    pBinInt("i ^ j", i ^ j);
	    pBinInt("i << 5", i << 5);
	    pBinInt("i >> 5", i >> 5);
	    pBinInt("(~i) >> 5", (~i) >> 5);
	    pBinInt("i >>> 5", i >>> 5);
	    pBinInt("(~i) >>> 5", (~i) >>> 5);

	    long l = rand.nextLong();
	    long m = rand.nextLong();
	    pBinLong("-1L", -1L);
	    pBinLong("+1L", +1L);
	    long ll = 9223372036854775807L;
	    pBinLong("maxpos", ll);
	    long lln = -9223372036854775808L;
	    pBinLong("maxneg", lln);
	    pBinLong("l", l);
	    pBinLong("~l", ~l);
	    pBinLong("-l", -l);
	    pBinLong("m", m);
	    pBinLong("l & m", l & m);
	    pBinLong("l | m", l | m);
	    pBinLong("l ^ m", l ^ m);
	    pBinLong("l << 5", l << 5);
	    pBinLong("l >> 5", l >> 5);
	    pBinLong("(~l) >> 5", (~l) >> 5);
	    pBinLong("l >>> 5", l >>> 5);
	    pBinLong("(~l) >>> 5", (~l) >>> 5);
	}
}

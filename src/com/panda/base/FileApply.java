package com.panda.base;

/**
 * 基本的文件操作，如新建文件夹（判断是否为空），查找文件，列出dir下的全部路径等！
 * @author PDH
 *
 */
public class FileApply {
	
	/**新建文件
	 * @param filename
	 * @param dir
	 * @return
	 */
	public boolean newFile(String filename,String dir){
		
		return false;
	}
	/**
	 * @param path 全路径，包活文件名
	 * @return
	 */
	public boolean newFile(String path){
		String filename = path.substring(path.lastIndexOf("/")+1, path.length());
		path = path.substring(0,path.lastIndexOf("/")+1);

		return false;
	}
	public static void main(String[] args) {
		new FileApply().newFile("d:/sd/dd/qq.js");
	}
}

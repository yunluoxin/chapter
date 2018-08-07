package com.dadong.test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by dadong on 2018/8/7.
 */
public class IODemo {
	public static String getStackTrace(Exception e){
		StringWriter stringWriter = new StringWriter() ;
		PrintWriter printWriter = new PrintWriter(stringWriter) ;
		e.printStackTrace(printWriter) ;
		return stringWriter.toString() ;
	}

	public static void main(String args[]){
		try {
			throw  new RuntimeException("test") ;
		}catch (Exception e){
			String trace = IODemo.getStackTrace(e) ;
			System.out.println(trace);
		}


		// 这种写法，能定位错误的位置
		System.out.println("com.dadong.test.Interview.main(Interview.java:19)");
	}
}


package com.dadong.test;

/**
 * Created by dadong on 2018/8/10.
 */
public class MethodAreaDemo {
	public static void main(String args[]){
		String a = new StringBuilder("dadong").append("deImac").toString() ;
		System.out.println(a.intern() == a) ;

		String b = new StringBuilder("ja").append("va").toString() ;
		System.out.println(b.intern() == b) ;


	}
}

package com.dadong.test;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dadong on 2018/8/6.
 */
public class RTTI {
	static {
		System.out.println("RTTI被初始化") ;
	}
	public RTTI(){
		super();
	}
	public static void main(String args[]){
		Method[] methods = RB.class.getMethods() ;
		for (Method method : methods){
//			System.out.println(method);
			Pattern pattern = Pattern.compile("\\w+\\.") ;
			System.out.println(pattern.matcher(method.toString()).replaceAll(""));
		}

		System.out.println("\n-----------------\n");

		// 类里直接字面上有的，不包括继承的。 （重写的是包括的，也算是类里字面上直接有的）
		Method[] methods2 = RB.class.getDeclaredMethods() ;
		for (Method method : methods2){
//			System.out.println(method);
			Pattern pattern = Pattern.compile("\\w+\\.") ;
			System.out.println(pattern.matcher(method.toString()).replaceAll(""));
		}

		System.out.println("\n-----------------\n");

		Method[] methods3 = RTTI.class.getMethods() ;
		for (Method method : methods3){
//			System.out.println(method);

			Pattern pattern = Pattern.compile("\\w+\\.") ;
			System.out.println(pattern.matcher(method.toString()).replaceAll(""));
		}

		System.out.println("\n-----------------\n");

		String a = "com.dadong.fly.to.xiamen" ;
		Pattern pattern = Pattern.compile("\\w+\\.") ;
		System.out.println("full match: " + pattern.matcher(a).matches());
		Matcher matcher = pattern.matcher(a) ;
		boolean f = matcher.find() ;
		System.out.println("find result: " + f);
		System.out.println("group count: " + matcher.groupCount());
		System.out.println("looking at: " + matcher.lookingAt());

		// group(0)不包括在groupCount里面。。。。
		// 必须要用matcher.find()之后，才能用group()获得。否则会出错。
		matcher.reset() ;
		while (matcher.find()){
//			System.out.println(matcher.groupCount());
			System.out.println(matcher.group());
		}
	}
}

interface RA {
	void run() ;
	default void d(){

	}
}
class RC {
	protected void a() {
		System.out.println("RC protect method a()");
	}
}
class RB extends RC implements RA {

	@Override
	public void run() {
		System.out.println("RB public method run()");
	}

	private void test(){
		System.out.println("RB private method test()");
	}

	void t(){
		System.out.println("RB package method t()");
	}

//	@Override
//	protected void a() {
//		super.a();
//	}
}
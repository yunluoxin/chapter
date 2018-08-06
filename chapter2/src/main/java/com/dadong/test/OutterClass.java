package com.dadong.test;

/**
 * Created by dadong on 2018/8/4.
 */
public class OutterClass {
	static class InnerClass implements Inner{
		@Override
		public String toString() {
			return "static Inner Class";
		}
	}
	public static Inner inner(){
		return new InnerClass() ;
	}

	class InnerClass2 implements Inner {
		@Override
		public String toString() {
			return OutterClass.this + " Inner Class 2";
		}
	}

	public Inner inner2(){
		return new InnerClass2() ;
	}


	public static void main(String args[]){
		// 静态内部类
		OutterClass.InnerClass i = new OutterClass.InnerClass() ;
		System.out.println(i);

		// 用实例方法返回内部类
		OutterClass outterClass = new OutterClass() ;
		Inner i2 = outterClass.inner2() ;
		System.out.println(i2);

		// 直接创建内部类
		OutterClass.InnerClass2 i3 = outterClass.new InnerClass2() ;
		System.out.println(i3);
	}
}

interface Inner {
	String toString() ;
}

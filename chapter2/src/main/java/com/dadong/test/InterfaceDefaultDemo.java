package com.dadong.test;

/**
 * Created by dadong on 2018/8/2.
 */
public class InterfaceDefaultDemo {
	public static void main(String args[]){
		InterfaceA a = new A() ;
		a.firstWork();
		a.secondWork();

		InterfaceC c = new C() ;
		c.firstWork();
		c.secondWork();
		System.out.println(c.TEST_INT);

		InterfaceC b = new B() ;
		b.firstWork();
		b.secondWork();
	}
}

interface InterfaceA {
	default void firstWork(){
		System.out.println("interface A first Work");
	}
	void secondWork() ;
}

interface InterfaceB {
	int TEST_INT = 5 ;
}

interface InterfaceC extends InterfaceA, InterfaceB {
	@Override
	default void secondWork(){
		System.out.println("interface C second Work");
	}
}

class A implements InterfaceA {

	public void secondWork() {
		System.out.println("class A second Work");
	}
}

class C implements InterfaceC {

}

class B implements InterfaceC {
	@Override
	public void secondWork() {
		System.out.println("class B second work");
	}
}
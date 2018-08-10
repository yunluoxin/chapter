package com.dadong.test;

/**
 * Created by dadong on 2018/8/10.
 * finalize()只有一次自救的机会， finalize只能被执行一次
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC save_hook = null ;

	public void isAlive(){
		System.out.println("yes, i am still alive") ;
	}

	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizeEscapeGC.save_hook = this ;
	}

	public static void main(String args[]) throws InterruptedException {
		save_hook = new FinalizeEscapeGC() ;
		save_hook = null ;

		System.gc();

		// 休眠0.5s让GC有时间执行，因为finalizer线程优先级很低
		Thread.sleep(500) ;

		if (save_hook != null){
			save_hook.isAlive();
		}else {
			System.out.println("no, i am dead :(");
		}

		save_hook = null ;
		System.gc();
		Thread.sleep(500) ;

		if (save_hook != null){
			save_hook.isAlive();
		}else {
			System.out.println("no, i am dead :(");
		}

		System.out.println("---------------");

		NoFinalizeMethod.instance = new NoFinalizeMethod() ;
		NoFinalizeMethod.instance = null ;
		System.gc();
		Thread.sleep(500) ;
		System.out.println(NoFinalizeMethod.instance);
		NoFinalizeMethod.instance = null ;
		System.gc();
		Thread.sleep(500) ;
		System.out.println(NoFinalizeMethod.instance);
	}
}

class NoFinalizeMethodParent {
	protected void finalize() throws Throwable {		// finalize方法只能被对象调用一次！
		super.finalize();
		System.out.println("parent finalize method executed!");
		this.overrideMethod() ;
	}
	public void overrideMethod(){
		System.out.println("parent overrideMethod");
	}
}

class NoFinalizeMethod extends NoFinalizeMethodParent {
	public static NoFinalizeMethod instance = null ;
	public void isAlive(){
		System.out.println("yes, i am still alive") ;
	}
	public void overrideMethod(){
		System.out.println("children overrideMethod");
		instance = this ;
	}
}
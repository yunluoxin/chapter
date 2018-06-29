package com.dadong.user.service;

/**
 * Created by dadong on 2018/6/26.
 */
public class ThreadLocalTest {

	ThreadLocal<String> threadName = new ThreadLocal<String>() ;

	public static void main(String args[]) throws InterruptedException {

		final ThreadLocalTest test = new ThreadLocalTest() ;
		test.threadName.set(Thread.currentThread().getName());
		System.out.println(test.threadName.get());

		Thread thread = new Thread() {
			public void run() {
				test.threadName.set(Thread.currentThread().getName());
				System.out.println(test.threadName.get());
			}
		} ;
		thread.start();
		thread.join();
		System.out.println(test.threadName.get());
	}
}

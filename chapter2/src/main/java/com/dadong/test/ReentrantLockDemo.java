package com.dadong.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dadong on 2018/8/4.
 */
public class ReentrantLockDemo {
	private Lock lock = new ReentrantLock() ;

	public void test1 () throws InterruptedException {
		System.out.println("test1 start") ;
		lock.lock();
		System.out.println("test1 before invoke test2 " + lock) ;
		this.test2();
		System.out.println("test1 after invoke test2 " + lock) ;

		final ReentrantLockDemo demo = this ;
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.test2();
			}
		}).start(); ;
		Thread.sleep(1000);
		lock.unlock();
		System.out.println("test1 end, unlock " + lock) ;
	}
	public void test2 (){
		lock.lock();
		System.out.println("test2 " + lock) ;
		lock.unlock();
	}

	public void acrossMethodLock(){
		lock.lock();
		System.out.println("acrossMethodLock") ;
	}

	public void acrossMethodUnlock(){
		lock.unlock();
		System.out.println(lock) ;
	}

	public static void main(String args[]) throws InterruptedException {
		ReentrantLockDemo demo = new ReentrantLockDemo() ;
		demo.test1();

		demo.acrossMethodLock();
		demo.acrossMethodUnlock();
	}

}

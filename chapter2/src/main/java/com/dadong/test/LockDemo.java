package com.dadong.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dadong on 2018/8/4.
 */
public class LockDemo {

	public static void main(String args[]){
		new Thread(new Runnable() {
			@Override
			public void run() {
				ClassLock lock = new ClassLock("dadong") ;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.instanceMethod();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				ClassLock.staticMethod();
			}
		}).start();
	}

	public static void test1 (){
		Account account = new Account() ;
		account.setMoney(10000d) ;

		ExecutorService executorService = Executors.newFixedThreadPool(20) ;
		int i = 0 ;
		while (i < 1000){
			final int finalI = i ;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					synchronized (account){
						if (account.getMoney() >= 100){
							try {
								Thread.sleep(1) ;
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							account.setMoney(account.getMoney() - 100 );
						}
					}
					System.out.println("The money in account is " + account.getMoney());
				}
			});
			i++ ;
		}
		executorService.shutdown();
	}

	public static void test2(){
		/**
		 * 方法锁的本质就是锁住当前的对象引用。所以哪怕你执行的是对象的其他同步方法，也会被锁住！而不是我以前理解的只锁住某个方法
		 */
		Account account = new Account() ;
		new Thread(new Runnable() {
			@Override
			public void run() {
				account.takeLongTime();
			}
		}).start(); ;
		new Thread(new Runnable() {
			@Override
			public void run() {
				account.canIBeDone();
			}
		}).start(); ;
		new Thread(new Runnable() {
			@Override
			public void run() {
				account.notSynMethod();
			}
		}).start(); ;
		//----------------------------------------------------------------//
	}
}


class Account {
	private Double money ;

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public synchronized void canIBeDone(){
		System.out.println("I can be done");
	}

	public synchronized void takeLongTime(){
		System.out.println("即将休眠5秒");
		try {
			Thread.sleep(5000) ;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("休眠5秒完毕");
	}

	public void notSynMethod(){
		System.out.println("notSynMethod can be done in the same time!");
	}


	private byte[] bytes = new byte[0] ; // 特殊的instance变量
	// 代码块加锁方式（利用一个额外的对象）
	public void codeLock(){
		synchronized (bytes){

		}
	}
}


class ClassLock {
	private String name ;
	public ClassLock(String name){
		synchronized (this.getClass()){
			this.name = name ;
			System.out.println("constructor for " + name);
		}
	}

	public synchronized static void staticMethod(){
		System.out.println("this is a static method!");
		System.out.println("即将休眠5秒");
		try {
			Thread.sleep(3000) ;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("休眠5秒完毕");
	}

	public synchronized void instanceMethod(){
		System.out.println("this is a instance method!");

		// 获得了锁的对象，是可以重入另外一个锁的
		this.reEntranceLock();
	}

	public synchronized void reEntranceLock(){
		System.out.println("reEntrance lock");
	}
}

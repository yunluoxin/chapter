package com.dadong.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dadong on 2018/8/1.
 * synchorized是否能被自己重入   ----   从Demo看是可以的
 */
public class SynchorizeDemo {
	public int anInt = 0 ;
	public static void main(String args[]){
		final SynchorizeDemo demo = new SynchorizeDemo() ;
		ExecutorService executorService = Executors.newFixedThreadPool(20) ;
		for (int i = 0 ; i < 1000 ; i++){
			final int finalI = i ;
			executorService.submit(new Runnable() {
				public void run() {
					synchronized (demo) {
						System.out.println("first level: [" + finalI + "]");
						demo.anInt ++ ;
						synchronized (demo) {
							System.out.println("second level: [" + finalI + "]");
							demo.anInt ++ ;
						}
					}
				}
			});
		}
		executorService.shutdown();
	}
}

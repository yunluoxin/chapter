package com.dadong.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by dadong on 2018/7/28.
 */
public class MyCallable implements Callable<Integer> {
	private int upperBounds ;
	public MyCallable(int upperBounds){
		this.upperBounds = upperBounds ;
	}
	public Integer call() throws Exception {
		int sum = 0 ;
		for (int i = 0 ; i < upperBounds ; i++){
			sum += i ;
		}
		return sum ;
	}

	public static void main(String args[]) throws ExecutionException, InterruptedException {
		List<Future<Integer>> list = new ArrayList<Future<Integer>>() ;
		ExecutorService executorService = Executors.newFixedThreadPool(100) ;
		for (int i = 0 ; i <= 100 ; i++){
			Future<Integer> future = executorService.submit(new MyCallable(i)) ;
			list.add(future) ;
		}
		executorService.shutdown();
		int sum = 0 ;
		for (Future<Integer> future : list){
			sum += future.get() ;
		}
		System.out.println(sum);


//		for (int i = 0 ; i <= 100; i++){
//			executorService.execute(new MyCallable(i)) ;  // Callable接口不是集成于Runable
//		}
	}
}

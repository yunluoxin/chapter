package com.dadong.test;

import org.apache.logging.log4j.core.filter.ThresholdFilter;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by dadong on 2018/7/28.
 * 类似分治的思维，把大任务分解成小任务
 */
class Calculator extends RecursiveTask<Long>{

	private static final int THRESHOLD = 10000000 ;
	private int start  ;
	private int end  ;

	public Calculator(int start, int end){
		this.start = start ;
		this.end = end ;
	}

	protected Long compute() {
		long sum = 0 ;
		if (end - start <= THRESHOLD){
			for (int i = start ; i <= end ; i++){
				sum += i ;
			}
			return sum ;
		}
		//将任务一分为2
		int middle = (start + end) >>> 1 ;
		Calculator concurrent1 = new Calculator(start, middle) ;
		Calculator concurrent2 = new Calculator(middle + 1, end) ;
		concurrent1.fork() ;
		concurrent2.fork() ;

		return concurrent1.join() + concurrent2.join() ;
	}

}

public class DemoConcurrent {
	public static void main(String args[]) throws ExecutionException, InterruptedException {
		int total = 1999999999 ;
		long start = new Date().getTime() ;
		ForkJoinPool pool = new ForkJoinPool() ;
		Future<Long> result = pool.submit(new Calculator(1, total)) ;
		System.out.println(result.get());
		long end = new Date().getTime() ;
		System.out.println("耗时"+(end-start)+"ms") ;

		start = new Date().getTime() ;
		long sum = 0 ;
		for (int i = 1 ; i <= total; i ++){
			sum += i ;
		}
		end = new Date().getTime() ;
		System.out.println("耗时"+(end-start)+"ms") ;
	}
}

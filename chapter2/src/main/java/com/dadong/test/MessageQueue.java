package com.dadong.test;

import java.beans.Transient;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by dadong on 2018/7/28.
 */
public class MessageQueue implements Runnable{
	private static BlockingQueue<Task> queue = new LinkedBlockingQueue<Task>() ;
	static {
		ExecutorService executorService = Executors.newFixedThreadPool(1) ;
		executorService.execute(new MessageQueue()) ;
		executorService.shutdown();
	}
	public static void addTask(Task task) {
		try {
			queue.put(task) ;
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true){
			try {
				Task task = queue.poll(5, TimeUnit.SECONDS) ;
				if (task != null){
					System.out.println(task.name) ;
				}else {
					break ;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				break ;
			}
		}
	}

	static class Task {
		private String name ;
		private int type ;

		public Task (String name, int type){
			this.name = name ;
			this.type = type ;
		}
	}

	public static void main(String args[]) throws InterruptedException {
		for (int i = 0 ; i < 100 ; i ++){
			String name = "task " + i ;
			Task task = new Task(name, 0) ;
			MessageQueue.addTask(task) ;
//			Thread.sleep(500);
		}
	}
}

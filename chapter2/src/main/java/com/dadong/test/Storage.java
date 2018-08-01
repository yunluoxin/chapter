package com.dadong.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dadong on 2018/8/1.
 */
public class Storage {
	private List list = new ArrayList<Integer>() ;
	private static final int MAX_SIZE = 5 ;
	public void produce(String producer){
		synchronized (list){
			if (list.size() == MAX_SIZE){
				System.out.println("满了，" + producer + "需要等一等");
				try {
					list.wait();
					this.produce(producer);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				list.add(Integer.valueOf((int)Math.random())) ;
				System.out.println("producer:"+ producer +" 生产了产品，当前产品个数:" + list.size());
				list.notify();
			}
		}
	}

	public void consume(String consumer){
		synchronized (list){
			if (list.size() == 0){
				System.out.println("当前已经空了," + consumer + "请稍等");
				try {
					list.wait();
					this.consume(consumer) ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				list.remove(list.size() - 1) ;
				System.out.println("consumer:" + consumer + "消费了一个产品，剩余存储量为" + list.size());
				list.notify();
			}
		}
	}

	public static void main(String args[]){
//		final Storage storage = new Storage() ;
		final Storage2 storage = new Storage2() ;
		for (int i = 0 ; i < 110 ; i ++){
			final int finalI = i ;
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					storage.produce("producer"+ finalI);
				}
			}).start();
		}

		for (int i = 0 ; i < 111 ; i ++){
			final int finalI = i ;
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(120);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					storage.consume("consumer"+ finalI);
				}
			}).start();
		}
	}
}

class Storage2 {
	private List list = new ArrayList<Integer>() ;
	private static final int MAX_SIZE = 5 ;
	public void produce(String producer){
		synchronized (list){
			while (true){
				if (list.size() == MAX_SIZE){
					System.out.println("满了，" + producer + "需要等一等");
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					break ;
				}
			}
			list.add(Integer.valueOf((int)Math.random())) ;
			System.out.println("producer:"+ producer +" 生产了产品，当前产品个数:" + list.size());
			list.notifyAll(); // 看下面的备注
		}
	}

	public void consume(String consumer){
		synchronized (list){
			while (true){
				if (list.size() == 0){
					System.out.println("当前已经空了," + consumer + "请稍等");
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					break ;
				}
			}

			list.remove(list.size() - 1) ;
			System.out.println("consumer:" + consumer + "消费了一个产品，剩余存储量为" + list.size());
			list.notifyAll();    // 经测试，发现必须置为notifyAll ,否则可能出现。 某个线程调用唤醒notify后，只是唤醒了另外一个，也不符合条件的！继续是wait状态。就进入都在待唤醒状态了

		}
	}
}

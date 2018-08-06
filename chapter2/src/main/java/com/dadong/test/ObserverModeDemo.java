package com.dadong.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dadong on 2018/8/2.
 * "发布订阅者模式" 也叫 "观察者模式"
 * 记 南威的笔试试题
 */
public class ObserverModeDemo {

	interface Observer {
		String getName() ;
		void notifyAllObservers() ;
		void addObserver(Subject subject) ;
		boolean removeObserver(Subject subject) ;
	}

	interface Subject {
		String getName() ;
		void doAfterReceivingNotification(Observer observer) ;
	}

	static class BroadCast implements Observer {

		private List<Subject> subjects = new ArrayList<Subject>() ;

		private String name ;

		public String getName() {
			return name ;
		}

		public BroadCast(String name){
			this.name = name ;
		}

		public void notifyAllObservers() {
			for (Subject subject : subjects){
				subject.doAfterReceivingNotification(this) ;
			}
		}

		public void addObserver(Subject subject) {
			subjects.add(subject) ;
			System.out.println(subject.getName() + "订阅了") ;
		}

		public boolean removeObserver(Subject subject) {
			return subjects.remove(subject) ;
		}
	}

	static class Consumer implements Subject {
		private String name ;

		public String getName() {
			return name ;
		}

		public Consumer(String name){
			this.name = name ;
		}

		public void doAfterReceivingNotification(Observer observer) {
			System.out.println(this.name + "收到" + observer.getName()) ;
		}
	}


	public static void main(String args[]){
		Observer broadCast = new BroadCast("publisher") ;

		Subject consumer1 = new Consumer("consumer1") ;
		Subject consumer2 = new Consumer("consumer2") ;

		broadCast.addObserver(consumer1) ;
		broadCast.addObserver(consumer2) ;

		broadCast.notifyAllObservers() ;

		Subject consumer3 = new Consumer("consumer3") ;
		broadCast.addObserver(consumer3) ;
		broadCast.notifyAllObservers() ;

		System.out.println("即将移除订阅者");
		broadCast.removeObserver(consumer1) ;
		broadCast.notifyAllObservers();

	}
}

package com.dadong.model;

/**
 * Created by dadong on 2018/6/22.
 */
public class NaiveWaiter implements Waiter {
	public void greetTo(String name) {
		System.out.println("greet to " + name + "...");
	}
	public void serveTo(String name) {
		System.out.println("serve to " + name + "...");
	}
}

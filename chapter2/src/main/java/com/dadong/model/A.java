package com.dadong.model;

/**
 * Created by dadong on 2018/6/22.
 */
public class A {
	private String name ;

	private Integer age ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "A{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

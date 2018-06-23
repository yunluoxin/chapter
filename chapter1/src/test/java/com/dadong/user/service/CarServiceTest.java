package com.dadong.user.service;

import com.dadong.user.domain.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by dadong on 2018/6/23.
 */

public class CarServiceTest extends BaseTestService {
	@Autowired
	private CarService carService ;

	@Test
	public void testInsert(){
		Car car = new Car() ;
		car.setName("宝马X5");
		car.setPrice(150000d);
		car.setDescription("非常高档的车子");
		this.carService.insertCar(car) ;
	}

	@Test
	public void testSelect(){
		Car car = this.carService.selectById(7) ;
		System.out.println(car) ;
	}
}

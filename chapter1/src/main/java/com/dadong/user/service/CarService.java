package com.dadong.user.service;

import com.dadong.user.dao.impl.CarDao;
import com.dadong.user.domain.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dadong on 2018/6/23.
 */
@Service
public class CarService {

	@Autowired
	private CarDao carDao ;

	public Car selectById(Integer carId) {
		return this.carDao.selectById(carId) ;
	}

	public void insertCar(Car car) {
		this.carDao.insertCar(car); ;
	}
}

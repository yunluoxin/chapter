package com.dadong.user.dao.impl;

import com.dadong.user.domain.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by dadong on 2018/6/23.
 */
@Repository
public class CarDao {

	@Autowired
	private HibernateTemplate template ;

	public Car selectById(Integer carId) {
		Car car = template.get(Car.class, carId) ;
		return car ;
	}

	public void insertCar(Car car){
		template.save(car) ;
	}
}

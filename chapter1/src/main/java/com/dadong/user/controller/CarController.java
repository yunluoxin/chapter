package com.dadong.user.controller;

import com.dadong.user.domain.Car;
import com.dadong.user.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dadong on 2018/6/23.
 */
@Controller
@RequestMapping(value = "/car")
public class CarController {

	@Autowired
	private CarService carService ;
	@RequestMapping(value = "/detail.html")
	public ModelAndView detail(Integer carId){
		Car car = this.carService.selectById(carId) ;
		ModelAndView modelAndView = new ModelAndView() ;
		modelAndView.getModel().put("car",car) ;
		modelAndView.setViewName("car-detail"); ;
		return modelAndView ;
	}
}

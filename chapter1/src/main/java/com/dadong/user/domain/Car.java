package com.dadong.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dadong on 2018/6/23.
 */
@Entity
@Table(name = "t_car")
public class Car implements Serializable {
	@Id
	@Column(name = "car_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer carId ;

	@Column(name = "name")
	private String name ;

	@Column(name = "price")
	private Double price ;

	@Column(name = "description")
	private String description ;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Car{" +
				"carId=" + carId +
				", name='" + name + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				'}';
	}
}

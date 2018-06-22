package com.dadong.model;

/**
 * Created by dadong on 2018/6/22.
 */
public class B {
	private Double totalMoney ;

	private Double used ;

	private Double letf ;

	@Override
	public String toString() {
		return "B{" +
				"totalMoney=" + totalMoney +
				", used=" + used +
				", letf=" + letf +
				'}';
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Double getUsed() {
		return used;
	}

	public void setUsed(Double used) {
		this.used = used;
	}

	public Double getLetf() {
		return letf;
	}

	public void setLetf(Double letf) {
		this.letf = letf;
	}
}

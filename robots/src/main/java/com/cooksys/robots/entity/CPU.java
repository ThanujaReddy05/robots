package com.cooksys.robots.entity;

import javax.persistence.Embeddable;

@Embeddable
public class CPU {

	private Integer processingPower;
	private Integer cores;
	
	public Integer getProcessingPower() {
		return processingPower;
	}
	public void setProcessingPower(Integer processingPower) {
		this.processingPower = processingPower;
	}
	public Integer getCores() {
		return cores;
	}
	public void setCores(Integer cores) {
		this.cores = cores;
	}
	
}

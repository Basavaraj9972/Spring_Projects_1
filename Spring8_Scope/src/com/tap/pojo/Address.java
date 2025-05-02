package com.tap.pojo;

public class Address {
	private int laneNum;
	private String city;
	private String state;
	private String country;
	public Address() {

	}
	public Address(int laneNum, String city, String state, String country) {
		super();
		this.laneNum = laneNum;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public int getLaneNum() {
		return laneNum;
	}
	public void setLaneNum(int laneNum) {
		this.laneNum = laneNum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return laneNum+" "+city+" "+state+" "+country;
	}
}

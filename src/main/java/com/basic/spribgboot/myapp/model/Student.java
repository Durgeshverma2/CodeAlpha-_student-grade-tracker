package com.basic.spribgboot.myapp.model;

public class Student{
	private String name;
	private int id;
	private double number;
	private String sex;
	private String city;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Student(String name, int id, double number, String sex, String city) {
		super();
		this.name = name;
		this.id = id;
		this.number = number;
		this.sex = sex;
		this.city = city;
	}
	
	public Student()
	{
		
	}

	
}

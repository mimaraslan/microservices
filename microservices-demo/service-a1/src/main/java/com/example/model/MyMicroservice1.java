package com.example.model;

public class MyMicroservice1 {

	private String name;
	private int id;

	public MyMicroservice1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "MyMicroervice1 [name=" + name + ", id=" + id + "]";
	}
}
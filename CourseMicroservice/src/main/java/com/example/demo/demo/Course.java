package com.example.demo.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "muda")
	private int muda;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMuda() {
		return muda;
	}

	public void setMuda(int muda) {
		this.muda = muda;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
	
	
	
}

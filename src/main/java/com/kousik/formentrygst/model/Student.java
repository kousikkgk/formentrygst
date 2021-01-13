package com.kousik.formentrygst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

@Id
@GeneratedValue
private Long id;

@Column(name = "name")
private String name;

@Column(name = "age")
private int age;

public Student() {}
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
}

// getters setters



 }
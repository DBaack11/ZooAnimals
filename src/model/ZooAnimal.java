/***************************************************************
 * Name : ZooAnimal.java
 * Author: Devin Baack 
 * Created : 02/11/2021 
 * Course: CIS 175 - Java II
 * Version: 10.15.7 
 * OS: macOS Catalina 
 * IDE: Eclipse 2020-06
 * Copyright : This is my own original work based on specifications 
 * issued by our instructor 
 * Description : This program represents a ZooAnimal Object.
 * Academic Honesty: I attest that this is my original work. I have
 * not used unauthorized source code, either modified or unmodified. 
 * I have not given other fellow student(s) access to my program.
 ***************************************************************
 */
package model;

/**
 * @author Devin Baack - dfbaack
 * CIS175 - Spring 2021
 * Feb 11, 2021
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ZooAnimals")
public class ZooAnimal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ANIMAL")
	private String animal;
	@Column(name="GENDER")
	private String gender;
	@Column(name="AGE")
	private int age;
	
	public ZooAnimal() {
		super();
	}
	
	public ZooAnimal(String animal, String gender, int age) {
		super();
		this.setAnimal(animal);
		this.setGender(gender);
		this.setAge(age);
	}

	
	
	public ZooAnimal(int id, String animal, String gender, int age) {
		super();
		this.setId(id);
		this.setAnimal(animal);
		this.setGender(gender);
		this.setAge(age);
	}

	public String getAnimal() {
		return animal;
	}
	
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ZooAnimal [id=" + this.getId() + ", animal=" + this.getAnimal() + ", gender=" + this.getGender() + ", age=" + this.getAge() + "]";
	}

	/**
	 * @return
	 */
	public String returnAnimalDetails() {
		return this.toString();
	}

	
	
	
}

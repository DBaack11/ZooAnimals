/**
 * 
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Devin Baack - dfbaack
 * CIS175 - Spring 2021
 * Mar 4, 2021
 */
@Entity
@Table(name="ZooKeepers")
public class ZooKeeper {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="DEPARTMENT")
	private String department;
	
	public ZooKeeper() {
		super();
	}
	
	public ZooKeeper(int id, String name, String department) {
		this.setId(id);
		this.setName(name);
		this.setDepartment(department);
	}
	
	public ZooKeeper(String name, String department) {
		this.setName(name);
		this.setDepartment(department);
	}
	
	public ZooKeeper(String name) {
		this.setName(name);
		this.setDepartment("General Staff");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "ZooKeeper [id=" + this.getId() + ", name=" + this.getName() + ", department=" + this.getDepartment() + "]";
	}
	
	
	
}

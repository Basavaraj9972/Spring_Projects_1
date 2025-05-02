package com.tap.pojo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Project")
public class Project {
	
	@Id
	@Column(name="projectId")
	private int projectId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.ALL})
	@JoinTable(name="pro_emp",
			joinColumns = @JoinColumn(name="proj_id"),
			inverseJoinColumns = @JoinColumn(name="emp_id")
	)
	private List<Employee> employee;
	
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String name) {
		super();
		this.projectId = projectId;
		this.name = name;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + "]";
	}
	
	

}

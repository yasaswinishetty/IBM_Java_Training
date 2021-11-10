package com.ibm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Department {
	@Id
	private int deptNo;
	@Column(name="dname",length=15)
	private String deptName;
	
	//Each department has many employees
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> emps;

	//Getters and Setters
	
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}

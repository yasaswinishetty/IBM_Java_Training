package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ibm.entity.Department;
import com.ibm.entity.Employee;

public class EmpDeptRepo {
	private EntityManager getManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		return mgr;
	}
	
	public void saveEmp(Employee emp, int deptNo) {
		EntityManager mgr = getManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Department dept = mgr.find(Department.class, deptNo);
		emp.setDept(dept);
		mgr.persist(emp);
		txn.commit();
		mgr.close();
	}
	public void saveDept(Department dept) {
		EntityManager mgr = getManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		mgr.persist(dept);
		txn.commit();
		mgr.close();
	}
	
	public Employee getEmp(int empNo) {
		EntityManager mgr = getManager();
		return mgr.find(Employee.class, empNo);
	}

	public List<Employee> getAllEmp(){
		EntityManager mgr = getManager();
		return mgr.createQuery("from Employee").getResultList();
	}
	
	public Department getDept(int deptNo) {
		EntityManager mgr = getManager();
		return mgr.find(Department.class, deptNo);
	}
	
	public List<Department> getAllDept(){
		EntityManager mgr = getManager();
		return mgr.createQuery("from Department").getResultList();
	}
	
	public void deleteDept(int deptNo) {
		EntityManager mgr = getManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		
		Department dept = mgr.find(Department.class, deptNo);
		mgr.remove(dept);
		
		txn.commit();
		mgr.close();
	}
}

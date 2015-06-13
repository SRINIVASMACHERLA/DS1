package com.cnu.ds.hash;

public class Employee {
	private int employeeID;
	private String name;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		int hashValue = 0;
		int hash = employeeID;
		int digits = 1000;
		while (hash != 0) {
			hashValue = hashValue + hash % digits;
			hash = hash / digits;
		}
		System.out.println(hashValue);
		return hashValue;
	}
}

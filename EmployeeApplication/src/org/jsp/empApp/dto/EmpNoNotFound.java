package org.jsp.empApp.dto;

public class EmpNoNotFound extends RuntimeException {
	public EmpNoNotFound(String str) {
		System.out.println(str);
	}
}
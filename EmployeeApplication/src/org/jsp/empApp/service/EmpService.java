package org.jsp.empApp.service;

import java.util.*;

import org.jsp.empApp.dto.*;

public class EmpService {
	List<Employee> al = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void addEmployee() {
	    Employee e = new Employee();
	    System.out.println("Enter employee details:");

	    // Handling EmpNo
	    while (true) {
	        try {
	            System.out.print("1. EmpNo: ");
	            e.setEmpno(sc.nextInt());
	            break;
	        } catch (java.util.InputMismatchException ex) {
	            System.out.println("Invalid input for EmpNo. Please enter a valid integer.");
	            sc.next(); // Consume the invalid input
	        }
	    }

	    // Handling Emp Name
	    System.out.print("2. Emp Name: ");
	    sc.nextLine(); // Consume the newline character
	    e.setEname(sc.nextLine());

	    // Handling Emp Phone
	    while (true) {
	        try {
	            System.out.print("3. Emp Phone: ");
	            e.setEphone(sc.nextLong());
	            break;
	        } catch (java.util.InputMismatchException ex) {
	            System.out.println("Invalid input for Emp Phone. Please enter a valid long integer.");
	            sc.next(); // Consume the invalid input
	        }
	    }

	    // Handling Emp Age
	    while (true) {
	        try {
	            System.out.print("4. Emp Age: ");
	            e.setEage(sc.nextInt());
	            break;
	        } catch (java.util.InputMismatchException ex) {
	            System.out.println("Invalid input for Emp Age. Please enter a valid integer.");
	            sc.next(); // Consume the invalid input
	        }
	    }

	    // Handling Emp Designation
	    System.out.print("5. Emp Designation: ");
	    e.setEdesgnation(sc.next());

	    // Handling Emp Sal
	    while (true) {
	        try {
	            System.out.print("6. Emp Sal: ");
	            e.setSal(sc.nextDouble());
	            break;
	        } catch (java.util.InputMismatchException ex) {
	            System.out.println("Invalid input for Emp Sal. Please enter a valid double.");
	            sc.next(); // Consume the invalid input
	        }
	    }

	    al.add(e);
	    System.out.println("Employee successfully added to the database: " + e.getEname());
	    System.out.println("------------------------------------");
	}


	public void updateEmployee() {
	    System.out.println("Please enter the emp no");
	    int empNo = sc.nextInt();
	    sc.nextLine(); // Consume the newline character left by sc.nextInt()

	    for (Employee e : al) {
	        if (empNo == e.getEmpno()) {
	            System.out.println("Enter:\n2. Emp Name\n3. Emp Phone\n4. Emp Age\n5. Emp Designation\n6. Emp Sal ");

	            // Handling Emp Name
	            System.out.print("2. Emp Name: ");
	            e.setEname(sc.nextLine());

	            // Handling Emp Phone
	            while (true) {
	                try {
	                    System.out.print("3. Emp Phone: ");
	                    e.setEphone(sc.nextLong());
	                    break;
	                } catch (java.util.InputMismatchException ex) {
	                    System.out.println("Invalid input for Emp Phone. Please enter a valid long integer.");
	                    sc.next(); // Consume the invalid input
	                }
	            }

	            // Handling Emp Age
	            while (true) {
	                try {
	                    System.out.print("4. Emp Age: ");
	                    e.setEage(sc.nextInt());
	                    break;
	                } catch (java.util.InputMismatchException ex) {
	                    System.out.println("Invalid input for Emp Age. Please enter a valid integer.");
	                    sc.next(); // Consume the invalid input
	                }
	            }

	            // Handling Emp Designation
	            System.out.print("5. Emp Designation: ");
	            e.setEdesgnation(sc.next());

	            // Handling Emp Sal
	            while (true) {
	                try {
	                    System.out.print("6. Emp Sal: ");
	                    e.setSal(sc.nextDouble());
	                    break;
	                } catch (java.util.InputMismatchException ex) {
	                    System.out.println("Invalid input for Emp Sal. Please enter a valid double.");
	                    sc.next(); // Consume the invalid input
	                }
	            }

	            System.out.println("Employee details are successfully updated ");
	            System.out.println("-------------------------------");
	            return;
	        }
	    }
	    throw new EmpNoNotFound("EmpNo NOT-FOUND");
	}


	public void findAll() {
	    System.out.println("Employees Details are : ");

	    if (al.isEmpty()) {
	        System.out.println("No employees found in our database");
	    } else {
	        for (Employee e : al) {
	            System.out.println(e);
	            System.out.println("-------------------------------");
	        }
	    }
	}


	public void findByEmpNo() {
	    System.out.println("Please enter the emp no");
	    int empNo = sc.nextInt();

	    for (Employee e : al) {
	        if (empNo == e.getEmpno()) {
	            System.out.println("Employee Details are : ");
	            System.out.println(e);
	            System.out.println("--------------------------------");
	            return;
	        }
	    }

	    System.out.println("No employee found with EmpNo: " + empNo);
	    throw new EmpNoNotFound("EmpNo NOT-FOUND");
	}


	public void deleteByEmpNo() {
		System.out.println("please enter the emp no");
		int empNo = sc.nextInt();
		for (Employee e : al) {
			if (empNo == e.getEmpno()) {
				System.out.println(e.getEname() + " is succesfully deleted");
				System.out.println("--------------------------------");
				al.remove(e);
				return;
			}
		}
		System.out.println("--------------------------------");
		throw new EmpNoNotFound("EmpNo NOT-FOUND");
	}

	public void sortByEmpNo() {
	    System.out.println("Employees Details are : ");

	    if (al.isEmpty()) {
	        System.out.println("No employees found in our database");
	    } else {
	        Collections.sort(al, new SortByEmpNo());
	        for (Employee e : al) {
	            System.out.println(e);
	        }
	    }
	}

	public void sortByEmpName() {
	    if (al.isEmpty()) {
	        System.out.println("No employees found in our database");
	        return;
	    }

	    Collections.sort(al, new SortByEmpName());

	    System.out.println("Employees Details are : ");
	    for (Employee e : al) {
	        System.out.println(e);
	    }
	}

}

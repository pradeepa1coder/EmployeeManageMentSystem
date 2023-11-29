package org.jsp.empApp.controller;

import java.util.Scanner;

import org.jsp.empApp.service.EmpService;

public class EmpController {

    public static void main(String[] args) {
        EmpService service = new EmpService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("SELECT THE OPTION :-");
            System.out.println(
                    "1.Add Employee : \n2.Update Employee Details : \n3.Get Employee Details By Emp No : \n4.Get All Employee Details : \n5.Remove Employee : \n6.Sort Emp By Their Name : \n7.Sort Emp By Their Age : \n8.Exit : ");
            System.out.println("============*============");
            int opt=0;
            try {
                opt = sc.nextInt(); // 1
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }

            switch (opt) {
                case 1:
                    service.addEmployee();
                    break;
                case 2:
                    service.updateEmployee();
                    break;
                case 3:
                    service.findByEmpNo();
                    break;
                case 4:
                    service.findAll();
                    break;
                case 5:
                    service.deleteByEmpNo();
                    break;
                case 6:
                    service.sortByEmpName();
                    break;
                case 7:
                    service.sortByEmpNo();
                    break;
                case 8:
                    System.out.println("Thank You  !! visit Again");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select Correct option");
            }
        }
    }
}

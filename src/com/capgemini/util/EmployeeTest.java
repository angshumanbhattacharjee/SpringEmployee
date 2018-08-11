package com.capgemini.util;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.util.EmpDao;
import com.capgemini.util.EmployeePojo;

public class EmployeeTest 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException
	{	
		String id,name,dept,city,state,ch,phone;
		int salary,commission;
		int pincode;
		int status = 0;	
		ApplicationContext context = new ClassPathXmlApplicationContext("db_config.xml");
	    EmpDao empdao = (EmpDao) context.getBean("empdao");
	    Scanner sc=new Scanner(System.in);
	    do
	    {
	    	System.out.println("Enter 1 to get all the names of employees");
	    	System.out.println("Enter 2 to get names of employees by ID");
	    	System.out.println("Enter 3 to get highest salary by department");
	    	System.out.println("Enter 4 to update commission of an employee");
	    	System.out.println("Enter 5 to add new employee");
	    	System.out.println("Enter 6 to remove employees by ID ");
	    	System.out.println("Enter 7 to update name of employee");
	    	System.out.println("Enter 8 to update city, state, phone and pincode of employee");
	    	try {
				switch(sc.nextInt())
				{
					case 1: empdao.getAllEmp();
				    		break;
					case 2: System.out.println("Enter employee id: ");
							id=sc.next();
							empdao.getEmpByID(new EmployeePojo(id));
							break;
					case 3: 
							empdao.getHighestSalaryByDept();
							break;
					case 4: System.out.println("Enter employee id: ");
							id=sc.next();
							System.out.println("Enter updated commission of the employee: ");
							commission=sc.nextInt();
							status=empdao.updateCommission(new EmployeePojo(id,commission));
							break;
					case 5: System.out.println("Enter employee id: ");
							id=sc.next();
							System.out.println("Enter employee name: ");
							name=sc.next();
							System.out.println("Enter employee department: ");
							dept=sc.next();
							System.out.println("Enter employee salary: ");
							salary=sc.nextInt();
							System.out.println("Enter employee commission: ");
							commission=sc.nextInt();
							System.out.println("Enter employee city: ");
							city=sc.next();
							System.out.println("Enter employee state: ");
							state=sc.next();
							System.out.println("Enter employee phone number: ");
							phone=sc.next();
							System.out.println("Enter employee pincode: ");
							pincode=sc.nextInt();
							status=empdao.addNewEmp(new EmployeePojo(id,name,dept,salary,commission,city,state,phone,pincode));
							break;
					case 6: System.out.println("Enter employee id: ");
							id=sc.next();
							status=empdao.removeEmpByID(new EmployeePojo(id));
							break;
					case 7: System.out.println("Enter employee id: ");
							id=sc.next();
							System.out.println("Enter employee name: ");
							name=sc.next();
							status=empdao.updateEmpName(new EmployeePojo(id,name));
							break;
					case 8: System.out.println("Enter employee id: ");
							id=sc.next();
							System.out.println("Enter updated city of the employee: ");
							city=sc.next();
							System.out.println("Enter updated state of the employee: ");
							state=sc.next();
							System.out.println("Enter updated phone of the employee: ");
							phone=sc.next();
							System.out.println("Enter updated pincode of the employee: ");
							pincode=sc.nextInt();
							status=empdao.updateEmpCityStatePhonePincode(new EmployeePojo(id,city,state,phone,pincode));
							break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	if(status==1)
	    	{
	    		System.out.println("Operation performed successfully\n\n\n\n");
	    	}
	    	System.out.println("\n\n\nDo you wish to continue? Enter Yes or No");
	    	ch=sc.next();
	    }while(ch.equalsIgnoreCase("yes"));
	    
	    
	}

}
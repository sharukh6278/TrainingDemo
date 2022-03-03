package org.com;

import org.com.beans.Employee;
import org.com.dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		
		  ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		  EmployeeDao dao=(EmployeeDao) context.getBean("empDao");
		 
		Employee e1=new Employee(102,"srk2","srk2@gmail.com");
		//int i=dao.save(e1);
		//dao.update(e1);
		//dao.delete(e1);
		System.out.println("record saed : "+dao.getEmployee(102));
		
		

	}

}

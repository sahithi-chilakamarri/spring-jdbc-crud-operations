package com.stackroute.crudoperations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) {
        //Creating object for the application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //Creating object for the employeedao
        EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("employeedao");
        //Creating a new table called cutomers
        employeeDao.createTable();
        //Retrieving the data from the employee table
        System.out.println(employeeDao.readEmployee());
        //Deleting the data from the employee table
        employeeDao.deleteEmployee();
        //Updating the employee table
        employeeDao.updateEmployee();
        System.out.println(employeeDao.readEmployee());

    }

}


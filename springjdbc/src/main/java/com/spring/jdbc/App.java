package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Structure of the program
 * 
 * 1. App.java --> Main program
 * 2. config.xml --> Configuration file 
 * 3. StudentDao --> An interface to handle database change activities like Adding, Updating, Deleting and selecting the record.
 * 4. StudentDaoImplementation --> An implementation class of StudentDao interface.
 * 5. Student --> An entity whose data will be changed and added in the database.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started..." );
        
        //spring jdbc ==> Jdbc Template
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
		/*
		 * JdbcTemplate temp = context.getBean("jdbcTemplate", JdbcTemplate.class); 
		 * Now we will not create object of JdbcTemplate instead we will create the object
		 * for StudentDao (interface) To extract the "insert" function that was declared
		 * in StudentDao interface and implemented in StudentDaoImplementation class.
		 */       
        
        StudentDao temp = context.getBean("studentDao", StudentDao.class);
        System.out.println("..");

//		  // Insert        
//        Student student = new Student();
//        System.out.println(".");
//        student.setId(666);
//        student.setName("Aman Preet Singh Gulati");
//        student.setCity("Kanpur");
//        
//        int result = temp.insert(student);
        
          // Update
//        Student student = new Student();
//        student.setId(222);
//        student.setName("Aman Preet");
//        student.setCity("Lucknow");
          
//        int result = temp.update(student);
        
          // Delete
//        Student student = new Student();
//        int result = temp.delete(222);
        
//        For Single object retrieval
//        Student student = temp.getStudent(666);
        
//        For multiple object retrieval
          List<Student> student = temp.getAllStudent();
          // For each loop --> need to learn
          for (Student s:student)
          {
        	  System.out.println("Records fetched: "+s);  
          }
        		
    }
}

package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImplementation implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		// Insert query
        String query = "insert into student(id,name,city) values(?,?,?)";
        int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return result;
	}

	public int update(Student student) {
		// Update query
		String query = "update student set name=?, city=? where id =?"; 
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int delete(int studentId) {
		// Delete query
		String query = "delete from student where id = ?";
		int result = this.jdbcTemplate.update(query, studentId);
		return result;
	}

	public Student getStudent(int studentId) {
		// Select single student object
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImplementation();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}
	
	public List<Student> getAllStudent() {
		// Select Multiple student object
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImplementation());
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
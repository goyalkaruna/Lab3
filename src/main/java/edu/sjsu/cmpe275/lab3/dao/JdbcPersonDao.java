package edu.sjsu.cmpe275.lab3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import edu.sjsu.cmpe275.lab3.forms.Person;

import javax.sql.DataSource;



public class JdbcPersonDao implements PersonDao{
   
	private DataSource datasource;
	
	public void setDataSource(DataSource datasource){
		this.datasource = datasource;
	}
	
	 public void insertPerson(Person person){
		 String sql = "Insert into Person() values ()";
		 Connection conn = null;
		 try{
			 conn= datasource.getConnection();
			 PreparedStatement ps =conn.prepareStatement(sql);
			 ps.setLong(1, person.getId());
             ps.executeUpdate();
             ps.close();
		 }catch (SQLException e) {
			 throw new RuntimeException(e);
		 }finally {
			 if (conn !=null) {
				 try {
					 conn.close();
				 }catch (SQLException e) {}
			 }
		 }
	 }

	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void deletePerson(Long Id) {
		
		String deleteStatement = "DELETE FROM hosts WHERE id=?";
		 Connection conn = null;
		 try{
			 conn= datasource.getConnection();
			 PreparedStatement ps =conn.prepareStatement(deleteStatement);
			// ps.setLong(1, person.getPersonId());
             ps.executeUpdate();
             ps.close();
		 }catch (SQLException e) {
			 throw new RuntimeException(e);
		 }finally {
			 if (conn !=null) {
				 try {
					 conn.close();
				 }catch (SQLException e) {}
			 }
		 }
		
	}

	public Person findbyPersonId(Long Id) {
		String sql = "SELECT * FROM PERSON WHERE Person_ID = ?";
		Person person = new Person();
//		Person  person = (Person)getJdbcTemplate().queryForObject(
//				sql, new Object[] { Id }, new PersonRowMapper());
//	
		return person;
		
	}


}

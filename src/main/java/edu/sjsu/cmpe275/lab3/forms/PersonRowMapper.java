package edu.sjsu.cmpe275.lab3.forms;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class PersonRowMapper implements RowMapper{



	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("ID"));
		person.setFirstname(rs.getString("FirstName"));
		person.setLastname(rs.getString("LastName"));
		return person;
	}
	
}



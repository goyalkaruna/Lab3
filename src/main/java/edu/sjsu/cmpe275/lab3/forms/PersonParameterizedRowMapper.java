package edu.sjsu.cmpe275.lab3.forms;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

@SuppressWarnings("deprecation")
public class PersonParameterizedRowMapper  implements ParameterizedRowMapper<Person>{


	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getLong("CUST_ID"));
		person.setFirstname(rs.getString("FirstName"));
		person.setLastname(rs.getString("LastName"));
		return person;
	}
	
}


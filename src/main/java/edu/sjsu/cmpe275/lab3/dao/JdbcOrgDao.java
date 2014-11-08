package edu.sjsu.cmpe275.lab3.dao;

import javax.sql.DataSource;

import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;

public class JdbcOrgDao implements OrganizationDao {
    
private DataSource datasource;
	
	public void setDataSource(DataSource datasource){
		this.datasource = datasource;
	}

	public void insertOrg(Organization org) {
		// TODO Auto-generated method stub
		
	}

	public void updateOrg(Organization org) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOrg(Long Id) {
		// TODO Auto-generated method stub
		
	}

	public Person findbyOrgId(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package edu.sjsu.cmpe275.lab3.dao;

import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;

public interface OrganizationDao {
   
	 public void insertOrg(Organization org);
	  public void updateOrg(Organization org);
	  public void deleteOrg(Long Id);
	  public Organization findbyOrgId(Long Id);
}

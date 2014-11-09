package edu.sjsu.cmpe275.lab3.dao;

import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;

public interface OrganizationDao {
   
	 public boolean insertOrg(Organization org);
	  public int updateOrg(Organization org);
	  public int deleteOrg(Long Id);
	  public Organization findbyOrgId(Long Id);
}
package edu.sjsu.cmpe275.lab3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;

import edu.sjsu.cmpe275.lab3.forms.Person;

import javax.sql.DataSource;



public class JdbcPersonDao implements PersonDao{
   
	private DataSource datasource;
	
	public void setDataSource(DataSource datasource){
		this.datasource = datasource;
	}
	
	 public boolean insertPerson(Person person){
		 String sql = "Insert into Person(Person_id, FirstName, LastName, Email, Description, Org_id, Add_id) "
		 		+ "values (?, ?,?, ?, ?, ?,?)";
		 Connection conn = null;
		 try{
			 conn= datasource.getConnection();
			 PreparedStatement ps =conn.prepareStatement(sql);
			 ps.setLong(1, person.getId());
			 ps.setString(2, person.getFirstname());
			 ps.setString(3, person.getLastname());
			 ps.setString(4,person.getEmail());
			 ps.setString(5, person.getDescription());
			 ps.setLong(6, person.getOrg().getId());
			 ps.setLong(7, person.getAddress().getAdd_id());
             int x= ps.executeUpdate();
             ps.close();
             if (x>0){
            	 return true;
             }
             else 
            	 return false;
            
            
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

	public int updatePerson(Person person) {
		Connection dbConnection = null;
	    Statement statement = null;

	    String sql = "update person set name=" + "'" + person.getFirstname() + "'" + "where person_id="
	                    + person.getId();

	    try
	    {
	    
	      dbConnection = datasource.getConnection();
	      statement = dbConnection.prepareStatement(sql);
	      int rowsupdated = statement.executeUpdate(sql);

	      System.out.println("Record is updated into Employee table for Employee id : "
	                      + person.getId());
	      if(rowsupdated ==1){
            return 200;
	      }
	      else 
	    	  return 404;
	    }
	    catch( SQLException e )
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      if( statement != null )
	      {
	        try
	        {
	          statement.close();
	        }
	        catch( SQLException e )
	        {
	          e.printStackTrace();
	        }
	      }
	      if( dbConnection != null )
	      {
	        try
	        {
	          dbConnection.close();
	        }
	        catch( SQLException e )
	        {
	          e.printStackTrace();
	        }
	      }
	    }
	    return 404;
	}

	public int deletePerson(Long Id) {
		
//		String deleteStatement = "DELETE FROM hosts WHERE id=?";
//		 Connection conn = null;
//		 try{
//			 conn= datasource.getConnection();
//			 PreparedStatement ps =conn.prepareStatement(deleteStatement);
//			// ps.setLong(1, person.getPersonId());
//             ps.executeUpdate();
//             ps.close();
//		 }catch (SQLException e) {
//			 throw new RuntimeException(e);
//		 }finally {
//			 if (conn !=null) {
//				 try {
//					 conn.close();
//				 }catch (SQLException e) {}
//			 }
//		 }
		Connection dbConnection = null;
	    Statement statement = null;
      
	    String sql = "delete from person where Person_id="+ Id;

	    try
	    {
	      
	      dbConnection = datasource.getConnection();
	      statement = dbConnection.prepareStatement(sql);
	      int rowsdeleted=statement.executeUpdate(sql);
          if (rowsdeleted == 1){
	      System.out.println("Record is deleted from Person table for Person id : "
	                      + Id);
         return 200;
          }
          else 
        	  return 404;
	    }
	    catch( SQLException e )
	    {

	      e.printStackTrace();

	    }
	    finally
	    {

	      if( statement != null )
	      {
	        try
	        {
	          statement.close();
	        }
	        catch( SQLException e )
	        {
	          e.printStackTrace();
	        }
	      }

	      if( dbConnection != null )
	      {
	        try
	        {
	          dbConnection.close();
	        }
	        catch( SQLException e )
	        {
	          e.printStackTrace();
	        }
	      }
            
	    }
	    return 404;
	  }
		
	

	public Person findbyPersonId(Long Id) {
		  
	 
		    Connection conn = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try
		    {
		      conn= datasource.getConnection();
		      String query = "SELECT * FROM person where person_id="+Id;
		      stmt = conn.createStatement();
		      rs = stmt.executeQuery(query);
		      while( rs.next() )
		      {
		        Person person = new Person();
		        person.setId(rs.getLong("Employee_Id"));
		        person.setFirstname(rs.getString("Name"));
		        person.setLastname(rs.getString("age"));
		        return person;
		      }
		    }
		    catch( SQLException e )
		    {
		      e.printStackTrace();
		    }

		    finally
		    {
		      try
		      {
		        if( conn != null )
		        {
		          conn.close();
		        }
		        if( stmt != null )
		        {
		          stmt.close();
		        }
		        if( rs != null )
		        {
		          rs.close();
		        }
		      }
		      catch( Exception exe )
		      {
		        exe.printStackTrace();
		      }

		    }
		    return null;

		
	}


}


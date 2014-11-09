package edu.sjsu.cmpe275.lab3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;

import edu.sjsu.cmpe275.lab3.forms.Organization;
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

	public int deletePerson(int Id) {
		
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
		
	

	public Person findbyPersonId(int Id) {
		  
	 
		    Connection conn = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try
		    {
		      conn= datasource.getConnection();
		      String query = "SELECT * FROM person as p, address as a , organization as o"
		      		+ " where p.Person_id="+Id +"and p.Org_id= o.Org_id and p.Add_id= a.Add_id";
		      stmt = conn.createStatement();
		      rs = stmt.executeQuery(query);
		      while( rs.next() )
		      {
		        Person person = new Person();
		        Object object = new Object();
		        person.setId(rs.getInt("Person_id"));
		        person.setFirstname(rs.getString("FirstName"));
		        person.setLastname(rs.getString("LastName"));
		        person.setEmail(rs.getString("Email"));
		        person.setDescription(rs.getString("Description"));
		     //  rs.getString("Add_id"));
		       
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

	public int addFriendship(int id1, int id2) {
		String sql = "Insert into friendship(Person_id, Friends_id) "
		 		+ "values (?, ?)";
		 Connection conn = null;
		 try{
			 conn= datasource.getConnection();
			 PreparedStatement ps =conn.prepareStatement(sql);
			 ps.setInt(1, id1);
			 ps.setInt(2, id2);

             int x= ps.executeUpdate();
             ps.close();
             if (x>0){
            	 return 200;
             }
             else 
            	 return 404;
            
            
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

public int removeFriendship(int id1, int id2) {
		
		Connection dbConnection = null;
	    Statement statement = null;
      
	    String sql = "delete from friendship where Person_id="+ id1 +"and Friends_id="+id2 ;

	    try
	    {
	      
	      dbConnection = datasource.getConnection();
	      statement = dbConnection.prepareStatement(sql);
	      int rowsdeleted=statement.executeUpdate(sql);
          if (rowsdeleted == 1){
	      System.out.println("Record is deleted from Person table for Person id : "
	                      + id1);
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


		
	
}

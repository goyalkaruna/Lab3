<<<<<<< HEAD
package edu.sjsu.cmpe275.lab3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;

public class JdbcOrgDao implements OrganizationDao {
    
private DataSource datasource;
	
	public void setDataSource(DataSource datasource){
		this.datasource = datasource;
	}
	
	 public void insertOrg(Organization org){
		 String sql = "Insert into Organization() values ()";
		 Connection conn = null;
		 try{
			 conn= datasource.getConnection();
			 PreparedStatement ps =conn.prepareStatement(sql);
			 ps.setLong(1, org.getId());
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

	public void updateOrg(Organization org) {
		Connection dbConnection = null;
	    Statement statement = null;

	    String sql = "update person set name=" + "'" + org.getDescription() + "'" + "where person_id="
	                    + org.getId();

	    try
	    {
	    
	      dbConnection = datasource.getConnection();
	      statement = dbConnection.prepareStatement(sql);
	      statement.executeUpdate(sql);

	      System.out.println("Record is updated into Organization table for Organization id : "
	                      + org.getId());
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
	}

	public void deleteOrg(Long Id) {
		
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

	    String sql = "delete from person where employee_Id="+ Id;

	    try
	    {
	      
	      dbConnection = datasource.getConnection();
	      statement = dbConnection.prepareStatement(sql);
	      statement.executeUpdate(sql);

	      System.out.println("Record is deleted from Person table for Person id : "
	                      + Id);

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
	  }
		
	

	public Organization findbyOrgId(Long Id) {
		  
	 
		    Connection conn = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try
		    {
		      conn= datasource.getConnection();
		      String query = "SELECT * FROM organization where organization_id="+Id;
		      stmt = conn.createStatement();
		      rs = stmt.executeQuery(query);
		      while( rs.next() )
		      {
		    	Organization org = new Organization();
		        org.setId(rs.getLong("Id"));
		        org.setDescription(rs.getString("Desc"));       
		        return org;
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

=======
package edu.sjsu.cmpe275.lab3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.sjsu.cmpe275.lab3.forms.Organization;
import edu.sjsu.cmpe275.lab3.forms.Person;

public class JdbcOrgDao implements OrganizationDao {
    
private DataSource datasource;
	
	public void setDataSource(DataSource datasource){
		this.datasource = datasource;
	}
	
	 public boolean insertOrg(Organization org){
		 String sql = "Insert into Organization() values ()";
		 Connection conn = null;
		 try{
			 conn= datasource.getConnection();
			 PreparedStatement ps =conn.prepareStatement(sql);
			 ps.setLong(1, org.getId());
             ps.executeUpdate();
             ps.close();
             return true;
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

	public int updateOrg(Organization org) {
		Connection dbConnection = null;
	    Statement statement = null;

	    String sql = "update person set name=" + "'" + org.getDescription() + "'" + "where person_id="
	                    + org.getId();

	    try
	    {
	    
	      dbConnection = datasource.getConnection();
	      statement = dbConnection.prepareStatement(sql);
	      statement.executeUpdate(sql);

	      System.out.println("Record is updated into Organization table for Organization id : "
	                      + org.getId());
	      return 200;
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

	public int deleteOrg(Long Id) {
		
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

	    String sql = "delete from person where employee_Id="+ Id;

	    try
	    {
	      
	      dbConnection = datasource.getConnection();
	      statement = dbConnection.prepareStatement(sql);
	      statement.executeUpdate(sql);

	      System.out.println("Record is deleted from Person table for Person id : "
	                      + Id);
          return 200;
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
		
	

	public Organization findbyOrgId(Long Id) {
		  
	 
		    Connection conn = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try
		    {
		      conn= datasource.getConnection();
		      String query = "SELECT * FROM organization where organization_id="+Id;
		      stmt = conn.createStatement();
		      rs = stmt.executeQuery(query);
		      while( rs.next() )
		      {
		    	Organization org = new Organization();
		        org.setId(rs.getLong("Id"));
		        org.setDescription(rs.getString("Desc"));       
		        return org;
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

>>>>>>> 32882d8581e2479483a8cfc19ba2853a3a1cf1c3

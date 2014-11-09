package edu.sjsu.cmpe275.lab3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.sjsu.cmpe275.lab3.forms.Address;
import edu.sjsu.cmpe275.lab3.forms.Person;

public class JdbcAddressDao implements AddressDao {

private DataSource datasource;
	
	public void setDataSource(DataSource datasource){
		this.datasource = datasource;
	}
	public boolean insertAddress(Address address) {
		 String sql = "Insert into Organization() values ()";
		 Connection conn = null;
		 try{
			 conn= datasource.getConnection();
			 PreparedStatement ps =conn.prepareStatement(sql);
			 ps.setLong(1, address.getAdd_id());
            
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

	public int updateAddress(Address address) {
		Connection dbConnection = null;
	    Statement statement = null;

	    String sql = "update person set name=" + "'" + address.getStreet() + "'" + "where person_id="
	                    + address.getAdd_id();

	    try
	    {
	    
	      dbConnection = datasource.getConnection();
	      statement = dbConnection.prepareStatement(sql);
	      int rowsupdated = statement.executeUpdate(sql);

	      System.out.println("Record is updated into Employee table for Employee id : "
	                      + address.getAdd_id());
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

	public int deleteAddress(int Id) {
		Connection dbConnection = null;
	    Statement statement = null;
      
	    String sql = "delete from address where Address_id="+ Id;

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

	public Address findbyAddressId(int Id) {
		 Connection conn = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try
		    {
		      conn= datasource.getConnection();
		      String query = "SELECT * FROM address where address_id="+Id;
		      stmt = conn.createStatement();
		      rs = stmt.executeQuery(query);
		      while( rs.next() )
		      {
		        Address address = new Address();
		      
		        address.setAdd_id(rs.getInt("Add_id"));
		        address.setStreet(rs.getString("Street"));
		        address.setCity(rs.getString("City"));
		        address.setState(rs.getString("State"));
		        address.setZip(rs.getString("Zip"));
		      
		        return address;
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

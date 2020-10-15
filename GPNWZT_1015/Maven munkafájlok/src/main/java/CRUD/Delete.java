package CRUD;


import static CRUD.Connection.getConnection;
import static java.lang.System.exit;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {
	private static java.sql.Connection conn;
	private static PreparedStatement delprstmt; 
	
	  public Delete(){
	       conn=getConnection();
	       try {
	       delprstmt=conn.prepareStatement("delete from cats where name=? and owner=?");
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
	    }
	  
	  public void Delete(String catname, String owner) {
		  try {
		  delprstmt.setString(1, catname);
		  delprstmt.setString(2, owner);
		  delprstmt.execute();
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
}

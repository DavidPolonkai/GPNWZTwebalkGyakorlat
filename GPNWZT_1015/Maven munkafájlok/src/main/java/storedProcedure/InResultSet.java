package storedProcedure;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import CRUD.Select;

import static CRUD.Connection.getConnection;

public class InResultSet {
    private static java.sql.Connection conn;
	private static CallableStatement callprstmt; 
	
	  public InResultSet(){
	       conn=getConnection();
	       try {
	       callprstmt=conn.prepareCall("{ call get_cats_for_owner(?)}");
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
	    }
	  
	  public void Call(String owner) {
		  try {
		  callprstmt.setString(1, owner);
          ResultSet rs=callprstmt.executeQuery();
          new Select().WriteOutResultset(rs);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
}
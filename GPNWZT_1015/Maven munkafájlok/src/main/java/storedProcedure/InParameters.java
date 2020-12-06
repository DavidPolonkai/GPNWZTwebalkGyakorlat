package storedProcedure;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import static CRUD.Connection.getConnection;

public class InParameters {
    private static java.sql.Connection conn;
	private static CallableStatement callprstmt; 
	
	  public InParameters(){
	       conn=getConnection();
	       try {
	       callprstmt=conn.prepareCall("{ call set_perzsa_cats_owner(?,?)}");
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
	    }
	  
	  public void Call(String breed,String owner) {
		  try {
          callprstmt.setString(1, breed);
          callprstmt.setString(2, owner);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
}
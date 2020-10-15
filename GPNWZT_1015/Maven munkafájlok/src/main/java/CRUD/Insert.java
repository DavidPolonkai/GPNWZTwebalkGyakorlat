package CRUD;

import static CRUD.Connection.getConnection;
import static java.lang.System.exit;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	private static java.sql.Connection conn;
	private static PreparedStatement insertprstmt;
	
	  public Insert(){
	        try {
	            conn=getConnection();
	            conn.setAutoCommit(false);
	            insertprstmt = conn.prepareStatement("Insert into cats values(?,?,?,?,?);");
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	            exit(-1);
	        }
	    }
	  
	  public void InsertToTable(Cats cats) {
		  try {
			  insertprstmt.setInt(1, cats.getId());
			  insertprstmt.setString(2, cats.getName());
			  insertprstmt.setString(3, cats.getBreed());
			  insertprstmt.setInt(4, cats.getAge());
			  insertprstmt.setString(5, cats.getOwner());
			  insertprstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
	  }
}

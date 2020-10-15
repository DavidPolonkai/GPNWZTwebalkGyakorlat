package CRUD;

import static java.lang.System.exit;

import java.sql.DriverManager;

public class Connection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost/cats?serverTimezone=UTC";
    private static final String USER = "gpnwzt";
    private static java.sql.Connection conn;
    
    
    public static java.sql.Connection getConnection(){
    	if (conn==null) {
    		try {
	            Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            conn.setAutoCommit(false);
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	            exit(-1);
	        }
    	}
    	return conn;
    }

    private static final String PASS = "#GPNWZTgpnwzt12";
}

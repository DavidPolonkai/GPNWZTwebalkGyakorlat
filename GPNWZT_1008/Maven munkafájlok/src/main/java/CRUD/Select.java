package CRUD;

import java.sql.*;
import static CRUD.Connection.*;
import static java.lang.System.exit;

public class Select {
    private static java.sql.Connection conn;


    public Select(){
        try {
            Class.forName(getJdbcDriver());
            this.conn = DriverManager.getConnection(getDbUrl(), getUSER(), getPASS());
        }catch(Exception e){
            System.out.println("An error has been occured, exiting... \n error: "+e.getMessage());
            exit(-1);
        }
    }

    public void getOlderThan(int age){
        try {
            PreparedStatement prstmt = conn.prepareStatement("SELECT * FROM CATS WHERE AGE>?");
            prstmt.setInt(1,age);
            WriteOutResultset(prstmt.executeQuery());
        }catch(Exception e) {
            System.out.print("An error has been occured");
        }
    }

    public void getFullTable(){
        try {
            PreparedStatement prstmt = conn.prepareStatement("SELECT * FROM CATS");
            WriteOutResultset(prstmt.executeQuery());
        }catch(Exception e){
            System.out.print("An error has been occured");
        }
    }

    public void WriteOutResultset(ResultSet rs){
        try {
            while (rs.next()) {
                System.out.println("id: " + rs.getInt(1) + " name: " + rs.getString(2) + " breed: " + rs.getString(3) + " age: " + rs.getInt(4) + " owner: " + rs.getString(5));
            }
        }catch(Exception e){
            System.out.print("An error has been occured");
        }
    }
}

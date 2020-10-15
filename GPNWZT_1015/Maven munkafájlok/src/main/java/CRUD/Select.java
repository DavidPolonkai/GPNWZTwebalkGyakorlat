package CRUD;

import java.sql.*;
import static CRUD.Connection.getConnection;
import static java.lang.System.exit;

public class Select {
    private static java.sql.Connection conn;
    private static PreparedStatement olderprstmt;
    private static PreparedStatement fullprstmt;

    public Select(){
        try {
            conn=getConnection();
            olderprstmt = conn.prepareStatement("SELECT * FROM cats WHERE age>?");
            fullprstmt = conn.prepareStatement("SELECT * FROM cats");
        }catch(Exception e){
            System.out.println(e.getMessage());
            exit(-1);
        }
    }

    public void getOlderThan(int age){
        try {
            
            olderprstmt.setInt(1,age);
            WriteOutResultset(olderprstmt.executeQuery());
        }catch(Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void getFullTable(){
        try {
            
            WriteOutResultset(fullprstmt.executeQuery());
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void WriteOutResultset(ResultSet rs){
        try {
            while (rs.next()) {
                System.out.println("id: " + rs.getInt(1) + " name: " + rs.getString(2) + " breed: " + rs.getString(3) + " age: " + rs.getInt(4) + " owner: " + rs.getString(5));
            }
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}

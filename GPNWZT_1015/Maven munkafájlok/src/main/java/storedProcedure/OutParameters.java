package storedProcedure;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import CRUD.Select;

import static CRUD.Connection.getConnection;

public class OutParameters {
    private static java.sql.Connection conn;
    private static CallableStatement callprstmt;

    public OutParameters() {
        conn = getConnection();
        try {
            callprstmt = conn.prepareCall("{ call get_breed_count(?)}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Call(String breed) {
        try {
            callprstmt.setString(1, breed);
            ResultSet rs = callprstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Number of " + breed + " breed cats: " + rs.getInt(1));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

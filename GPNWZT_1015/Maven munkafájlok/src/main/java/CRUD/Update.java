package CRUD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static CRUD.Connection.getConnection;

public class Update {
    private static java.sql.Connection conn;
    private static PreparedStatement updateprstmt;

    public Update() {
        conn = getConnection();
        try {
            updateprstmt = conn.prepareStatement("update cats set owner='Piros Ferenc' where breed='sziami'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        try {
            updateprstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
}

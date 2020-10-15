package CRUD;

public class Connection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost/EMP";
    private static final String USER = "gpnwzt";

    public static String getJdbcDriver() {
        return JDBC_DRIVER;
    }

    public static String getDbUrl() {
        return DB_URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }

    private static final String PASS = "GPNWZTgpnwzt#12";
}

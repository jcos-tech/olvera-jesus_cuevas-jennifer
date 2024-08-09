package dao;

import java.sql.*;

public class BD {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:" + "./db/my";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public static Connection getCon() {
        try {

            Class.forName(DB_JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public static void generarBD() throws SQLException {

        Statement statement = getCon().createStatement();
        String sql = "DROP TABLE IF EXISTS ODONTOLOGO;" +
                "CREATE TABLE ODONTOLOGO(NUMERO_MATRICULA VARCHAR(255) PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255));";

        statement.execute(sql);

    }

}

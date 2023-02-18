package Classes.Connections;

import java.sql.*; // Used for Postgresql.

/**
 * Handles Postgresql connection and data import/export.
 *
 * @author cantucer2@gmail.com
 * @version 1.0
 * @date 13.02.2023
 */
public class Postgresql {

    // Database key values.
    private final static String url = "jdbc:postgresql://cs-database.c3ivdppj1ho1.eu-north-1.rds.amazonaws.com:5432/alicisindan";
    private final static String username = "postgres";
    private final static String password = "18122003ct";

    public static Connection connection;

    /**
     * Connects to the database.
     * @return Connection pointer.
     * @throws SQLException
     */
    public static Connection connect() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        return connection;

    }



}

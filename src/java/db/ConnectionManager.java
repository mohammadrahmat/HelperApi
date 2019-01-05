package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionManager extends DBConfig {

    private static final Logger LOGGER = Logger.getLogger("SQLException");

    public static Connection getDBConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(
                    new com.microsoft.sqlserver.jdbc.SQLServerDriver()
            );
            conn = DriverManager.getConnection(JDBC);
        } catch (SQLException sqlException) {
            LOGGER.severe(sqlException.getMessage());
        }
        return conn;
    }
}

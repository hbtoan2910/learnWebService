package project_01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcSqlServerConnection {

	public static Connection connect() {
		Properties props = new Properties();
		try {
			// props.load(JdbcSqlServerConnection.class.getResourceAsStream("/WEB-INF/config/config.properties"));
			// JdbcSqlServerConnection.class.getResourceAsStream returns null
			props.load(JdbcSqlServerConnection.class.getResourceAsStream("config.properties"));//property file should be in same package/folder with class
		} catch (IOException e) {
			e.printStackTrace();
		}

		String dbURL = props.getProperty("dbURL");
		System.out.println("DatabaseURL: " + dbURL);
		Connection conn = null;

		try {
			// Load SQL Server JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//sometimes, if having error, we should include this line
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				DatabaseMetaData dm = conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}

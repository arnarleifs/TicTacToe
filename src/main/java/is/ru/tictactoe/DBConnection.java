package is.ru.tictactoe;
import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConnection {
	private String userName = "tictactoe";
	private String password = "ticTacTo3";
	private String dbms = "sqlserver";
	private String serverName = "tropaeolum.arvixe.com:1433";
	private String dbName;

	public DBConnection() {
		initializeDatabaseName();
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:" + this.dbms + "://" +
                   this.serverName + ";DatabaseName=" + dbName, connectionProps);
	    System.out.println("Connected to database");
	    return conn;
	}

	// This is used to identify between the staging database and the production database
	private void initializeDatabaseName() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("connectionstring.txt"));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    this.dbName = sb.toString();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}

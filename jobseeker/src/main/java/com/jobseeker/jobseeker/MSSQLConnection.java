package com.jobseeker.jobseeker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Write a description of class MSSQLConnection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MSSQLConnection
{
    // instance variables - replace the example below with your own
    private String server = "jobportal1.database.windows.net"; // SQL Server instance name
    private String database = "Jobseekers"; // Database name
    private String username = "rajub"; // Database username
    private String password = "Project@password"; // Database password

    private String connectionUrl = "jdbc:sqlserver://" + server + ";databaseName=" + database + ";user=" + username + ";password=" + password+";encrypt=false; trustServerCertificate=false;" ;
    
    
    public MSSQLConnection()
    {
        
    }
    
    public Connection createSQLConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(connectionUrl);
        return connection;
    }
}

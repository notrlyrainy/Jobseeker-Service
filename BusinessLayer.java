import java.sql.*;
import java.util.*;

public class BusinessLayer
{
    private MSSQLConnection msSqlcon;
    private Connection con;
    private DataLayer sqlDataLayer;
    public BusinessLayer() throws SQLException, ClassNotFoundException
    {
        this.msSqlcon = new MSSQLConnection();
        this.con = msSqlcon.createSQLConnection();
        this.sqlDataLayer = new DataLayer(con);
    }

    
    public ArrayList<JobseekerDTO> getAllUsers() throws SQLException
    {
        ArrayList<JobseekerDTO> jobseekers = new ArrayList<JobseekerDTO>();
        ResultSet resultSet = sqlDataLayer.getAllUsers();
        while (resultSet.next()) {
            JobseekerDTO jobseeker = new JobseekerDTO();
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName");
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName");
            jobseekers.add(jobseeker);
            
        }
        return jobseekers;
    }
    public ArrayList<JobseekerDTO> getUsersByLastName(String lastName) throws SQLException
    {
        ArrayList<JobseekerDTO> jobseekersLiu = new ArrayList<JobseekerDTO>();
        ResultSet resultSet = sqlDataLayer.getUsersByLastName(lastName);
        while (resultSet.next()) {
            JobseekerDTO jobseeker = new JobseekerDTO();
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName");
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName");
            jobseekersLiu.add(jobseeker);
            
        }
        return jobseekersLiu;
    }
    ArrayList<JobseekerDTO> getUserByExperience(String skill, int years)throws SQLException
    {
        ArrayList<JobseekerDTO> jobseekersExperience = new ArrayList<JobseekerDTO>();
        ResultSet resultSet = sqlDataLayer.getUsersByExperience(skill, years);
        while (resultSet.next()) {
            JobseekerDTO jobseeker = new JobseekerDTO();
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName");
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName");
            jobseekersExperience.add(jobseeker);
            
        }
        return jobseekersExperience;
    }
}

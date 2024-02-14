package com.jobseeker.jobseeker;

import java.sql.*;
import java.util.*;

public class BusinessLayer
{
    private final MSSQLConnection msSqlcon;
    private final Connection con;
    private final DataLayer sqlDataLayer;
    public BusinessLayer() throws SQLException, ClassNotFoundException
    {
        this.msSqlcon = new MSSQLConnection();
        this.con = msSqlcon.createSQLConnection();
        this.sqlDataLayer = new DataLayer(con);
    }

    
    public ArrayList<JobseekerDTO> getAllUsers() throws SQLException
    {
        ArrayList<JobseekerDTO> jobseekers = new ArrayList<JobseekerDTO>();
        return sqlDataLayer.getAllUsersByDTO();
        /*while (resultSet.next()) {
            JobseekerDTO jobseeker = new JobseekerDTO();
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName");
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName");
            jobseeker.JobseekerAddress = resultSet.getString("JobseekerAddress");
            jobseekers.add(jobseeker);

        }
        return jobseekers;*/
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
    public ArrayList<JobseekerDTO> getUserByExperience(String skill, int years)throws SQLException
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
    public void addNewJobseeker(JobseekerDTO jobseeker) throws SQLException
    {
        sqlDataLayer.addJobseeker(jobseeker);
    }
    public void updateJobseeeker(int jobseekerID, JobseekerDTO jobseeker) throws SQLException
    {
        sqlDataLayer.updateJobseeker(jobseekerID, jobseeker);
    }
}

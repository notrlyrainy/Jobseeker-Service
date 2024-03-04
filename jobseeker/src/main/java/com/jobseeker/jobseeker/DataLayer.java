package com.jobseeker.jobseeker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Write a description of class SQLDataLayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DataLayer
{
    private String sql = "select * from Jobseekers";
    private Connection connection;
    /**
     * Constructor for objects of class SQLDataLayer
     */
    public DataLayer(Connection connection)
    {
        this.connection = connection;
    }
    
    public ArrayList<JobseekerDTO> getAllUsersByDTO() throws SQLException
    {
        ArrayList<JobseekerDTO> jobseekers = new ArrayList<JobseekerDTO>();
        ResultSet resultSet = getAllUsers();
        while (resultSet.next()) {
            JobseekerDTO jobseeker = new JobseekerDTO();
            jobseeker.JobseekerID = resultSet.getInt("PK_JobseekerID");
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName").trim();
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName").trim();
            jobseeker.JobseekerAddress = resultSet.getString("JobseekerAddress").trim();
            jobseeker.JobseekerCity = resultSet.getString("JobseekerCity").trim();
            jobseeker.JobseekerCountry = resultSet.getString("JobseekerCountry").trim();
            jobseeker.JobseekerEmail = resultSet.getString("JobseekerEmail").trim();
            jobseeker.JobseekerTitle = resultSet.getString("JobseekerTitle");
            jobseekers.add(jobseeker);
        }
        return jobseekers;
    }
    public ResultSet getAllUsers() throws SQLException
    {
        Statement statement = this.connection.createStatement();
        // 4. Execute a SQL query
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
    
    public ResultSet getUsersByLastName(String lastName) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        // 4. Execute a SQL query
        ResultSet resultSet = statement.executeQuery(sql + " where JobseekerLastName like '%" + lastName + "%'");
        return resultSet;
    }
    public JobseekerDTO getUserByID(int ID) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql + " where PK_JobseekerID = " + ID);
        resultSet.next();
        JobseekerDTO jobseeker = new JobseekerDTO();
            jobseeker.JobseekerID = resultSet.getInt("PK_JobseekerID");
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName").trim();
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName").trim();
            jobseeker.JobseekerAddress = resultSet.getString("JobseekerAddress").trim();
            jobseeker.JobseekerPhoneNumber = resultSet.getString("JobseekerPhoneNumber").trim();
            jobseeker.JobseekerCity = resultSet.getString("JobseekerCity").trim();
            jobseeker.JobseekerCountry = resultSet.getString("JobseekerCountry").trim();
            jobseeker.JobseekerEmail = resultSet.getString("JobseekerEmail").trim();
            jobseeker.JobseekerTitle = resultSet.getString("JobseekerTitle");
        return jobseeker;
    }
    /*
     * I am looking to connect with JobSeekers 
     * who possess advanced Java skills
     * and have accumulated over 10 years of experience.
     */
    public ResultSet getUsersByExperience(String skill, int years) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql2 = "Select * from Skills RIGHT JOIN Jobseekers ON Skills.FK_JobseekerID = Jobseekers.PK_JobseekerID";
        ResultSet resultSet = statement.executeQuery(sql2 + " where SkillsName like '%" + skill + "%' AND SkillsNumYearsExperience >" + years);
        return resultSet;
    }

    public ResultSet getJobseekerSkills(int ID) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "SELECT * FROM Skills RIGHT JOIN Jobseekers ON Skills.FK_JobseekerID = Jobseekers.PK_JobseekerID";
        ResultSet resultSet = statement.executeQuery(sql + " where Jobseekers.PK_JobseekerID = " + ID);
        return resultSet;
    }

    public ResultSet getJobseekerEducation(int ID) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "SELECT * FROM EducationDetails RIGHT JOIN Jobseekers ON EducationDetails.FK_JobseekerID = Jobseekers.PK_JobseekerID";
        ResultSet resultSet = statement.executeQuery(sql + " where Jobseekers.PK_JobseekerID = " + ID);
        return resultSet;
    }
    
    public ResultSet getJobseekerExperiences(int ID) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "SELECT * FROM Experiences RIGHT JOIN Jobseekers ON Experiences.FK_JobseekerID = Jobseekers.PK_JobseekerID";
        ResultSet resultSet = statement.executeQuery(sql + " where Jobseekers.PK_JobseekerID = " + ID);
        return resultSet;
    }

    public ResultSet getJobseekerCertificates(int ID) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "SELECT * FROM ProfessionalCertificates RIGHT JOIN Jobseekers ON ProfessionalCertificates.FK_JobseekerID = Jobseekers.PK_JobseekerID";
        ResultSet resultSet = statement.executeQuery(sql + " where Jobseekers.PK_JobseekerID = " + ID);
        return resultSet;
    }

    private String DateConverstionToSqlDate(java.util.Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return Integer.toString(year) +'-'+Integer.toString(month)+'-'+Integer.toString(day);

    }
    public void addJobseeker(JobseekerDTO jobseeker) throws SQLException
    {
       
        String sql = "Insert into Jobseekers values(" + jobseeker.JobseekerID + ", '" + jobseeker.JobseekerFirstName + "', '" + jobseeker.JobseekerMiddleName +
        "', '" + jobseeker.JobseekerLastName + "', '" + jobseeker.JobseekerAddress + "', '" + jobseeker.JobseekerEmail + "', " + jobseeker.JobseekerPhoneNumber + 
        ", '" + DateConverstionToSqlDate(jobseeker.JobseekerBirthDate)  + "', '" + jobseeker.JobseekerCity + "', '" + jobseeker.JobseekerState + "', '" + jobseeker.JobseekerCountry + "')";
        

        Statement statement = this.connection.createStatement();
        //System.out.println(sql);
        
        statement.execute(sql);
    }

    public void updateJobseeker(int jobseekerID, JobseekerDTO jobseeker) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "UPDATE Jobseekers SET (JobseekerID = " + jobseeker.JobseekerID + ", JobseekerFirstName = " + jobseeker.JobseekerFirstName + 
        ", JobseekerMiddleName = " + jobseeker.JobseekerMiddleName + ", JobseekerLastName = " + jobseeker.JobseekerLastName + ", JobseekerAddress = " + 
        jobseeker.JobseekerAddress + ", JobseekerEmail = " + jobseeker.JobseekerEmail + ", JobseekerPhoneNumber = " + jobseeker.JobseekerPhoneNumber + 
        ", JobseekerBirthDate = " + jobseeker.JobseekerBirthDate + ", JobseekerCity = " + jobseeker.JobseekerCity + ", JobseekerState = " + 
        jobseeker.JobseekerState + ", JobseekerCountry = " + jobseeker.JobseekerCountry + ") WHERE JobseekerID = " + jobseekerID;
        statement.executeQuery(sql);
    }

}

package com.jobseeker.jobseeker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
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
    

    
    //GET SQL STATEMENTS

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
        CalendarToDate convert = new CalendarToDate();
        resultSet.next();
        JobseekerDTO jobseeker = new JobseekerDTO();
            jobseeker.JobseekerID = resultSet.getInt("PK_JobseekerID");
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName").trim();
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName").trim();
            jobseeker.JobseekerAddress = resultSet.getString("JobseekerAddress").trim();
            jobseeker.JobseekerPhoneNumber = resultSet.getString("JobseekerPhoneNumber").trim();
            jobseeker.JobseekerBirthDate = convert.SQLToZonedDateTime(resultSet.getDate("JobseekerBirthDate"));
            jobseeker.JobseekerState = resultSet.getString("JobseekerState").trim();
            jobseeker.JobseekerCity = resultSet.getString("JobseekerCity").trim();
            jobseeker.JobseekerCountry = resultSet.getString("JobseekerCountry").trim();
            jobseeker.JobseekerEmail = resultSet.getString("JobseekerEmail").trim();
            jobseeker.JobseekerTitle = resultSet.getString("JobseekerTitle");
        return jobseeker;
    }
    public ResultSet getJobseekerResume(int ID) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "Select * from Resume RIGHT JOIN Jobseekers ON Resume.FK_JobseekerID = Jobseekers.PK_JobseekerID";
        ResultSet resultSet = statement.executeQuery(sql + " where FK_JobseekerID = " + ID);
        return resultSet;
        
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


    //ADD SQL STATEMENTS

    public void addJobseeker(JobseekerDTO jobseeker) throws SQLException
    {
       CalendarToDate date = new CalendarToDate();
        String sql = "Insert into Jobseekers values(" + jobseeker.JobseekerID + ", '" + jobseeker.JobseekerFirstName + "', '" + jobseeker.JobseekerMiddleName +
        "', '" + jobseeker.JobseekerLastName + "', '" + jobseeker.JobseekerAddress + "', '" + jobseeker.JobseekerEmail + "', " + jobseeker.JobseekerPhoneNumber + 
        ", '" + date.zonedDateTimeToSQLString(jobseeker.JobseekerBirthDate)  + "', '" + jobseeker.JobseekerCity + "', '" + jobseeker.JobseekerState + "', '" + jobseeker.JobseekerCountry + "')";
        

        Statement statement = this.connection.createStatement();
        //System.out.println(sql);
        
        statement.execute(sql);
    }

    public void addJobseekerResume(String fileName, byte[] fileContent, int resumeID) throws SQLException
    {
        String sql = "Insert into Resume values(" 
        + fileName + ", " + fileContent + ", " + "')";
        

        Statement statement = this.connection.createStatement();
        //System.out.println(sql);
        
        statement.execute(sql);
    }



    //UPDATE SQL STATEMENTS

    public void updateJobseeker(JobseekerDTO jobseeker) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        CalendarToDate date = new CalendarToDate();
        System.out.println(jobseeker.JobseekerBirthDate);
        String sql = "UPDATE Jobseekers SET JobseekerFirstName = " 
        + (jobseeker.JobseekerFirstName == null ? null : "'" + jobseeker.JobseekerFirstName + "'")  + 
        ", JobseekerMiddleName = " + 
        (jobseeker.JobseekerMiddleName == null ? null : "'" + jobseeker.JobseekerMiddleName + "'")
        + ", JobseekerLastName = " +
        (jobseeker.JobseekerLastName == null ? null : "'" + jobseeker.JobseekerLastName + "'")
        + ", JobseekerAddress = " + 
        (jobseeker.JobseekerAddress == null ? null : "'" + jobseeker.JobseekerAddress + "'")
        + ", JobseekerEmail = " + 
        (jobseeker.JobseekerEmail == null ? null : "'" + jobseeker.JobseekerEmail + "'")
        + ", JobseekerPhoneNumber = " + 
        (jobseeker.JobseekerPhoneNumber == null ? null : "'" + jobseeker.JobseekerPhoneNumber + "'")
        + ", JobseekerBirthDate = " + 
        (jobseeker.JobseekerBirthDate == null ? null : "'" + date.zonedDateTimeToSQLString(jobseeker.JobseekerBirthDate) + "'")
        + ", JobseekerCity = " + 
        (jobseeker.JobseekerCity == null ? null : "'" + jobseeker.JobseekerCity + "'")
        + ", JobseekerState = " + 
        (jobseeker.JobseekerState == null ? null : "'" + jobseeker.JobseekerState + "'")
        + ", JobseekerCountry = " + 
        (jobseeker.JobseekerCountry == null ? null : "'" + jobseeker.JobseekerCountry + "'")
        + " WHERE PK_JobseekerID = " + jobseeker.JobseekerID;

        System.out.println(sql);
        statement.execute(sql);
        System.out.println("Updated");
    }

    public void updateJobseekerSkills(SkillsDTO skills) throws SQLException
    {
        Statement statement = this.connection.createStatement();

        String sql = "UPDATE Skills SET SkillsName = " 
        + (skills.SkillsName == null ? null : "'" + skills.SkillsName + "'")  + 
        ", SkillsNumYearsExperience = " + 
        skills.SkillsNumYearsExperience
        + " WHERE PK_SkillsID = " + skills.PK_SkillsID;

        System.out.println(sql);
        statement.executeQuery(sql);
    }

    public void updateJobseekerResume(String fileName, byte[] fileContent, int resumeID) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        /*
        String sql = "UPDATE Resume SET ResumeFileName = " 
        + (fileName == null ? null : "'" + fileName + "'")
        + ", ResumeFileContent = " + 
        (fileContent == null ? null : "LOAD_FILE('" + fileContent + "')")
        + " WHERE PK_ResumeID = " + resumeID;
        */
        String sql = "UPDATE Resume SET ResumeFileName = ?, ResumeFileContent = ? WHERE PK_ResumeID = ?";
        try (PreparedStatement prepared = connection.prepareStatement(sql)) {
            prepared.setString(1, fileName);
            prepared.setBytes(2, fileContent);
            prepared.setInt(3, resumeID);
            prepared.executeUpdate();
        }

        System.out.println(fileContent);
        //statement.execute(sql);
    }


    public void updateJobseekerEducation(ArrayList<EducationDTO> educationArray) throws SQLException
    {
        Statement statement = this.connection.createStatement();

        for(int i = 0; i < educationArray.size(); i++)
        {
            EducationDTO education = educationArray.get(i);
            String sql = "UPDATE EducationDetails SET EDInstitutionName = " 
            + (education.EDInstitutionName == null ? null : "'" + education.EDInstitutionName + "'")  + 
            ", EDHighestDegree = " + 
            (education.EDHighestDegree == null ? null : "'" + education.EDHighestDegree + "'")
            + " WHERE PK_EDID = " + education.PK_EDID;
            
            System.out.println(sql);
            statement.executeQuery(sql);
        }
    }


    public void updateJobseekerExperiences(ExperiencesDTO experiences) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        
        String sql = "UPDATE Experiences SET ExperiencesRoleName = " 
        + (experiences.ExperiencesRoleName == null ? null : "'" + experiences.ExperiencesRoleName + "'")  + 
        ", ExperiencesRoleDescription = " + 
        (experiences.ExperiencesRoleDescription == null ? null : "'" + experiences.ExperiencesRoleDescription + "'")
        + ", ExperiencesStartDate = " +
        (experiences.ExperiencesStartDate == null ? null : "'" + experiences.ExperiencesStartDate + "'")
        + ", ExperiencesEndDate = " + 
        (experiences.ExperiencesEndDate == null ? null : "'" + experiences.ExperiencesEndDate + "'")
        + " WHERE PK_ExperiencesID = " + experiences.PK_ExperiencesID;

        System.out.println(sql);
        statement.executeQuery(sql);
    }
    

    public void updateJobseekerCertificates(CertificatesDTO certificates) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "UPDATE ProfessionalCertificates SET ProfessionalCertificate = "
        + (certificates.ProfessionalCertificate == null ? null : "'" + certificates.ProfessionalCertificate + "'")  + 
        ", ExperiencesRoleDescription = " + 
        (certificates.ProfessionalCertificateDateObtained == null ? null : "'" + certificates.ProfessionalCertificateDateObtained + "'")
        + ", ExperiencesStartDate = " +
        (certificates.ProfessionalCertificateExpirationDate == null ? null : "'" + certificates.ProfessionalCertificateExpirationDate + "'")
        + " WHERE PK_ProfessionalCertificateID = " + certificates.PK_ProfessionalCertificateID;
        System.out.println(sql);
        statement.executeQuery(sql);
    }
}

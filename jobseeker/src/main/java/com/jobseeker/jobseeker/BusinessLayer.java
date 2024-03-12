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
        //ArrayList<JobseekerDTO> jobseekers = new ArrayList<JobseekerDTO>();
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
            jobseeker.JobseekerID = resultSet.getInt("PK_JobseekerID");
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName").trim();
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName").trim();
            jobseeker.JobseekerAddress = resultSet.getString("JobseekerAddress").trim();
            jobseeker.JobseekerCity = resultSet.getString("JobseekerCity").trim();
            jobseeker.JobseekerCountry = resultSet.getString("JobseekerCountry").trim();
            jobseeker.JobseekerEmail = resultSet.getString("JobseekerEmail").trim();
            jobseeker.JobseekerTitle = resultSet.getString("JobseekerTitle");
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
            jobseeker.JobseekerID = resultSet.getInt("PK_JobseekerID");
            jobseeker.JobseekerFirstName = resultSet.getString("JobseekerFirstName").trim();
            jobseeker.JobseekerMiddleName = resultSet.getString("JobseekerMiddleName");
            jobseeker.JobseekerLastName = resultSet.getString("JobseekerLastName").trim();
            jobseeker.JobseekerAddress = resultSet.getString("JobseekerAddress").trim();
            jobseeker.JobseekerCity = resultSet.getString("JobseekerCity").trim();
            jobseeker.JobseekerCountry = resultSet.getString("JobseekerCountry").trim();
            jobseeker.JobseekerEmail = resultSet.getString("JobseekerEmail").trim();
            jobseeker.JobseekerTitle = resultSet.getString("JobseekerTitle");
            jobseekersExperience.add(jobseeker);
            
        }
        return jobseekersExperience;
    }
    public JobseekerDTO getUserByID(int ID) throws SQLException
    {
        JobseekerDTO jobseeker = sqlDataLayer.getUserByID(ID);
        //jobseeker.JobseekerProfilePicture = resultSet.getBinaryStream("JobseekerProfilePicture"));


        return jobseeker;

    }
    public ArrayList<SkillsDTO> getJobseekerSkills(int ID) throws SQLException
    {
        ResultSet resultSet = sqlDataLayer.getJobseekerSkills(ID);
        ArrayList<SkillsDTO> jobseekerSkills = new ArrayList<SkillsDTO>();
        while(resultSet.next())
        {
            SkillsDTO jobseekerSkill = new SkillsDTO();
            jobseekerSkill.PK_SkillsID = resultSet.getInt("PK_SkillsID");
            jobseekerSkill.SkillsName = resultSet.getString("SkillsName").trim();
            jobseekerSkill.SkillsNumYearsExperience = resultSet.getInt("SkillsNumYearsExperience");
            jobseekerSkill.JobseekerID = resultSet.getInt("FK_JobseekerID");
            jobseekerSkills.add(jobseekerSkill);
        }
        return jobseekerSkills;
    }

    public ArrayList<EducationDTO> getJobseekerEducation(int ID) throws SQLException
    {
        ResultSet resultSet = sqlDataLayer.getJobseekerEducation(ID);
        ArrayList<EducationDTO> jobseekerEducation = new ArrayList<EducationDTO>();
        CalendarToDate convert = new CalendarToDate();
        while(resultSet.next())
        {
            EducationDTO jobseekerEdu = new EducationDTO();
            jobseekerEdu.PK_EDID = resultSet.getInt("PK_EDID");
            jobseekerEdu.EDInstitutionName = resultSet.getString("EDInstitutionName").trim();
            jobseekerEdu.EDHighestDegree = resultSet.getString("EDHighestDegree").trim();
            jobseekerEdu.EDStartingDate = convert.SQLToZonedDateTime(resultSet.getDate("EDStartingDate"));
            jobseekerEdu.EDEndingDate = convert.SQLToZonedDateTime(resultSet.getDate("EDEndingDate"));
            jobseekerEdu.FK_JobseekerID = resultSet.getInt("FK_JobseekerID");
            jobseekerEducation.add(jobseekerEdu);
        }
        return jobseekerEducation;
    }

    public ArrayList<ExperiencesDTO> getJobseekerExperiences(int ID) throws SQLException
    {
        ResultSet resultSet = sqlDataLayer.getJobseekerExperiences(ID);
        ArrayList<ExperiencesDTO> jobseekerExperiences = new ArrayList<ExperiencesDTO>();
        CalendarToDate convert = new CalendarToDate();
        while(resultSet.next())
        {
            ExperiencesDTO jobseekerExp = new ExperiencesDTO();
            jobseekerExp.PK_ExperiencesID = resultSet.getInt("PK_ExperiencesID");
            jobseekerExp.ExperiencesRoleName = resultSet.getString("ExperiencesRoleName").trim();
            jobseekerExp.ExperiencesRoleDescription = resultSet.getString("ExperiencesRoleDescription").trim();
            jobseekerExp.ExperiencesStartDate = convert.SQLToZonedDateTime(resultSet.getDate("ExperiencesStartDate"));
            jobseekerExp.ExperiencesEndDate = convert.SQLToZonedDateTime(resultSet.getDate("ExperiencesEndDate"));
            jobseekerExp.FK_JobseekerID = resultSet.getInt("FK_JobseekerID");
            jobseekerExperiences.add(jobseekerExp);
        }
        return jobseekerExperiences;
    }

    public ArrayList<CertificatesDTO> getJobseekerCertificates(int ID) throws SQLException
    {
        ResultSet resultSet = sqlDataLayer.getJobseekerCertificates(ID);
        ArrayList<CertificatesDTO> jobseekerCertificates = new ArrayList<CertificatesDTO>();
        CalendarToDate convert = new CalendarToDate();
        while(resultSet.next())
        {
            CertificatesDTO jobseekerCertificate = new CertificatesDTO();
            jobseekerCertificate.PK_ProfessionalCertificateID = resultSet.getInt("PK_ProfessionalCertificateID");
            jobseekerCertificate.ProfessionalCertificateDateObtained = convert.SQLToZonedDateTime(resultSet.getDate("ProfessionalCertificateDateObtained"));
            jobseekerCertificate.ProfessionalCertificateExpirationDate = convert.SQLToZonedDateTime(resultSet.getDate("ProfessionalCertificateExpirationDate"));
            jobseekerCertificate.ProfessionalCertificate = resultSet.getString("ProfessionalCertificate").trim();
            jobseekerCertificate.FK_JobseekerID = resultSet.getInt("FK_JobseekerID");
            jobseekerCertificates.add(jobseekerCertificate);
        }
        return jobseekerCertificates;
    }
    
    public void addNewJobseeker(JobseekerDTO jobseeker) throws SQLException
    {
        sqlDataLayer.addJobseeker(jobseeker);
    }

    public void updateJobseeker(JobseekerDTO jobseeker) throws SQLException
    {
        sqlDataLayer.updateJobseeker(jobseeker);
    }

    public void updateJobseekerSkills(SkillsDTO skills) throws SQLException
    {
        sqlDataLayer.updateJobseekerSkills(skills);
    }

    public void updateJobseekerEducation(EducationDTO education) throws SQLException
    {
        sqlDataLayer.updateJobseekerEducation(education);
    }
    
    public void updateJobseekerExperiences(ExperiencesDTO experiences) throws SQLException
    {
        sqlDataLayer.updateJobseekerExperiences(experiences);
    }
    
    public void updateJobseekerCertificates(CertificatesDTO certificates) throws SQLException
    {
        sqlDataLayer.updateJobseekerCertificates(certificates);
    }
}

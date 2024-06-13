package com.jobseeker.jobseeker;

import java.sql.Date;

public class Experiences1DTO {
    public int PK_ExperiencesID;
    public String ExperiencesRoleName;
    public String ExperiencesRoleDescription;
    public Date ExperiencesStartDate;
    public Date ExperiencesEndDate;
    public int FK_JobseekerID;

    public Experiences1DTO()
    {
        
    }
}

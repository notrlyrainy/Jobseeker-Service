package com.jobseeker.jobseeker;

import java.util.Date;

public class ExperiencesDTO {
    public int PK_ExperiencesID;
    public String ExperiencesRoleName;
    public String ExperiencesRoleDescription;
    public Date ExperiencesStartDate;
    public Date ExperiencesEndDate;
    public int FK_JobseekerID;
}

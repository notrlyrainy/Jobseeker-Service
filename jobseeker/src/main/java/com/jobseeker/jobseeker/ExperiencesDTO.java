package com.jobseeker.jobseeker;

import java.time.ZonedDateTime;

public class ExperiencesDTO {
    public int PK_ExperiencesID;
    public String ExperiencesRoleName;
    public String ExperiencesRoleDescription;
    public ZonedDateTime ExperiencesStartDate;
    public ZonedDateTime ExperiencesEndDate;
    public int FK_JobseekerID;
}

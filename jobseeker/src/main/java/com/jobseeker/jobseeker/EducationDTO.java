package com.jobseeker.jobseeker;
import java.time.ZonedDateTime;

public class EducationDTO {
    public int PK_EDID;
    public String EDInstitutionName;
    public String EDHighestDegree;
    public ZonedDateTime EDStartingDate;
    public ZonedDateTime EDEndingDate;
    public int FK_JobseekerID;

    public EducationDTO()
    {
        
    }
}

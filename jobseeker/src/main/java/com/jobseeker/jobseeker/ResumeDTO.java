package com.jobseeker.jobseeker;

public class ResumeDTO {
    public int PK_ResumeID;
    public String ResumeFileName;
    public byte[] ResumeFileContent;
    public int FK_JobseekerID;

    public ResumeDTO()
    {

    }
}

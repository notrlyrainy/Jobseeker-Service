package com.jobseeker.jobseeker;

import java.time.ZonedDateTime;


import java.awt.*;
public class JobseekerDTO
{
    public int JobseekerID;
    public String JobseekerFirstName;
    public String JobseekerMiddleName;
    public String JobseekerLastName;
    public String JobseekerAddress;
    public String JobseekerEmail;
    public String JobseekerTitle;
    public String JobseekerCity;
    public String JobseekerState;
    public String JobseekerCountry;
    public String JobseekerPhoneNumber;
    //@JsonFormat(pattern="yyyy-MM-dd")
    public ZonedDateTime JobseekerBirthDate;
    public ZonedDateTime JobseekerDateUpdated;
    public ZonedDateTime JobseekerDateCreated;
    public Image JobseekerProfilePicture;
    public JobseekerDTO()
    {
        
    }

}

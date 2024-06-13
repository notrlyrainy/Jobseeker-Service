package com.jobseeker.jobseeker;
import java.time.ZonedDateTime;

public class CertificatesDTO {
    public int PK_ProfessionalCertificateID;
    public String ProfessionalCertificate;
    public ZonedDateTime ProfessionalCertificateDateObtained;
    public ZonedDateTime ProfessionalCertificateExpirationDate;
    public int FK_JobseekerID;

    public CertificatesDTO()
    {
        
    }
}

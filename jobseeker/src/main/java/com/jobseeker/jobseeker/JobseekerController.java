package com.jobseeker.jobseeker;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RestController
public class JobseekerController {

	@CrossOrigin(origins = "*")
	@GetMapping("/GetAllJobSeekers")
	public ArrayList<JobseekerDTO> GetAllJobSeekers() {
		
		ArrayList<JobseekerDTO> jobseekerDTOs = new ArrayList<JobseekerDTO>();
		try {
			BusinessLayer jobseekerBusinessLayer = new BusinessLayer();
			jobseekerDTOs = jobseekerBusinessLayer.getAllUsers();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return jobseekerDTOs;

	}


	private void ValidateJobSeekerOBject(JobseekerDTO jobSeeker)
	{
		//if(jobSeeker.JobseekerCity==null)
		//	throw ;
		
		//if(jobSeeker.JobseekerState==null)
		//	throw ;
			
	}
	@PostMapping(value = "/AddJobSeeker",consumes = MediaType.APPLICATION_JSON_VALUE)
	     
  	String newJobseeker(@RequestBody JobseekerDTO newJobseeker) {
		try {
			ValidateJobSeekerOBject(newJobseeker);
			BusinessLayer jobSeekerBusinessLayer = new BusinessLayer();
			jobSeekerBusinessLayer.addNewJobseeker(newJobseeker);
		} 
		//catch()
		catch (SQLException ex) {
			ex.printStackTrace(); 
			//throw new ResponseStatusException(
           //HttpStatus.BAD_REQUEST, "Invalid Data", ex); 
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return "successfully added a jobseeker";
  }
  @GetMapping("/GetJobseekersByLastName")
	public ArrayList<JobseekerDTO> getUsersByLastName(@RequestParam String lastName) {
		
		///Validate(lastName)
		ArrayList<JobseekerDTO> jobseekerDTOs = new ArrayList<JobseekerDTO>();
		try {
			BusinessLayer jobbSeekerBusinessLayer = new BusinessLayer();
			jobseekerDTOs = jobbSeekerBusinessLayer.getUsersByLastName(lastName);
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return jobseekerDTOs;

	}

	
	@CrossOrigin(origins = "*")
	@GetMapping("/GetJobseekerByID")
		public JobseekerDTO getUserByID(@RequestParam int ID) throws SQLException
		{
			JobseekerDTO jobseeker = new JobseekerDTO();
			try {
				BusinessLayer jobseekerBusinessLayer = new BusinessLayer();
				jobseeker = jobseekerBusinessLayer.getUserByID(ID);

			}
			catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				
			}
			return jobseeker;

		}

		
	@CrossOrigin(origins = "*")
	@GetMapping("/GetJobseekerSkillsByID")
		public ArrayList<SkillsDTO> getUserSkillsByID(@RequestParam int ID) throws SQLException
		{
			ArrayList<SkillsDTO> skills = new ArrayList<SkillsDTO>();
			try {
				BusinessLayer jobseekerBusinessLayer = new BusinessLayer();
				skills = jobseekerBusinessLayer.getJobseekerSkills(ID);

			}
			catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				
			}
			return skills;

		}

		@CrossOrigin(origins = "*")
		@GetMapping("/GetJobseekerEducationByID")
		public ArrayList<EducationDTO> getJobseekerEducationByID(@RequestParam int ID) throws SQLException
		{
			ArrayList<EducationDTO> education = new ArrayList<EducationDTO>();
			try {
				BusinessLayer jobseekerBusinessLayer = new BusinessLayer();
				education = jobseekerBusinessLayer.getJobseekerEducation(ID);

			}
			catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				
			}
			return education;

		}

		@CrossOrigin(origins = "*")
		@GetMapping("/GetJobseekerExperiencesByID")
		public ArrayList<ExperiencesDTO> GetJobseekerExperiencesByID(@RequestParam int ID) throws SQLException
		{
			ArrayList<ExperiencesDTO> experiences = new ArrayList<ExperiencesDTO>();
			try {
				BusinessLayer jobseekerBusinessLayer = new BusinessLayer();
				experiences = jobseekerBusinessLayer.getJobseekerExperiences(ID);

			}
			catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				
			}
			return experiences;

		}

		@CrossOrigin(origins = "*")
		@GetMapping("/GetJobseekerCertificatesByID")
		public ArrayList<CertificatesDTO> GetJobseekerCertificatesByID(@RequestParam int ID) throws SQLException
		{
			ArrayList<CertificatesDTO> certificates = new ArrayList<CertificatesDTO>();
			try {
				BusinessLayer jobseekerBusinessLayer = new BusinessLayer();
				certificates = jobseekerBusinessLayer.getJobseekerCertificates(ID);

			}
			catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				
			}
			return certificates;

		}
}

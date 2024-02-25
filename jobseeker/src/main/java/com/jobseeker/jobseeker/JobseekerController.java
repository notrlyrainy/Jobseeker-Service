package com.jobseeker.jobseeker;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RestController
public class JobseekerController {

	@CrossOrigin(origins = "*")
	@GetMapping("/GetAllJobSeekers")
	public ArrayList<JobseekerDTO> GetAllJobSeekers() {
		
		ArrayList<JobseekerDTO> jobseekerDTOs = new ArrayList<JobseekerDTO>();
		try {
			BusinessLayer jobbSeekerBusinessLayer = new BusinessLayer();
			jobseekerDTOs = jobbSeekerBusinessLayer.getAllUsers();
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
}

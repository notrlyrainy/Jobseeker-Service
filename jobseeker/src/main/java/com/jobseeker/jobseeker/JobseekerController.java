package com.jobseeker.jobseeker;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
@RestController
public class JobseekerController {

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
	@PostMapping("/AddJobSeeker")
  	String newJobseeker(@RequestBody JobseekerDTO newJobseeker) {
		try {
			BusinessLayer jobSeekerBusinessLayer = new BusinessLayer();
			jobSeekerBusinessLayer.addNewJobseeker(newJobseeker);
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return "successfully added a jobseeker";
  }
  @GetMapping("/GetJobseekersByLastName")
	public ArrayList<JobseekerDTO> getUsersByLastName(@RequestParam String lastName) {
		
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
}

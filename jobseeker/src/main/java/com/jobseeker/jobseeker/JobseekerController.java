package com.jobseeker.jobseeker;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}

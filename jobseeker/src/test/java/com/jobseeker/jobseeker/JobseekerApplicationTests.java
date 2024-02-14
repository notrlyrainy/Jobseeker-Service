package com.jobseeker.jobseeker;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class JobseekerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void WhenLastNameIsGevenExpectAJobSeeker(){
		ArrayList<JobseekerDTO> jobseekerDTOs = new ArrayList<JobseekerDTO>();
		try
		{
			 BusinessLayer jobseekerBusinessLayer = new BusinessLayer();
			 jobseekerDTOs = jobseekerBusinessLayer.getUsersByLastName("Yang");
		}
		catch (SQLException ex){}
		catch (ClassNotFoundException ex){}
		assertEquals("Zhihui",jobseekerDTOs.get(0).JobseekerFirstName.toString().trim(),"Successfully Verified");

		

	}

	@Test
	void TestingEmployeeData()
	{
		IEmployeeDataLayer employeeDataLayer = new DummyEmployeeDataLayer();
		MyEmployee employee = new MyEmployee(employeeDataLayer);
		assertEquals("My Own Data", employee.getEmployee().toString());

	}

	ArrayList<JobseekerDTO> JobSeekerDummy(){
		ArrayList<JobseekerDTO> jobseekerDTOs = new ArrayList<JobseekerDTO>();
		JobseekerDTO jobseekerDTO = new JobseekerDTO();
		jobseekerDTO.JobseekerID = 10;
		jobseekerDTO.JobseekerFirstName = "Zhihui";
		jobseekerDTO.JobseekerMiddleName = "";
		jobseekerDTO.JobseekerLastName = "Yang"; 
		jobseekerDTOs.add(jobseekerDTO);
		return jobseekerDTOs;
	}


	@Test
	void WhenLastNameIsGevenExpectAJobSeeker2(){
		ArrayList<JobseekerDTO> jobseekerDTOs = new ArrayList<JobseekerDTO>();

		try{
			ArrayList<JobseekerDTO> JobSeekerDummyData = JobSeekerDummy();
			DataLayer sqDataLayer = mock(DataLayer.class);
			when(sqDataLayer.getAllUsersByDTO()).thenReturn(JobSeekerDummyData);
			
			BusinessLayer jobseekerBusinessLayer = new BusinessLayer();
			jobseekerDTOs = jobseekerBusinessLayer.getAllUsers();
		}
		catch (SQLException ex){}
		catch (ClassNotFoundException ex){}
		assertEquals("Zhihui",jobseekerDTOs.get(0).JobseekerFirstName.toString().trim(),"Successfully Verified");

		

	}

}

package com.jobseeker.jobseeker;

public class DummyEmployeeDataLayer implements IEmployeeDataLayer{
    public String getEmployeeDataFromDB() {
        return "My Own Data";
    }
}
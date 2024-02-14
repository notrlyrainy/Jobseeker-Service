package com.jobseeker.jobseeker;

public class MyEmployee {

    IEmployeeDataLayer employeeDataLayer;
    public MyEmployee(IEmployeeDataLayer employeeDataLayer)
    {
        this.employeeDataLayer = employeeDataLayer;
    }

    public String getEmployee()
    {
        return employeeDataLayer.getEmployeeDataFromDB();
    }
}
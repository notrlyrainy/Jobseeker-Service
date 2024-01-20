import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CommandClient {
    //read and understand how to add, delete, update sql server using code
    public static void main(String[] args) 
    {
        try 
        {
            BusinessLayer businessLayer = new BusinessLayer();
            ArrayList<JobseekerDTO> allJobseekers = businessLayer.getAllUsers();
            for(JobseekerDTO i : allJobseekers)
            {
                System.out.println(i.JobseekerFirstName);
                System.out.println(i.JobseekerMiddleName);
                System.out.println(i.JobseekerLastName);
            }
            System.out.println();
            /*
            ArrayList<JobseekerDTO> LiuJobseekers = businessLayer.getUsersByLastName("Liu");
            for(JobseekerDTO i : LiuJobseekers)
            {
                System.out.println(i.JobseekerFirstName);
                System.out.println(i.JobseekerMiddleName);
                System.out.println(i.JobseekerLastName);
            }
            */
            ArrayList<JobseekerDTO> javaJobseekers = businessLayer.getUserByExperience("java", 10);
            for(JobseekerDTO i : javaJobseekers)
            {
                System.out.println(i.JobseekerFirstName);
                System.out.println(i.JobseekerLastName);
            }
            
        }
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            classNotFoundException.printStackTrace();
        }
    }
}
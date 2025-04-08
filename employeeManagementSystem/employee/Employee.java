package employeeManagementSystem.employee;

import employeeManagementSystem.JobType;
import employeeManagementSystem.EmployeeInterface;

public abstract class Employee implements EmployeeInterface
{
    private String name;
    private JobType jobType;
    private double salary;

    public String getName()
    {
        return name;
    }
    public JobType getJobType()
    {
        return jobType;
    }
    public double getSalary()
    {
        return salary;
    }

    public Employee(String name, JobType jobType, double salary)
    {
        this.name = name;
        this.jobType = jobType;
        this.salary = salary;
    }

    public double calculateSalary()
    {
        return salary;
    }
    public void displayDetails()
    {
        System.out.print("Name: " + name + " | Job Type: " + jobType + " | Total Salary: " + this.calculateSalary());
    }
}
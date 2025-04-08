package employeeManagementSystem.employee;

import employeeManagementSystem.JobType;

public class InternEmployee extends Employee
{
    public InternEmployee(String name, JobType jobType, double salary)
    {
        super(name, jobType, salary);
    }

    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println();
    }
}
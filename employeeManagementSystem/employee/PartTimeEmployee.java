package employeeManagementSystem.employee;

import employeeManagementSystem.JobType;

public class PartTimeEmployee extends Employee
{
    private double hours;

    public PartTimeEmployee(String name, JobType jobType, double salary, double hours)
    {
        super(name, jobType, salary);
        this.logHours(hours);
    }

    public void logHours(double hours)
    {
        this.hours = hours;
    }

    @Override
    public double calculateSalary()
    {
        return this.getSalary()*hours;
    }
    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println();
    }
}

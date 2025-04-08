package employeeManagementSystem.employee;

import employeeManagementSystem.JobType;

public class FullTimeEmployee extends Employee
{
    //Yearly bonus
    private double bonus;

    public double getBonus()
    {
        return bonus;
    }

    public FullTimeEmployee(String name, JobType jobType, double salary, double bonus)
    {
        super(name, jobType, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary()
    {
        return this.getSalary() + bonus;
    }
    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println(" | Base Salary: " + this.getSalary() + " | Bonus: " + bonus);
    }
}
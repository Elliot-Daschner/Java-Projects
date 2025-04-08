package employeeManagementSystem;

import java.util.Scanner;
import employeeManagementSystem.employee.*;

public class EmployeeCreator 
{
    public static String getName(Scanner scanner)
    {
        return Query.stringQuery("Please enter Name.\nName: ", scanner);
    }
    public static JobType getJobType(Scanner scanner)
    {
        return JobType.values()[Query.query(JobType.toStringArray(), scanner)];
    }
    public static double getSalary(Scanner scanner)
    {
        return Query.doubleQuery("Please enter base salary.\nSalary: $", scanner);
    }
    public static double getRate(Scanner scanner)
    {
        return Query.doubleQuery("Please enter hour rate.\nRate: $", scanner);
    }
    public static double getHours(Scanner scanner)
    {
        return Query.doubleQuery("Please log hours.\nHours: ", scanner);
    }
    public static double getStipend(Scanner scanner)
    {
        return Query.doubleQuery("Please enter intern stipend value.\nStipend: $", scanner);
    }
    public static double getBonus(Scanner scanner)
    {
        return Query.doubleQuery("Please enter full time employee bonus.\nBonus: $", scanner);
    }

    public static Employee createEmployee(Scanner scanner)
    {
        String name = getName(scanner);
        JobType jobType = getJobType(scanner);
        double salary;
        switch (jobType)
        {
            case FULL_TIME:
            {
                salary = getSalary(scanner);
                double bonus = getBonus(scanner);
                return new FullTimeEmployee(name, jobType, salary, bonus);      
            }
            case PART_TIME:
            {
                salary = getRate(scanner);
                double hours = getHours(scanner);
                return new PartTimeEmployee(name, jobType, salary, hours);
            }
            case INTERN:
            {
                salary = getStipend(scanner);
                return new InternEmployee(name, jobType, salary);
            }
            default: 
            {
                System.out.println("Invalid input.");
                return null;
            }
        }
    }
}
package employeeManagementSystem;

import java.util.HashMap;
import java.util.Scanner;
import employeeManagementSystem.employee.*;

public class EmployeeManager
{
    private HashMap<String, Employee> employees;

    public EmployeeManager()
    {
        employees = new HashMap<>();
    }
    public void displayDetails()
    {
        for (Employee e : employees.values())
        {
            e.displayDetails();
        }
    }
    public void add(Employee e)
    {
        employees.put(e.getName(), e);
    }
    public void remove(Scanner scanner)
    {
        try
        {
            employees.remove(Query.stringQuery("Enter name of employee to remove.\nName: ", scanner));
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Employee not found.");
        }
    }
}
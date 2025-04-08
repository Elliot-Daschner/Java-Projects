package employeeManagementSystem;

import java.util.Scanner;

public class Terminal 
{
    private EmployeeManager manager;

    public Terminal(EmployeeManager manager)
    {
        this.manager = manager;
    }

    public void terminalChoices(Scanner scanner)
    {
        int choice = Query.query(new String[] {"Create Employee", "Remove Employee", "Display Employees"},  scanner);
        switch (choice+1)
        {
            case 1: 
            {
                manager.add(EmployeeCreator.createEmployee(scanner));
                terminalChoices(scanner);
            }
            case 2: 
            {
                try 
                {
                    manager.remove(scanner);
                    terminalChoices(scanner);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            case 3: 
            {
                manager.displayDetails();
                terminalChoices(scanner);
            }
            default: System.out.println("Invalid input.");
        }
    }
}
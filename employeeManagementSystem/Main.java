package employeeManagementSystem;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        Terminal terminal = new Terminal(manager);
        terminal.terminalChoices(scanner);
    }
}
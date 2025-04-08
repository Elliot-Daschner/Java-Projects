package employeeManagementSystem;

import java.util.Scanner;

public class Query 
{
    public static int query(String[] options, Scanner scanner)
    {
        System.out.println("Please select a choice by ");
        for (int i = 0; i < options.length; i++)
        {
            System.out.print(i+1 + ". " + options[i] + "\n");
        }
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        if (choice > options.length)
        {
            throw new IllegalArgumentException("Invalid choice. Please type an integer between 1 and " + options.length);
        }
        return choice-1;
    }
    public static String stringQuery(String message, Scanner scanner)
    {
        System.out.println(message);
        scanner.nextLine();
        String choiceString = scanner.nextLine();
        return choiceString;
    }
    public static double doubleQuery(String message, Scanner scanner)
    {
        System.out.println(message);
        double choiceDouble = scanner.nextDouble();
        return choiceDouble;
    }
}

package LabEight;

import java.util.ArrayList;

public class UserManager 
{
    ArrayList<User> users;

    public UserManager()
    {
        users = new ArrayList<User>();
    }

    public User get(String name)
    {
        for (User u : users)
        {
            if (u.getUsername().equals(name))
            {
                return u;
            }
        }
        throw new IllegalArgumentException("User not found.");
    }

    public void add(User user)
    {
        if (users.contains(user))
        {
            throw new IllegalArgumentException("User already exists.");
        }
        users.add(user);
    }

    public void display()
    {
        for (User u : users)
        {
            System.out.println(u);
        }
    }
}
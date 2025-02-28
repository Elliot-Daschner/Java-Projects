package LibraryManagementSystem;

public class Book
{
	//Class Attributes
	private String title;
	private String author;
	private boolean isAvailable;
	
	//Class Accessors
	public String getTitle()
	{
		return this.title;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public boolean isAvailable()
	{
		return this.isAvailable;
	}
	
	//toString()
	public String toString()
	{
		return "Title: " + this.title + ", Author: " + this.author + ", Is Available: " + this.isAvailable;
	}
	
	//Class Modifiers
	public void setTitle(String title)
	{
		this.title = title;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public void setAvailable(boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}
	
	//Class Constructors
	public Book(String title, String author)
	{
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}
	
	//Class Methods
	public boolean borrowBook()
	{
		if (isAvailable)
		{
			System.out.println("Book Checkout - " + this.toString());
			isAvailable = false;
			return true;
		}
		else
		{
			System.out.println(this.title + " has already been checked out.");
			return false;
		}
	}
	public boolean returnBook()
	{
		if (isAvailable)
		{
			System.out.println(this.title + " has already been returned.");
			return false;
		}
		else
		{
			System.out.println("Book Return - " + this.toString());
			isAvailable = true;
			return true;
		}
	}
	
	//Empty main method
	public static void main(String[] args) {}
}
package LibraryManagementSystem;

import java.util.ArrayList;

public class Member
{
	//Class Attributes
	private String user;
	private ArrayList<Book> checkout = new ArrayList<Book>();
	
	//Class Accessors
	public String getUser()
	{
		return this.user;
	}
	public ArrayList<Book> getCheckout()
	{
		return this.checkout;
	}
	public Book getBook(int index)
	{
		this.checkout.ensureCapacity(index + 1);
		if (this.checkout.get(index) == null)
		{
			System.out.println("Book not found.");
			this.checkout.trimToSize();
			
		}
		return this.checkout.get(index);
	}
	public Book getBook(String title)
	{
		for (Book book : this.checkout)
		{
			if (book.getTitle().equals(title))
			return book;
		}
		System.out.println("Book not found.");
		return null;
	}
	public int getIndex(Book book)
	{
		if (this.checkout.contains(book))
		{
			return checkout.indexOf(book);
		}
		System.out.println("Book not found.");
		return -1;
	}
	
	//Class Modifiers
	public void setUser(String user)
	{
		this.user = user;
	}
	
	//Class Constructor
	public Member(String user)
	{
		this.user = user;
	}
	public Member(String user, ArrayList<Book> checkout)
	{
		this.user = user;
		this.checkout = checkout;
	}
	
	//Class Methods
	public void borrowBook(Library library, String title)
	{
		System.out.println(this.user + " is trying to check out " + title +".");
		if (library.getBook(title) != null)
		{
			if ((library.getBook(title).borrowBook()))
			{
				this.checkout.add(library.getBook(title));
			}
		}
		else
		{
			System.out.println("Book not found.");
		}
	}
	public void returnBook(Library library, String title)
	{
		System.out.println(this.user + " is trying to return " + title + ".");
		if (library.getBook(title) != null)
		{
			if ((library.getBook(title).returnBook()))
			{
				this.checkout.remove(library.getBook(title));
			}
		}
		else
		{
			System.out.println("Book not found.");
		}
	}
	//Empty main method
	public static void main(String[] args) {}
}
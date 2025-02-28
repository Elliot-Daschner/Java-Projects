package LibraryManagementSystem;

import java.util.ArrayList;

public class Library
{
	//Class Attributes
	private ArrayList<Book> inventory = new ArrayList<Book>();
	
	//Class Accessors
	public ArrayList<Book> getInventory()
	{
		return this.inventory;
	}
	public Book getBook(int index)
	{
		this.inventory.ensureCapacity(index + 1);
		if (this.inventory.get(index) == null)
		{
			System.out.println("Book not found.");
			this.inventory.trimToSize();
			
		}
		return this.inventory.get(index);
	}
	public Book getBook(String title)
	{
		for (Book book : this.inventory)
		{
			if (book.getTitle().equals(title))
			return book;
		}
		System.out.println("Book not found.");
		return null;
	}
	public int getIndex(Book book)
	{
		if (this.inventory.contains(book))
		{
			return inventory.indexOf(book);
		}
		System.out.println("Book not found.");
		return -1;
	}
	
	//Class Modifiers
	public void add(Book book)
	{
		this.inventory.add(book);
	}
	public void set(int index, Book book)
	{
		this.inventory.set(index, book);
	}
	public void remove(String title)
	{
		this.inventory.remove(this.getBook(title));
	}
	public void removeAll(String title)
	{
		if (this.getBook(title) != null)
		{
			this.remove(title);
		}
	}
	public void remove(Book book)
	{
		if (this.inventory.contains(book))
		{
			this.inventory.remove(book);
		}
		else
		{
			System.out.println("Book not found.");
		}
	}
	public void removeAll(Book book)
	{
		if (this.inventory.contains(book))
		{
			while (this.inventory.contains(book))
			{
				this.inventory.remove(book);
			}
		}
		else
		{
			System.out.println("Book not found.");
		}
	}
	
	//Class Constructor
	public Library() {}
	public Library(ArrayList<Book> inventory)
	{
		this.inventory = inventory;
	}
	
	//Class Methods
	public void displayBooks()
	{
		for (Book book : this.inventory)
		{
			if (book != null)
			{
				System.out.println(book.toString());
			}
		}
	}
	
	//Empty main method
	public static void main(String[] args) {}
}
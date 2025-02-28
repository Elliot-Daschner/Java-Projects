package LibraryManagementSystem;

public class Main
{
	public static void main(String[] args)
	{
		Library lib = new Library();
		Book ntef = new Book("1984", "George Orwell");
		Book gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald");
		Book catInHat = new Book("The Cat in the Hat", "Dr. Seuss");
		lib.add(ntef); lib.add(gatsby); lib.add(catInHat);
		Member john = new Member("John");
		Member sally = new Member("Sally");
		john.borrowBook(lib, "1984");
		sally.borrowBook(lib, "The Great Gatsby");
		john.borrowBook(lib, "The Great Gatsby");
		sally.returnBook(lib, "The Great Gatsby");
		john.borrowBook(lib, "The Great Gatsby");
		sally.borrowBook(lib, "Harry Potter and the Philosopher's Stone");
		lib.displayBooks();
		lib.remove("The Cat in the Hat");
		sally.borrowBook(lib, "The Cat in the Hat");
	}
}
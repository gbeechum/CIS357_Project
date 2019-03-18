/*
 * File Name : Main.java
 * Part of Assignment : Project
 * Class : CIS357 WI19
 * Author : Graham Beechum
 * 
 * Purpose : Test the library system. 
 */
public class Main {
	public static void main(String[] args) {
		Catalogue Catalogue = new Catalogue();
		
		System.out.println("Librarian is created");
		System.out.println();
		
		Librarian lib1 = new Librarian("lib1@library.org","asdf");
		
		System.out.println(lib1.printAccountDetails(Catalogue));
		System.out.println();
		
		System.out.println("Librarian adds books to the catalogue");
		System.out.println();
		
		lib1.addBook(Catalogue, 810, "Shrek", "All Star");
		lib1.addBook(Catalogue, 811, "Shrek 2" , "All Star");
		lib1.addBook(Catalogue, 180, "Zanzabar", "Ayyyyyyyyyyyyyy");
		
		System.out.println(Catalogue.toString());
		System.out.println();
		
		System.out.println("New library member is created and checks out book by invoking the librarians checkout method");
		System.out.println();
		
		Member mem1 = new Member("mem1@gmail.com","password");
		
		lib1.checkout(811, mem1, Catalogue);
		
		System.out.println(Catalogue.toString());
		System.out.println();
		
		System.out.println("Printing the members details, including checked out books");
		System.out.println();
		
		System.out.println(mem1.printAccountDetails(Catalogue));
		System.out.println();
		
		System.out.println("Searching for specific books using overloaded search method");
		System.out.println();
		
		System.out.println("Searching for: Shrek");
		System.out.println(Catalogue.search("Shrek"));
		System.out.println();
		
		System.out.println("Searching for: 810");
		System.out.println(Catalogue.search(810));
		System.out.println();
		
		System.out.println("Creating a new Library Member and trying to check out a book");
		System.out.println("First using it's own checkout method, then having a librarian check it out");
		System.out.println();
		
		Member mem2 = new Member("mem2@yahoo.com", "password");
		mem2.checkout(810, mem2, Catalogue);
		lib1.checkout(810, mem2, Catalogue);
		System.out.println();
		
		System.out.println("Trying to check out an already checked out book");
		System.out.println();
		
		lib1.checkout(811, mem2, Catalogue);
		System.out.println();
		
		System.out.println("Using the comparator interface to sort by ISBN then Title");
		System.out.println();
		
		Catalogue.sortByISBN();
		System.out.println(Catalogue.toString());
		System.out.println();
		
		Catalogue.sortByTitle();
		System.out.println(Catalogue.toString());
	}
}

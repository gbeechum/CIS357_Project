/*
 * File Name : Catalogue.java
 * Part of Assignment : Project
 * Class : CIS357 WI19
 * Author : Graham Beechum
 * 
 * Purpose : used as a collection of books
 *  that a librarian can add to.
 */
import java.util.ArrayList;
import java.util.Collections;

public class Catalogue {
	// Array list that holds all the books 
	ArrayList<Book> arrCatalogue;
	
	Catalogue(){
		arrCatalogue = new ArrayList<Book>();
	}
	
	// Add a new instance of a book to the ArrayList
	public void addBook(int ISBN, String Title, String Author) {
		arrCatalogue.add(new Book(ISBN,Title,Author));
	}
	
	// Search for books with title or author that contain str.
	public String search(String str) {
		String returnString = "";
		for (Book b : arrCatalogue) {
			// if the title or author contain the search string.
			if ((b.getStrTitle().toLowerCase().contains(str.toLowerCase())) || (b.getStrAuthor().toLowerCase().contains(str.toLowerCase()))) {
				returnString = returnString.concat(b.toString());
			}
			returnString = returnString.concat("\n");
		}
		returnString = returnString.trim();
		return returnString;
	}
	
	// Search by ISBN number
	public String search(int ISBN) {
		String returnString = "";
		for (Book b : arrCatalogue) {
			if (b.getIntISBN() == ISBN) {
				returnString = returnString.concat(b.toString());
			}
		}
		return returnString;
	}
	
	// Print out the list of books.
	public String toString() {
		String returnString = "";
		
		for(Book book : arrCatalogue) {
			returnString = returnString.concat(book.toString() + "\n");
		}
		returnString = returnString.trim();
		return returnString;
	}
	
	// Using comparator interface to sort by ISBN.
	public void sortByISBN() {
		Collections.sort(arrCatalogue, new BookISBNComparator());
	}
	
	// Using comparator interface to sort by Title.
	public void sortByTitle() {
		Collections.sort(arrCatalogue, new BookTitleComparator());
	}
}

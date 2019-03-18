/*
 * File Name : Book.java
 * Part of Assignment : Project
 * Class : CIS357 WI19
 * Author : Graham Beechum
 * 
 * Purpose : Book object that will be
 * 	Collected into a list. 
 */
import java.util.Comparator;

public class Book{
	private int intID; // Allows for multiple instances of the same book.
	private int intISBN; // ISBN number for book.
	private String strTitle; // String title of book.
	private String strAuthor; // Author of the book.
	private boolean CheckedOut = false; // Indicates whether book is checked out.
	public static int intNumOfBooks = 0; // Keeps tally of total books.
	public Member checkedOutBy; // Indicates who has checked out the book. 
	
	Book(){
		// ID and ISBN will be considered invalid
		// if they have 0's
		setIntID(0);
		setIntISBN(0);
		setStrTitle(null);
		setStrAuthor(null);
	}
	
	Book(int ISBN, String Title, String Author){
		intNumOfBooks++;
		setIntID(intNumOfBooks);
		setIntISBN(ISBN);
		setStrTitle(Title);
		setStrAuthor(Author);
	}
	
	// Checks out book if it is available.
	public void Checkout(Member checkedOutBy) throws BookCheckedOutException{
		if(!isCheckedOut()) {
			setCheckedOut(true);
			setCheckedOutBy(checkedOutBy);
			System.out.println(this.strTitle + " is now checked out");
		} else {
			throw new BookCheckedOutException(this.strTitle);
		}
	}
	
	public int getIntId() {
		return intID;
	}
	
	public void setIntId(int intID) {
		this.intID = intID;
	}
	
	public int getIntISBN() {
		return intISBN;
	}
	
	public void setIntISBN(int intISBN) {
		this.intISBN = intISBN;
	}
	
	public String getStrTitle() {
		return strTitle;
	}
	
	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}
	
	public String getStrAuthor() {
		return strAuthor;
	}
	
	public void setStrAuthor(String strAuthor) {
		this.strAuthor = strAuthor;
	}

	
	public int getIntID() {
		return intID;
	}

	
	public void setIntID(int intID) {
		this.intID = intID;
	}

	
	public boolean isCheckedOut() {
		return CheckedOut;
	}

	
	public void setCheckedOut(boolean CheckedOut) {
		this.CheckedOut = CheckedOut;
	}
	
	public Member getCheckedOutBy() {
		return checkedOutBy;
	}

	public void setCheckedOutBy(Member checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}
	
	/*
	 * Override of toString that shows book info with ';' delimiter
	 */
	public String toString() {
		String returnString = "";
		returnString = returnString.concat(Integer.toString(this.intISBN));
		returnString = returnString.concat(";");
		returnString = returnString.concat(this.strTitle);
		returnString = returnString.concat(";");
		returnString = returnString.concat(this.strAuthor);
		returnString = returnString.concat(";");
		try {
			returnString = returnString.concat(this.checkedOutBy.strEMail);			
		} catch(Exception ex) {
			returnString = returnString.concat("Available");
		}
		returnString = returnString.concat(";");
		return returnString;
	}
}

//Comparator interface used to sort books by ISBN
class BookISBNComparator implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		int bookISBN1 = book1.getIntISBN();
		int bookISBN2 = book2.getIntISBN();
		return (bookISBN1 - bookISBN2);
	}
}

//Comparator interface used to sort books by Title
class BookTitleComparator implements Comparator<Book> {
	public int compare(Book book1, Book book2) {
		String title1 = book1.getStrTitle();
		String title2 = book2.getStrTitle();
		return title1.compareTo(title2);
	}
}

//Comparator interface used to sort books by Author
class BookAuthorComparator implements Comparator<Book> {
	public int compare(Book book1, Book book2) {
		String title1 = book1.getStrAuthor();
		String title2 = book2.getStrAuthor();
		return title1.compareTo(title2);
	}
}
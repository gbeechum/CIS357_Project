import java.util.Comparator;

/*
 * File Name : Book.java
 * Part of Assignment : Project
 * Class : CIS357 WI19
 * Author : Graham Beechum
 * 
 * Purpose : Book object that will be
 * 	Collected into a list. 
 */
public class Book{
	private int intID;
	private int intISBN;
	private String strTitle;
	private String strAuthor;
	private boolean CheckedOut = false;
	public static int intNumOfBooks = 0;
	
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
	
	public void Checkout() {
		if(!isCheckedOut()) {
			setCheckedOut(true);
		}
	}
	
	public static Comparator<Book> BookISBNComparator = new Comparator<Book>(){
		public int compare(Book book1, Book book2) {
			int bookISBN1 = book1.intISBN;
			int bookISBN2 = book2.intISBN;
			return (bookISBN1 - bookISBN2);
		}
	};
	
	public static Comparator<Book> BookTitleComparator = new Comparator<Book>() {
		public int compare(Book book1, Book book2) {
			String title1 = book1.strTitle;
			String title2 = book2.strTitle;
			return title1.compareTo(title2);
		}
	};
	
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

	
	private void setCheckedOut(boolean CheckedOut) {
		this.CheckedOut = CheckedOut;
	}
	
	public String toString() {
		String returnString = "";
		returnString = returnString.concat(Integer.toString(this.intISBN));
		returnString = returnString.concat(this.strTitle);
		returnString = returnString.concat(this.strAuthor);
		return returnString;
	}
}

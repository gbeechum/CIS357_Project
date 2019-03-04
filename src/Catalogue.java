import java.util.ArrayList;
import java.util.Collections;

public class Catalogue {
	ArrayList<Book> arrCatalogue;
	
	Catalogue(){
		arrCatalogue = new ArrayList<Book>();
	}
	
	public void addBook(int ISBN, String Title, String Author) {
		arrCatalogue.add(new Book(ISBN,Title,Author));
	}
	
	public String toString() {
		String returnString = "- Books -";
		
		for(Book book : arrCatalogue) {
			returnString = returnString.concat("\n" + book.toString());
		}
		returnString = returnString.concat("\n");
		return returnString;
	}
	
	public void sortByISBN() {
		Collections.sort(arrCatalogue, Book.BookISBNComparator);
	}
	
	public void sortByTitle() {
		Collections.sort(arrCatalogue, Book.BookTitleComparator);
	}
}

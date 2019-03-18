/*
 * File Name : Librarian.java
 * Part of Assignment : Project
 * Class : CIS357 WI19
 * Author : Graham Beechum
 * 
 * Purpose : Represents Librarian who can add books to the catalogue,
 *  checkout books, check them back in, and print account details.
 */
public class Librarian extends Account{
	
	Librarian(String eMail, String password){
		super(eMail, password);
	}
	
	public void addBook(Catalogue catalogue, int ISBN, String Title, String Author) {
		catalogue.arrCatalogue.add(new Book(ISBN,Title,Author));
	}

	/*
	 *  Tries to check out a book with a matching ISBN and gives a
	 *  user generated exception if it is already checked out.
	 */
	@Override
	void checkout(int ISBN, Member checkingOut, Catalogue catalogue) {
		for(Book b : catalogue.arrCatalogue) {
			if(b.getIntISBN() == ISBN) {
				try {
					b.Checkout(checkingOut);
				} catch (BookCheckedOutException ex) {
					System.out.println(ex);
				}
			}
		}
	}
	
	// Labels the book as not checked out and sets CheckedOutBy to null.
	void checkIn(int ISBN, Catalogue catalogue) {
		for (Book b : catalogue.arrCatalogue) {
			if(b.isCheckedOut()) {
				b.setCheckedOut(false);
				b.setCheckedOutBy(null);
			}
		}
	}

	@Override
	String printAccountDetails(Catalogue catalogue) {
		String returnString;
		returnString = "Librarian\n";
		returnString = returnString.concat("eMail: " + this.strEMail);
		return returnString;
	}
}

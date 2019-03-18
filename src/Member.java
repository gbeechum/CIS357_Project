/*
 * File Name : Member.java
 * Part of Assignment : Project
 * Class : CIS357 WI19
 * Author : Graham Beechum
 * 
 * Purpose : Represents a library member who can
 *  try to checkOut a book or view account details.
 */
public class Member extends Account{
	
	Member(String eMail, String password){
		super(eMail, password);
	}
	
	@Override
	void checkout(int ISBN, Member checkingOut, Catalogue catalogue) {
		System.out.println("You do not have permission to check out a book");
	}

	// Same as Librarian but also lists checked out books.
	@Override
	String printAccountDetails(Catalogue catalogue) {
		String returnString;
		returnString = "Library Member\n";
		returnString = returnString.concat("eMail: " + this.strEMail + "\n");
		returnString = returnString.concat("Books checked out\n");
		for(Book b : catalogue.arrCatalogue) {
			if (b.getCheckedOutBy() == this) {
				returnString = returnString.concat(b.getStrTitle() + "");
			}
		}
		return returnString;
	}

}

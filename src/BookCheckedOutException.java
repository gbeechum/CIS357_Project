/*
 * File Name : BookCheckedOutException
 * Part of Assignment : Project
 * Class : CIS357 WI19
 * Author : Graham Beechum
 * 
 * Purpose : Used when a book has already boon checked out
 *  and a user tries to check it out.
 */
public class BookCheckedOutException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	String strTitle;
	BookCheckedOutException(String strTitle){
		this.strTitle = strTitle;
	}
	
	public String toString() {
		return ("Book has already been checked out: " + strTitle);
	}
}

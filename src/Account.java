/*
 * File Name : Account.java
 * Part of Assignment : Project
 * Class : CIS357 WI19
 * Author : Graham Beechum
 * 
 * Purpose : Abstract class that other account types implement. 
 */
public abstract class Account {
	int intID;
	String strEMail;
	String strPassword;
	static int intNumOfAccounts = 0;
	
	// Assign ID number and set email and password.
	Account(String eMail, String password) {
		intNumOfAccounts++;
		this.intID = intNumOfAccounts;
		this.strEMail = eMail;
		this.strPassword = password;
	}
	
	// Lets the user set a new password. 
	void setPassword(String oldpassword, String newpassword) {
		if (oldpassword == this.strPassword) {
			this.strPassword = newpassword;
		}
	}
	
	abstract void checkout(int ISBN, Member checkingOut, Catalogue catalogue);
	abstract String printAccountDetails(Catalogue catalogue);
}

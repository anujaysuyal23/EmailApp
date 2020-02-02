package emailapp;

import java.util.Scanner;

public class Email {

	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix = "softcompany.com";
	
	// Constructor to receive the first and last name
	
	public Email(String firstname, String lastname)
	{
		this.firstname=firstname;
		this.lastname= lastname;
		
		
		// call a method asking for the department -return the department
		
		this.department =setDepartment();
	
		
		// call a method that return a random password
		this.password=randomPassword(defaultPasswordLength);
		System.out.println("Your Password is :"+this.password);
		
		// Combine elements to generate email
		email=" " + firstname.toLowerCase() + "." +lastname.toLowerCase () + "@" +department + companySuffix;
		
	}
	
	// Ask for the department
	
	private String setDepartment()
	{
		System.out.print(" New Worker : " +firstname + ". DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter Department Code: ");
		Scanner in=new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice ==1) {return "Sales";}
		else if (depChoice ==2) {return "Dev";}
		else if (depChoice ==3) {return "Acct";}
		else {return " ";}
	}
	
	// Generate a random password
	
	private String randomPassword(int length) {
		String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password =new char[length];
		for( int i=0;i<length;i++) {
			int rand=(int) (Math.random() * passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set the mailbox Capacity
	public void setMailBoxCapacity(int capacity)
	{
	this.mailboxCapacity = capacity;	
	}
	
	// Set the alternate mail
	public void setAlternateEmail(String altEmail)
	{
		this.alternateEmail = altEmail;
		
	}
	
	// Change the password
	public void changePassword(String password)
	{
		this.password=password;
	}

public int getMailboxCapacity() {return mailboxCapacity;}
public String getAlternateEmail() { return alternateEmail;}
public String getPassword() { return password;}

public String showInfo() {
	return "DISPLAY NAME: "+ firstname +" "+ lastname +
			"\nCOMPANY EMAIL:"+ email +
			"\n1MAILBOX CAPACITY: "+ mailboxCapacity + "mb";
}

	
}

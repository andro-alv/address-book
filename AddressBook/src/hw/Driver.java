package hw;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Driver {

	public static void main(String[] args) {
		
		//initialize addresbook arraylist
		ArrayList<Contact> addressBook = new ArrayList<Contact>();
		//add contact objects from assignment 
		addressBook.add(new Contact("James Smith", "James@yahoo.com", "4654646467", "Nothing"));
		addressBook.add(new Contact("James Rad", "jr2011@hotmail.com", "1121131322", "working at xyz"));
		addressBook.add(new Contact("Fernand Kuls", "kulsf@gmail.com", "2213333333", "Math teacher"));
		addressBook.add(new Contact("Amw Maiod", "J4777@hotmail.com", "4443312353", ""));
		addressBook.add(new Contact("Hani Wad", "hlole@ymail.com", "+44383224232", "Taxi"));
		addressBook.add(new Contact("Thomas Jake", "jthom@mail.com", "201122333", "Driving School"));
		addressBook.add(new Contact("Joe Moode", "JOE4@hotmail.com", "44433121251", ""));

		String userChoice;
		int menuNum;
		Scanner in = new Scanner(System.in);
		boolean goMenu = true;
		// do while to keep user in menu
		do {
			
			// print out options for user
			System.out.println("Main Window:");
			System.out.println("=============");
			System.out.println("Choose one of the following options: ");
			System.out.println("(1) Add a new contact.");
			System.out.println("(2) Search for contact.");
			System.out.println("(3) Display all contacts.");
			System.out.println("(4) Quit.");
			System.out.print("Enter your choice: ");
			userChoice = in.nextLine();
			try {
				//try to change the string option to int for case switch
				menuNum = Integer.parseInt(userChoice);
				switch (menuNum) {
				case 1:
					// call addContact method to add contact to address book
					Contact newContact = new Contact();
					newContact = newContact.addContact();
					addressBook.add(newContact);
					promptEnter();

					break;
				case 2:
					// call contactWindow method
					//search for contact by 1 of the options
					Contact.numberOrder(addressBook);
					Contact.contactWindow(addressBook);

					break;
				case 3:
					// call printList method to display all contacts in alphabetical order
					Contact.numberOrder(addressBook);
					Contact.printList(addressBook);
					System.out.println("Press Enter to go back to the Main window ");
					in.nextLine();

					break;
				case 4:
					// user breaks loop and exits menu1
					goMenu = false;
					break;

				default:
					// if input does not match 1-4 print message
					System.out.println("Please enter a number from 1-4.");
					break;
				}

			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Please input a number.");
			}

		} while (goMenu);

	}

	private static void promptEnter() {
		Scanner in = new Scanner(System.in);
		System.out.println("Saved successfully. Press Enter to go back to the Main window ");
		in.nextLine();

	}

}

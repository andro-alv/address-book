package hw;

import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Contact {

	// initialize contact class & its properties

	private String contactID;
	private String name;
	private String email;
	private String phoneNum;
	private String notes;

	static Scanner in = new Scanner(System.in);

	// constructor
	Contact() {

	}

	// initialize Contact properties
	Contact(String n, String e, String pN, String no) {

		name = n;
		email = e;
		phoneNum = pN;
		notes = no;

	}

	// getter & setter methods for contact properties
	public void setID(String contactID) {
		this.contactID = contactID;
	}

	public String getID() {
		return contactID;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	// method to add contact to address book
	public Contact addContact() {
		// print out prompts for contact properties
		System.out.println("Main Window --> Add a new contact window: (Enter the following information) ");
		System.out.println("=============================================================================");

		// initialize Contact object
		Contact newContact = new Contact();
		String name;
		String email;
		String phone;
		String notes;

		// ask user for info
		System.out.print("Name: ");
		name = in.nextLine();
		newContact.setName(name);
		System.out.print("Email: ");
		email = in.nextLine();
		newContact.setEmail(email);
		System.out.print("Phone: ");
		phone = in.nextLine();
		newContact.setPhoneNum(phone);
		System.out.print("Notes: ");
		notes = in.nextLine();
		newContact.setNotes(notes);
		System.out.println("------------------------------------------------------------------------------");
		return newContact;

	}

	// comparator method to print list in alphabetical order
	public static Comparator<Contact> nameComparator = new Comparator<Contact>() {
		public int compare(Contact con1, Contact con2) {
			String contact1Name = con1.getName().toUpperCase();
			String contact2Name = con2.getName().toUpperCase();
			return contact1Name.compareTo(contact2Name);
		}

	};

	// override print for Contact object
	@Override
	public String toString() {
		return contactID + " | " + name + "					| " + email + "					| " + phoneNum
				+ "					| " + notes;
	}

	// method to get the ID of the Contact objects in the address book
	public static void numberOrder(ArrayList<Contact> contacts) {
		for (int i = 0; i < contacts.size(); i++) {
			int curr = i + 1;
			String contactID = Integer.toString(curr);
			contacts.get(i).setID(contactID);
			;

		}

	}

	// method to print address book
	public static void printList(ArrayList<Contact> contacts) {
		System.out.println("Main Window --> Display All Contacts");
		System.out.println("=========================");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("ID | Name					| Email					| Phone					|Notes");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------");

		// clone addressbook arraylist
		ArrayList<Contact> copyContacts = (ArrayList<Contact>) contacts.clone();

		// sort the new arraylist
		Collections.sort(copyContacts, Contact.nameComparator);

		// print out the objects in the arraylist
		for (Contact str : copyContacts) {
			System.out.println(str);

		}

	}
	// delete Contact object method
	static void deleteContact(ArrayList<Contact> contactsArr, String contactID) {

		for (int i = 0; i < contactsArr.size(); i++) {
			if (contactsArr.get(i).contactID.equals(contactID)) {
				contactsArr.remove(i);
			}
		}

	}
	
	// search contact method returns boolean
	static boolean searchContact(ArrayList<Contact> cArrayList, int userChoice) {
		
		// initialize strings
		String searchFunction = "";
		String promptType = "";
		
		
		if (userChoice == 1) {
			searchFunction = "Name";
			promptType = "(1) Enter Name: ";
		} else if (userChoice == 2) {
			searchFunction = "Email";
			promptType = "(2) Enter Email: ";

		} else if (userChoice == 3) {
			searchFunction = "Phone";
			promptType = "(3) Enter Phone: ";

		}
		System.out.println();
		System.out.println("Main Window--> Search for Contact window --> Search by " + searchFunction);
		System.out.println("========================");
		String userInput;
		System.out.print(promptType);
		userInput = in.nextLine();
		
		//iterate through arraylist
		for (int i = 0; i < cArrayList.size(); i++) {
			
			//if object starts with the userinput then print out contacts
			if (cArrayList.get(i).name.toLowerCase().startsWith(userInput.toLowerCase())
					|| cArrayList.get(i).email.toLowerCase().startsWith(userInput.toLowerCase())
					|| cArrayList.get(i).phoneNum.toLowerCase().startsWith(userInput.toLowerCase())) {
				System.out.println("Search Results: ");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------");
				System.out
						.println("ID | Name					| Email					| Phone					|Notes");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(cArrayList.get(i));

			}

		}

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		
		//ask user if they want to delete a contact or return to menu
		System.out.println("Choose one of these options: ");
		System.out.println("(1) To delete a contact");
		System.out.println("(2) Back to main Window");
		System.out.println("Enter your choice: ");
		String deleteChoice;
		deleteChoice = in.nextLine();
		// delete contact with deleteContact method id userinput is 1
		if (deleteChoice.equals("1")) {
			System.out.println(
					"Main Window--> Search for Contact window --> Search by " + searchFunction + "Delete a Contact");
			System.out.println("========================");
			
			//ask user for contact ID to confirm deleting Contact from address book
			System.out.print("Enter contact ID: ");
			String contactID = "";
			contactID = in.nextLine();
			deleteContact(cArrayList, contactID);
			System.out.println("Deleted....press Enter to go back to main Window");
			in.nextLine();
			
			return false;

		} else if (deleteChoice.equals("2")) {
			return false;

		}
		return false;

	}
	
	//method for search option
	public static void contactWindow(ArrayList<Contact> contacts) {
		
		//print out options for user to search with
		System.out.println("Main Window--> Search for Contact window: (Choose one of the following options)");
		System.out.println("============================================================================");
		System.out.println("(1) Search by Name");
		System.out.println("(2) Search by Email");
		System.out.println("(3) Search by Phone");
		System.out.println("");

		String searchInput;
		int searchOption;

		
		//menu for search methods
		boolean goMenu = true;
		do {
			System.out.print("Choose one of the following options:");
			searchInput = in.nextLine();
			try {
				searchOption = Integer.parseInt(searchInput);
				switch (searchOption) {
				case 1:
					// search contact method using name 
					goMenu = searchContact(contacts, 1);

					break;
				case 2:
					//search contact method using email
					goMenu = searchContact(contacts, 2);
					break;
				case 3:
					//search contact method using phone  number
					goMenu = searchContact(contacts, 3);
					break;

				default:
					// throw error message
					System.out.println("Please enter a number from 1-3.");

				}

			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Please input a number.");
			}

		} while (goMenu);

	}

}

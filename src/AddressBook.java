import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

	Scanner s = new Scanner(System.in);
	HashMap<String, Contact> ContactBook;

	AddressBook() {
		this.ContactBook = new HashMap<String, Contact>();
	}

	public void addContact() {
		System.out.println("Add Contact");
		System.out.println("Enter first name:");
		String firstName = s.next();
		System.out.println("Enter last name");
		String lastName = s.next();
		System.out.println("Enter city");
		String city = s.next();
		System.out.println("Enter address");
		String address = s.next();
		System.out.println("Enter state");
		String state = s.next();
		System.out.println("Enter Zip");
		int zip = s.nextInt();
		System.out.println("Enter Phone");
		int phoneNumber = s.nextInt();
		System.out.println("Enter email");
		String email = s.next();

		ContactBook.put(firstName, new Contact(firstName, lastName, address, state, city, zip, phoneNumber, email));
	}

	public void editContact() {
		System.out.println("Edit contact:");
		System.out.println("Select Option:\n1.First Name\n2.Last Name\n3.City\n4.State\n5.Zip Code\n6.Phone\n7.Email");
		int choice = s.nextInt();
		System.out.println("Enter First Name of contact to be edited");
		String editName = s.next();
		Contact getContact;
		if(ContactBook.keySet().contains(editName))
		 getContact = ContactBook.get(editName);
		else {
			System.out.println("no such contact found");
			return;
		}
		switch (choice) {
		case 1:
			System.out.println("Enter new First Name");
			String newFName = s.next();
			ContactBook.remove(editName);
			getContact.setFirstName(newFName);
			ContactBook.put(newFName, getContact);
			System.out.println("Edited");
			break;
		case 2:
			System.out.println("Enter new Last Name");
			String newLName = s.next();
			getContact.setLastName(newLName);
			ContactBook.put(editName, getContact);
			System.out.println("Edited");
			break;
		case 3:
			System.out.println("Enter new City");
			String newCity = s.next();
			getContact.setCity(newCity);
			ContactBook.put(editName, getContact);
			System.out.println("Edited");
			break;
		case 4:
			System.out.println("Enter new State");
			String newState = s.next();
			getContact.setState(newState);
			ContactBook.put(editName, getContact);
			System.out.println("Edited");
			break;
		case 5:
			System.out.println("Enter new State");
			int newZip = s.nextInt();
			getContact.setZipCode(newZip);
			ContactBook.put(editName, getContact);
			System.out.println("Edited");
			break;
		case 6:
			System.out.println("Enter new Phone Number");
			int newPNumber = s.nextInt();
			getContact.setPhoneNumber(newPNumber);
			ContactBook.put(editName, getContact);
			System.out.println("Edited");
			break;
		case 7:
			System.out.println("Enter new Email");
			String newEmail = s.next();
			getContact.setEmailId(newEmail);
			ContactBook.put(editName, getContact);
			System.out.println("Edited");
			break;
		}
	}

	public void deleteContact() {
		System.out.println("Enter Name of Contact to delete");
		String deletedName = s.next();
		if(ContactBook.keySet().contains(deletedName)) {
			
		ContactBook.remove(deletedName);
		
		System.out.println("Contact deleted");
		}
		else {
			System.out.println("contact does not exist");
		}
	}

	public void showContacts() {
		System.out.println(ContactBook.values());
	}

}


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookImpl implements AddressBookIf {

	Scanner s = new Scanner(System.in);
	private Contact editContact;

	@Override
	public void addContact(HashMap<String, Contact> contactHashMap) {
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
		Contact contact = new Contact(firstName, lastName, address, state, city, zip, phoneNumber, email);
		contactHashMap.put(firstName, contact);
	}

	@Override
	public void showContacts(HashMap<String, Contact> contactHashMap) {
		for (Contact contact : contactHashMap.values())
			System.out.println(contact);
	}

	@Override
	public void editContact(HashMap<String, Contact> contactHashMap) {
		System.out.println("Edit contact:");
		System.out.println("Select Option:\n1.First Name\n2.Last Name\n3.City\n4.State\n5.Zip Code\n6.Phone\n7.Email");
		int choice = s.nextInt();
		System.out.println("Enter First Name of contact to be edited");
		String editName = s.next();
		int index = 0;

		if (!contactHashMap.containsKey(editName)) {
			System.out.println("no such conatact found");
			return;
		} else {
			editContact = contactHashMap.get(editName);
		}

		switch (choice) {
		case 1:
			System.out.println("Enter new First Name");
			String newFName = s.next();
			editContact.setFirstName(newFName);
			System.out.println("Edited");
			break;
		case 2:
			System.out.println("Enter new Last Name");
			String newLName = s.next();
			editContact.setLastName(newLName);
			System.out.println("Edited");
			break;
		case 3:
			System.out.println("Enter new City");
			String newCity = s.next();
			editContact.setCity(newCity);
			System.out.println("Edited");
			break;
		case 4:
			System.out.println("Enter new State");
			String newState = s.next();
			editContact.setState(newState);
			System.out.println("Edited");
			break;
		case 5:
			System.out.println("Enter new State");
			int newZip = s.nextInt();
			editContact.setZipCode(newZip);
			System.out.println("Edited");
			break;
		case 6:
			System.out.println("Enter new Phone Number");
			int newPNumber = s.nextInt();
			editContact.setPhoneNumber(newPNumber);
			System.out.println("Edited");
			break;
		case 7:
			System.out.println("Enter new Email");
			String newEmail = s.next();
			editContact.setEmailId(newEmail);
			System.out.println("Edited");
			break;
		}
	}

	@Override
	public void deleteContact(HashMap<String, Contact> contactHashMap) {
		System.out.println("Enter Name of Contact to delete");
		String deletedName = s.next();

		if (contactHashMap.containsKey(deletedName)) {
			contactHashMap.remove(deletedName);
			System.out.println("deleted " + deletedName);
			return;
		}
		System.out.println("there is no such contact with name " + deletedName);
	}
}

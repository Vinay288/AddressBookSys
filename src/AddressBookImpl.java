
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookImpl implements AddressBookIf {

	Scanner scanner = new Scanner(System.in);
	private Contact editContact;
	public HashMap<String, ArrayList<Contact>> personBasedOnCity;
	public HashMap<String, ArrayList<Contact>> personBasedOnState;

	public AddressBookImpl() {
		personBasedOnCity = new HashMap<String, ArrayList<Contact>>();
		personBasedOnState = new HashMap<String, ArrayList<Contact>>();
	}

	@Override
	public void addContact(HashMap<String, Contact> contactHashMap) {
		System.out.println("Add Contact");
		System.out.println("Enter first name:");
		String firstName = scanner.next();
		System.out.println("Enter last name");
		String lastName = scanner.next();
		System.out.println("Enter city");
		String city = scanner.next();
		System.out.println("Enter address");
		String address = scanner.next();
		System.out.println("Enter state");
		String state = scanner.next();
		System.out.println("Enter Zip");
		int zip = scanner.nextInt();
		System.out.println("Enter Phone");
		int phoneNumber = scanner.nextInt();
		System.out.println("Enter email");
		String email = scanner.next();
		Contact contact = new Contact(firstName, lastName, city, address, state, zip, phoneNumber, email);
		if (contact.equals(contactHashMap)) {
			System.out.println("there is already a student with name " + firstName);
			return;
		}
		addToPersonCityList(contact);
		addToPersonStateList(contact);
		contactHashMap.put(firstName, contact);
		System.out.println("student added");
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
		int choice = scanner.nextInt();
		System.out.println("Enter First Name of contact to be edited");
		String editName = scanner.next();

		if (!contactHashMap.containsKey(editName)) {
			System.out.println("no such conatact found");
			return;
		} else {
			editContact = contactHashMap.get(editName);
		}

		switch (choice) {
		case 1:
			System.out.println("Enter new First Name");
			String newFName = scanner.next();
			editContact.setFirstName(newFName);
			contactHashMap.remove(editName);
			contactHashMap.put(newFName, editContact);
			System.out.println("Edited");
			break;
		case 2:
			System.out.println("Enter new Last Name");
			String newLName = scanner.next();
			editContact.setLastName(newLName);
			System.out.println("Edited");
			break;
		case 3:
			System.out.println("Enter new City");
			String newCity = scanner.next();
			editContact.setCity(newCity);
			System.out.println("Edited");
			break;
		case 4:
			System.out.println("Enter new State");
			String newState = scanner.next();
			editContact.setState(newState);
			System.out.println("Edited");
			break;
		case 5:
			System.out.println("Enter new State");
			int newZip = scanner.nextInt();
			editContact.setZipCode(newZip);
			System.out.println("Edited");
			break;
		case 6:
			System.out.println("Enter new Phone Number");
			int newPNumber = scanner.nextInt();
			editContact.setPhoneNumber(newPNumber);
			System.out.println("Edited");
			break;
		case 7:
			System.out.println("Enter new Email");
			String newEmail = scanner.next();
			editContact.setEmailId(newEmail);
			System.out.println("Edited");
			break;
		}
	}

	@Override
	public void deleteContact(HashMap<String, Contact> contactHashMap) {
		System.out.println("Enter Name of Contact to delete");
		String deletedName = scanner.next();

		if (contactHashMap.containsKey(deletedName)) {
			contactHashMap.remove(deletedName);
			System.out.println("deleted " + deletedName);
			return;
		}
		System.out.println("there is no such contact with name " + deletedName);
	}

	public void addToPersonCityList(Contact contact) {
		if (personBasedOnCity.containsKey(contact.getCity()))
			personBasedOnCity.get(contact.getCity()).add(contact);
		else {
			ArrayList<Contact> contactList = new ArrayList<Contact>();
			contactList.add(contact);
			personBasedOnCity.put(contact.getCity(), contactList);
		}
	}

	public void addToPersonStateList(Contact contact) {
		if (personBasedOnState.containsKey(contact.getState()))
			personBasedOnState.get(contact.getState()).add(contact);
		else {
			ArrayList<Contact> contactList = new ArrayList<Contact>();
			contactList.add(contact);
			personBasedOnState.put(contact.getState(), contactList);
		}
	}

	public void showPersonList(HashMap<String, ArrayList<Contact>> personList) {
		ArrayList<Contact> personArrayList;
		for (String name : personList.keySet()) {
			System.out.println("for " + name);
			personArrayList = personList.get(name);
			for (Contact contact : personArrayList) {
				System.out.println(contact);
			}
		}

	}

	public void showCountofContactPersons() {
		System.out.println("number of contact persons by state");
		for (String name : personBasedOnState.keySet()) {
			System.out.println("for state " + name + " count is " + personBasedOnState.get(name).size());
		}
		System.out.println("number of contact persons by city is");
		for (String name : personBasedOnCity.keySet()) {
			System.out.println("for city " + name + " count is " + personBasedOnCity.get(name).size());
		}
	}
}
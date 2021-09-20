
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

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

	public void showPersonList(String inputName, HashMap<String, ArrayList<Contact>> personList) {
		personList.values().stream()
				.flatMap(c -> c.stream().filter(s -> s.getCity().equals(inputName) || s.getState().equals(inputName)))
				.forEach(person -> System.out.println("details are:\n" + person));
	}

	public void countofContactPersons(String inputName, HashMap<String, ArrayList<Contact>> personList) {
		System.out.print("count of contacts persons in " + inputName + " is ");
		long count = personList.values().stream()
				.map(c -> c.stream().filter(s -> s.getCity().equals(inputName) || s.getState().equals(inputName)))
				.count();
		System.out.print(count + "\n");
	}

	public void sortContacts(HashMap<String, Contact> addressBook, int sortKey) {
		ArrayList<Contact> personList = new ArrayList<Contact>(addressBook.values());
		if (sortKey == 0) {
			List<Contact> sortedPersonList = personList.stream()
					.sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName())).collect(Collectors.toList());
			System.out.println("contacts after sorting ");
			System.out.println(sortedPersonList);
		}
		switch (sortKey) {
		case 0:
			List<Contact> sortedPersonList = personList.stream()
					.sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName())).collect(Collectors.toList());
			System.out.println("contacts after sorting ");
			System.out.println(sortedPersonList);
			break;
		case 1:
			List<Contact> sortedPersonByCityList = personList.stream()
					.sorted((s1, s2) -> s1.getCity().compareTo(s2.getCity())).collect(Collectors.toList());
			System.out.println("contacts after sorting ");
			System.out.println(sortedPersonByCityList);
			break;
		case 2:
			List<Contact> sortedPersonByStateList = personList.stream()
					.sorted((s1, s2) -> s1.getState().compareTo(s2.getState())).collect(Collectors.toList());
			System.out.println("contacts after sorting ");
			System.out.println(sortedPersonByStateList);
			break;
		case 3:
			List<Contact> sortedPersonByZipList = personList.stream()
					.sorted((s1, s2) -> Integer.valueOf(s1.getZipCode()).compareTo(Integer.valueOf(s2.getZipCode())))
					.collect(Collectors.toList());
			System.out.println("contacts after sorting ");
			System.out.println(sortedPersonByZipList);
			break;
		default:
			break;
		}

	}

	public void writeToFile(String name, HashMap<String, Contact> addressBook) {
		StringBuffer contactBuffer = new StringBuffer();
		addressBook.values().forEach(contact -> {
			String contactString = contact.toString().concat("\n");
			contactBuffer.append(contactString);
		});

		try {
			Files.write(Paths.get(name.concat(".txt")), contactBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String[] getStringArray(Contact contact) {
		String stringArray[] = new String[8];
		stringArray[0]=contact.getFirstName();
		stringArray[1]=contact.getLastName();
		stringArray[2]=contact.getCity();
		stringArray[3]=contact.getAddress();
		stringArray[4]=contact.getState();
		stringArray[5]=contact.getEmailId();
		stringArray[6]=Integer.toString(contact.getZipCode());
		stringArray[7]=Integer.toString(contact.getPhoneNumber());
		return stringArray;
	}
	public void writeToCsvFile(String name,HashMap<String, Contact> addressBook) {
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(name.concat(".csv")));
			List<String[]> contactsArrayList= new ArrayList();
			for(Contact contact:addressBook.values()) {
				contactsArrayList.add(getStringArray(contact));
			}
			writer.writeAll(contactsArrayList);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
	
	public void readFromCsvFile(String name,HashMap<String, Contact> addressBook) {
		 try {
		        FileReader filereader = new FileReader(name+".csv");
		        CSVReader csvReader = new CSVReader(filereader);
		        String[] nextRecord;
		        while ((nextRecord = csvReader.readNext()) != null) {
		            for (String cell : nextRecord) {
		                System.out.print(cell + "\t");
		            }
		            System.out.println();
		        }
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
	}

	public void readFromFile(String name, HashMap<String, Contact> addressBook) {
		List<Contact> listOfContacts = new ArrayList<Contact>();
		try {
			String newFile = "src/" + name + ".txt";
			Files.lines(Paths.get(name.concat(".txt"))).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
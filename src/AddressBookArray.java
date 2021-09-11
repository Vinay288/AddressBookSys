
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookArray {
	
	private AddressBook addressBook;
	private Map<String, AddressBook> addressBooksArray;
	Scanner s = new Scanner(System.in);
	
	AddressBookArray() {
		addressBooksArray = new HashMap<String, AddressBook>();
	}

	public void addAddressBooks() {
		System.out.println("enter address book name");
		String name = s.next();
		int index = 0;
		if (addressBooksArray.containsKey(name)) {
			System.out.println(name + " this address book alredy exists");
			return;
		}
		System.out.println(name + " this contact book is created");
		addressBooksArray.put(name, new AddressBook(name));
	}

	public void showAddressBook() {
		System.out.println(" address books are as follows");
		for (String bookName : addressBooksArray.keySet()) {
			System.out.println(bookName);
		}
	}

	public AddressBook selectAddressBook(String name) {	
		if (addressBooksArray.containsKey(name)) {
			addressBook = addressBooksArray.get(name);
			return addressBook;
		}
		System.out.println("no such contact book");
		return null;
	}
	public void searchByState(String name, String state) {
		for(AddressBook addressBook:addressBooksArray.values()) {
			for(Contact contact:addressBook.getContact()) {
				if(contact.getFirstName().equals(name) && contact.getState().equals(state)) {
					System.out.println(name+" is found ");
					System.out.println(contact);
				}
			}
		}
	}
	public void searchByCity(String name, String city) {
		for(AddressBook addressBook:addressBooksArray.values()) {
			for(Contact contact:addressBook.getContact()) {
				if(contact.getFirstName().equals(name) && contact.getCity().equals(city)) {
					System.out.println(name+" is found ");
					System.out.println(contact);
				}
			}
		}
	}
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	private AddressBookImpl addressBookArray[];
	private AddressBookImpl addressBook;
	private Map<String, AddressBookImpl> addressBooks;
	private int bookNumber = -1;
	private static int numberOfAddressBooks = 0;
	Scanner s = new Scanner(System.in);

	AddressBook() {
		addressBooks = new HashMap<String, AddressBookImpl>();
	}

	public void addAddressBooks() {
		System.out.println("enter address book name");
		String name = s.next();
		int index = 0;
		if (addressBooks.containsKey(name)) {
			System.out.println(name + " this addres book alredy exists");
			return;
		}
		System.out.println(name + " this contact book is created");
		addressBooks.put(name, new AddressBookImpl(name));
	}

	public void showAddressBook() {
		System.out.println(" address books are as follows");
		for (String bookName : addressBooks.keySet()) {
			System.out.println(bookName);
		}
	}

	public int selectAddressBook() {
		System.out.println("enter Contact book name");
		String name = s.next();
		int index = 0;
		if (addressBooks.containsKey(name)) {
			addressBook = addressBooks.get(name);
			return 1;
		}
		System.out.println("no such contact book");
		return -1;
	}

	public void addContact() {
		addressBook.addContact();
	}

	public void editContact() {
		addressBook.editContact();
	}

	public void showContacts() {
		addressBook.showContacts();
	}

	public void deleteContact() {
		addressBook.deleteContact();
	}
}

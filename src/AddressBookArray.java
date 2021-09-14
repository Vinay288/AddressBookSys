
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AddressBookArray {

	private AddressBook addressBook;
	private Map<String, AddressBook> addressBooksArray;
	Scanner scanner = new Scanner(System.in);

	AddressBookArray() {
		addressBooksArray = new HashMap<String, AddressBook>();
	}

	public void addAddressBooks() {
		System.out.println("enter address book name");
		String name = scanner.next();
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
		Predicate<Contact> isEqual = c -> ((c.getFirstName().equals(name)) && (c.getState().equals(state)));
		addressBooksArray.values().stream().flatMap(contactsArray -> addressBook.getContact().stream().filter(isEqual))
				.forEach(n -> System.out.println(name + " is found and details are \n" + n));

	}

	public void searchByCity(String name, String city) {
		Predicate<Contact> isEqual = c -> ((c.getFirstName().equals(name)) && (c.getState().equals(city)));
		addressBooksArray.values().stream().flatMap(contactsArray -> addressBook.getContact().stream().filter(isEqual))
				.forEach(n -> System.out.println(name + " is found and details are \n" + n));
	}
}

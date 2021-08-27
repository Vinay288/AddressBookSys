import java.util.Scanner;

public class MultipleAddressBook {
	private AddressBook addressBookArray[];
	private int bookNumber = -1;
	private static int numberOfAddressBooks = 0;
	Scanner s = new Scanner(System.in);

	MultipleAddressBook() {
		addressBookArray = new AddressBook[10];
	}

	public void addAddressBooks() {
		System.out.println("enter address book name");
		String name = s.next();
		int index = 0;
		for (index = 0; index < numberOfAddressBooks; index++) {
			if (addressBookArray[index].getAddressBookName().equals(name)) {
				System.out.println("this contact book alredy exists");
				
			}
		}
		addressBookArray[numberOfAddressBooks] = new AddressBook(name);
		numberOfAddressBooks++;
	}

	public int selectAddressBook() {
		System.out.println("enter Contact book name");
		String name = s.next();
		int index = 0;
		for (index = 0; index < numberOfAddressBooks; index++) {
			if (addressBookArray[index].getAddressBookName().equals(name)) {
				bookNumber = index;
				break;
			}
			else
				continue;
		}
		if (bookNumber == -1) {
			System.out.println("no such contact book");
			return -1;
		}
		return 1;
	}

	public void addContact() {
		addressBookArray[bookNumber].addContact();
	}

	public void editContact() {
		addressBookArray[bookNumber].editContact();
	}

	public void showContacts() {
		addressBookArray[bookNumber].showContacts();
	}

	public void deleteContact() {
		addressBookArray[bookNumber].deleteContact();
	}

}

import java.util.Scanner;

public class AddressBookMain {
	static String addressBookName = "";

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		AddressBookArray addressBooks = new AddressBookArray();
		menu(addressBooks);
	}

	public static void menu(AddressBookArray addressBooks) {
		AddressBookImpl addressOperation = new AddressBookImpl();
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			System.out.println(
					"1.create new address book\n2.edit existing address book\n3.show address books\n4.search\n5.show persons by city\n6.show persons by state\n7.count by city\n8.count by state\n9.exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:

				addressBooks.addAddressBooks();
				break;
			case 2:
				System.out.println("enter Contact book name");
				addressBookName = scanner.next();
				if (addressBooks.selectAddressBook(addressBookName) != null)
					contactsMenu(addressBooks, addressOperation);
				break;
			case 3:
				addressBooks.showAddressBook();
				break;
			case 4:
				System.out.println("enter first name");
				String firstName = scanner.next();
				System.out.println("press 1 to search by state or 2 to search by city");
				int searchChoice = scanner.nextInt();
				if (searchChoice == 1) {
					System.out.println("enter state name");
					String state = scanner.next();
					addressBooks.searchByState(firstName, state);
				} else if (searchChoice == 2) {
					System.out.println("enter city name");
					String city = scanner.next();
					addressBooks.searchByCity(firstName, city);
				}
				break;
			case 5:
				System.out.println("enter city name");
				String city = scanner.next();
				addressOperation.showPersonList(city, addressOperation.personBasedOnCity);
				break;
			case 6:
				System.out.println("enter state name");
				String state = scanner.next();
				addressOperation.showPersonList(state, addressOperation.personBasedOnState);
				break;
			case 7:
				System.out.println("enter city name");
				city = scanner.next();
				addressOperation.countofContactPersons(city, addressOperation.personBasedOnCity);
				break;
			case 8:
				System.out.println("enter state name");
				state = scanner.next();
				addressOperation.countofContactPersons(state, addressOperation.personBasedOnState);
				break;
			default:
				System.out.println("BYE!!");
				return;
			}
		}

	}

	public static void contactsMenu(AddressBookArray addressBooks, AddressBookImpl addressOperation) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("1.add contact\n2.show contact\n3.edit contact\n4.delete\n5.sort contacts\n6.exit");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			addressOperation.addContact(addressBooks.selectAddressBook(addressBookName).addressBook);
			break;
		case 2:
			addressOperation.showContacts(addressBooks.selectAddressBook(addressBookName).addressBook);
			break;
		case 3:
			addressOperation.editContact(addressBooks.selectAddressBook(addressBookName).addressBook);
			break;
		case 4:
			addressOperation.deleteContact(addressBooks.selectAddressBook(addressBookName).addressBook);
			break;
		case 5:
			System.out.println("1.by city\n2.by state\n3.by zip");
			int sortChoice = scanner.nextInt();
			addressOperation.sortContacts(addressBooks.selectAddressBook(addressBookName).addressBook, sortChoice);
			break;
		default:
			return;
		}
	}
}

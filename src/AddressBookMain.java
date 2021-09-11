import java.util.Scanner;

public class AddressBookMain {
	static String addressBookName = "";

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		AddressBookArray addressBooks = new AddressBookArray();
		menu(addressBooks);
	}

	public static void menu(AddressBookArray addressBooks) {

		Scanner s = new Scanner(System.in);
		for (;;) {
			System.out.println(
					"1.create new address book\n2.edit existing address book\n3.show address books\n4.search\n5.exit");

			int choice = s.nextInt();
			switch (choice) {
			case 1:
				addressBooks.addAddressBooks();
				break;
			case 2:
				System.out.println("enter Contact book name");
				addressBookName = s.next();
				if (addressBooks.selectAddressBook(addressBookName) != null)
					contactsMenu(addressBooks);
				break;
			case 3:
				addressBooks.showAddressBook();
				break;
			case 4:
				System.out.println("enter first name");
				String firstName=s.next();
				System.out.println("press 1 to search by state or 2 to search by city");
				int searchChoice=s.nextInt();
				if(searchChoice==1) {
					System.out.println("enter state name");
					String state=s.next();
					addressBooks.searchByState(firstName, state);
				}
				else if(searchChoice==2) {
					System.out.println("enter city name");
					String city=s.next();
					addressBooks.searchByCity(firstName, city);
				}
				break;
			default:
				return;
			}
		}

	}

	public static void contactsMenu(AddressBookArray addressBooks) {
		AddressBookImpl addressOperation = new AddressBookImpl();
		Scanner s = new Scanner(System.in);
		System.out.println("1.add contact\n2.show contact\n3.edit contact\n4.delete\n5.exit");
		int choice = s.nextInt();

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
		default:
			return;
		}
	}
}

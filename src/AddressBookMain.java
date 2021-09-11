import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		AddressBookArray addressBooks = new AddressBookArray();
		menu(addressBooks);
	}

	public static void menu(AddressBookArray addressBooks) {
		AddressBookImpl addressOperation = new AddressBookImpl();
		String addressBookName = "";
		Scanner s = new Scanner(System.in);
		for (;;) {
			for (;;) {
				System.out.println(
						"1.create new address book\n2.edit existing address book\n3.show address books\n4.exit");

				int choice = s.nextInt();
				if (choice == 1) {
					addressBooks.addAddressBooks();
				} else if (choice == 2) {
					System.out.println("enter Contact book name");
					addressBookName = s.next();
					if (addressBooks.selectAddressBook(addressBookName) != null)
						break;
				} else if (choice == 3) {
					addressBooks.showAddressBook();
				} else {
					System.out.println("Bye!!");
					return;
				}
			}

			System.out.println("1.add contact\n2.show contact\n3.edit contact\n4.delete\n5.exit");
			int choice = s.nextInt();
			if (choice == 5)
				break;

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
			}

		}
	}
}

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		AddressBook addressBooks = new AddressBook();

		menu(addressBooks);
	}

	public static void menu(AddressBook addressBooks) {
		Scanner s = new Scanner(System.in);
		for (;;) {
			for (;;) {
				System.out.println(
						"1.create new address book\n2.edit existing address book\n3.show address books\n4.exit");

				int choice = s.nextInt();
				if (choice == 1) {
					addressBooks.addAddressBooks();
				} else if (choice == 2) {
					if (addressBooks.selectAddressBook() == 1)
						break;
				} else if (choice == 3) {
					addressBooks.showAddressBook();
				} else {
					return;
				}
			}

			System.out.println("1.add contact\n2.show contact\n3.edit contact\n4.delete\n5.exit");
			int choice = s.nextInt();
			if (choice == 5)
				break;

			switch (choice) {
			case 1:
				addressBooks.addContact();
				break;
			case 2:
				addressBooks.showContacts();
				break;
			case 3:
				addressBooks.editContact();
				break;
			case 4:
				addressBooks.deleteContact();
				break;
			}

		}
	}
}

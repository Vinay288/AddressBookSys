import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Address Book Program");
		AddressBook addressBook = new AddressBook();
		for (;;) {
			System.out.println("1.add contact\n2.show contact\n3.edit contact\n4.delete\n5.exit");
			int value = s.nextInt();
			if (value == 5)
				break;
			switch (value) {
			case 1:
				addressBook.addContact();
				break;
			case 2:
				addressBook.showContacts();
				break;
			case 3:addressBook.editContact();
					break;
			case 4:
				addressBook.deleteContact();
				break;
			}

		}
		System.out.println("exited");

	}

}

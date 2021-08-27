import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Address Book Program");
		AddressBook addressBook = new AddressBook();
		addressBook.addContact();
		addressBook.showContacts();

	}

}

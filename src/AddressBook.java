import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class AddressBook {

	Scanner s = new Scanner(System.in);
	private Contact contactBook[];
	private static int numberOfConatcts=0;

	AddressBook() {
		this.contactBook = new Contact[20];
	}
	public void addContact() {
		System.out.println("Add Contact");
		System.out.println("Enter first name:");
		String firstName = s.next();
		System.out.println("Enter last name");
		String lastName = s.next();
		System.out.println("Enter city");
		String city = s.next();
		System.out.println("Enter address");
		String address = s.next();
		System.out.println("Enter state");
		String state = s.next();
		System.out.println("Enter Zip");
		int zip = s.nextInt();
		System.out.println("Enter Phone");
		int phoneNumber = s.nextInt();
		System.out.println("Enter email");
		String email = s.next();
		contactBook[numberOfConatcts]= new Contact(firstName, lastName, address, state, city, zip, phoneNumber, email);
		numberOfConatcts++;
	}
	public void showContacts() {
		for(int i=0;i<numberOfConatcts;i++) {
			System.out.println(contactBook[i]);
		}
	}
	

}

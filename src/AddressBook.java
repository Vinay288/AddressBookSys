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
	public void editContact() {
		System.out.println("Edit contact:");
		System.out.println("Select Option:\n1.First Name\n2.Last Name\n3.City\n4.State\n5.Zip Code\n6.Phone\n7.Email");
		int choice = s.nextInt();
		System.out.println("Enter First Name of contact to be edited");
		String editName = s.next();
		int index=0;
		for(index=0;index<numberOfConatcts;index++) {
			if(contactBook[index].getFirstName().equals(editName)) {
				break;
			}
			else {
				System.out.println("no such conatact found");
				return;
			}
		}
		switch (choice) {
		case 1:
			System.out.println("Enter new First Name");
			String newFName = s.next();
			contactBook[index].setFirstName(newFName);
			System.out.println("Edited");
			break;
		case 2:
			System.out.println("Enter new Last Name");
			String newLName = s.next();
			contactBook[index].setLastName(newLName);
			System.out.println("Edited");
			break;
		case 3:
			System.out.println("Enter new City");
			String newCity = s.next();
			contactBook[index].setCity(newCity);
			System.out.println("Edited");
			break;
		case 4:
			System.out.println("Enter new State");
			String newState = s.next();
			contactBook[index].setState(newState);
			System.out.println("Edited");
			break;
		case 5:
			System.out.println("Enter new State");
			int newZip = s.nextInt();
			contactBook[index].setZipCode(newZip);
			System.out.println("Edited");
			break;
		case 6:
			System.out.println("Enter new Phone Number");
			int newPNumber = s.nextInt();
			contactBook[index].setPhoneNumber(newPNumber);
			System.out.println("Edited");
			break;
		case 7:
			System.out.println("Enter new Email");
			String newEmail = s.next();
			contactBook[index].setEmailId(newEmail);
			System.out.println("Edited");
			break;
		}
	}

	

}

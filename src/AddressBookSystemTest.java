import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookSystemTest {
	@Test
	public void givenAddressBookName_CheckIfAllContactsAreFetched() {
		AddressBookImpl addressBookImpl = new AddressBookImpl();
		List<Contact> contacts = addressBookImpl.readDb("address_book1");
		Assert.assertEquals(3, contacts.size());
	}

	@Test
	public void insertContactToGivenAddressBook_checkIfInserted() {
		AddressBookImpl addressBookImpl = new AddressBookImpl();
		Contact contact = new Contact(125, "qwerty", "hii", "mangalore", "hampankatta", "karnataks", 5457, 875454,
				"adada", 55);
		Contact updatedContact = addressBookImpl.writeAddressBookDB(contact, "address_book1");
		List<Contact> employeeList = addressBookImpl.readDb("address_book1");
		Boolean result = addressBookImpl.compareContactSync(updatedContact, "address_book1");
		Assert.assertTrue(result);
	}

	@Test
	public void givenDateRange_WhenCorrect_RetrieveAllContactsAdded() {
		AddressBookImpl addressBookImpl = new AddressBookImpl();
		LocalDate startDate = LocalDate.of(2020, 4, 19);
		LocalDate endDate = LocalDate.of(2020, 6, 19);
		List<Contact> contacts = addressBookImpl.readConatctsAddedInRange(Date.valueOf(startDate), Date.valueOf(endDate));
		System.out.println(contacts.size());
	}
}

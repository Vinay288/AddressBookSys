import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookSystemTest {
@Test
public void givenAddressBookName_CheckIfAllContactsAreFetched(){
	AddressBookImpl addressBookImpl=new AddressBookImpl();
	int AddressBookSize=addressBookImpl.readDb("address_book1");
	Assert.assertEquals(3,	AddressBookSize);
}

@Test
public void insertContactToGivenAddressBook_checkIfInserted() {
	AddressBookImpl addressBookImpl=new AddressBookImpl();
	int AddressBookSize=addressBookImpl.readDb("address_book3");
	Assert.assertEquals(2,	AddressBookSize);
	System.out.println(AddressBookSize);
	Contact contact= new Contact(123, "qwerty", "hii", "mangalore", "hampankatta", "karnataks",5457, 875454,"adada", 46);
	addressBookImpl.writeAddressBookDB(contact,"address_book1");
	int updatedSize=addressBookImpl.readDb("address_book3");
	System.out.println(updatedSize);
	Assert.assertEquals(AddressBookSize+1,updatedSize);
	
}
}

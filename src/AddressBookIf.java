import java.util.HashMap;

public interface AddressBookIf {

	public void addContact(HashMap<String, Contact> contactHashMap);
	public void showContacts(HashMap<String, Contact> contactHashMap);
	public void editContact(HashMap<String, Contact> contactHashMap);
	public void deleteContact(HashMap<String, Contact> contactHashMap);

}

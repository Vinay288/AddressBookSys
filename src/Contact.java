import java.util.HashMap;

import com.opencsv.bean.CsvBindByName;

public class Contact {
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@CsvBindByName
	private int contactId;
	@CsvBindByName
	private String firstName;
	@CsvBindByName
	private String lastName;
	@CsvBindByName
	private String address;
	@CsvBindByName
	private String city;
	@CsvBindByName
	private String state;
	@CsvBindByName
	private int zip;
	@CsvBindByName
	private int phoneNumber;
	@CsvBindByName
	private String email;
	Place place;
	Contact(String firstName, String lastName, String city, String address, String state, int zip, int phoneNumber,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		place=new Place(city, zip, state);
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	Contact(Integer contactId,String firstName, String lastName, String city, String address, String state, int zip, int phoneNumber,
			String email ,Integer placeId) {
		this.contactId=contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		place=new Place(placeId,city,zip,state);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return getPlace().getCity();
	}

	public void setState(String state) {
		this.getPlace().setState(state);
	}

	public String getState() {
		return getPlace().getState();
	}

	public void setCity(String city) {
		this.getPlace().setCity(city);
	}

	public int getZipCode() {
		return getPlace().getZip();
	}

	public void setZipCode(int zip) {
		this.getPlace().setZip(zip); 
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return email;
	}

	public void setEmailId(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object anotherObject) {
		HashMap<String, Contact> addressBook = (HashMap<String, Contact>) anotherObject;
		if (addressBook.keySet().stream().anyMatch(s -> (s.equals(firstName)))) {
			return true;
		}
		return false;

	}

	@Override
	public String toString() {
		return "First Name: " + getFirstName() + "\n" + "Last Name: " + getLastName() + "\n" + "city :" + getCity()
				+ "\n" + "Address: " + getAddress() + "\n" + "state: " + getState() + "\n" + "Phone Number: "
				+ getPhoneNumber() + "\n" + "Email: " + getEmailId();
	}

}

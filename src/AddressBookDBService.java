import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class AddressBookDBService {
	private static AddressBookDBService addressBookDBService;
	private java.sql.PreparedStatement readContactPreparedStatement;
	private AddressBookDBService() {
		
	}
	public static AddressBookDBService getDBInstance() {
		addressBookDBService = new AddressBookDBService();
		return addressBookDBService;
	}
	
public List<Contact> readContacts(String addressBookName){
	ResultSet resultSet;
	if(readContactPreparedStatement==null)
		this.preparedStatementToReadContacts();
	try {
		readContactPreparedStatement.setString(1, addressBookName);
		resultSet=readContactPreparedStatement.executeQuery();
	} catch (SQLException e) {
		throw new DBException(e.getMessage());
	}
	
	return getContactList(resultSet);
}
public List<Contact> getContactList(ResultSet resultSet){
	List<Contact> contactsList=new ArrayList<Contact>();
	try {
		while(resultSet.next()) {
			contactsList.add(new Contact(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("city"), resultSet.getString("address"), resultSet.getString("state"), resultSet.getInt("zip"),new Long(resultSet.getLong("phone_number")).intValue(), resultSet.getString("email")));
		}
	} catch (SQLException e) {
		throw new DBException(e.getMessage());
	}
	return contactsList;

}
public void writeAddressBookDB(Contact contact,String addressBookName) {
	String insertQueryString="INSERT INTO contact_details values("+contact.getContactId()+",\""+contact.getFirstName()+"\",\""+contact.getLastName()+"\",\""+contact.getAddress()+"\",\""+contact.getEmail()+"\","+contact.getPlace().getPlaceId()+",\""+contact.getPhoneNumber()+"\")";
	String insertPlaceQueryString="INSERT into place values("+contact.getPlace().getPlaceId()+",\""+contact.getCity()+"\",\""+contact.getZipCode()+"\",\""+contact.getState()+"\")";
	String insertIntermediateTableString="insert into addressbook_contact values((select address_book_id from address_book where address_book_name=\""+addressBookName+"\"),(select contact_id from contact_details where first_name=\""+contact.getFirstName()+"\"))";
	try {
		Connection connection=this.getConnection();
		System.out.println("connected");
		Statement statement=connection.createStatement();
		statement.executeUpdate(insertPlaceQueryString);
		statement.executeUpdate(insertQueryString);
		statement.executeUpdate(insertIntermediateTableString);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}

private Connection getConnection() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("driver loaded ");
	String jdbcURL="jdbc:mysql://localhost:3306/Address_Book_DB";
	String userName="root";
	String password="1234";
	Connection connection=DriverManager.getConnection(jdbcURL,userName,password);
	return connection;
}
private void preparedStatementToReadContacts() {
    try {
        Connection connection = this.getConnection();
    	String sql="SELECT first_name,last_name,city,address,state,zip,phone_number,email from address_book a,contact_details c,addressbook_contact ac,place p  where p.place_id=c.place_id and a.address_book_id=ac.address_book_id and c.contact_id=ac.contact_id and address_book_name=?";
       readContactPreparedStatement=connection.prepareStatement(sql);
    } catch (Exception e) {
        throw new DBException(e.getMessage());
    }
}

}

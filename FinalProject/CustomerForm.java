package FinalProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerForm extends JFrame {

	private JPanel contentPane;
    private JTextField txtFirstName;
    private JTextField txtMiddleInitial;
    private JTextField txtLastName;
    private JDateChooser dateChooserBirthday;
    private JTextField txtBirthplace;
    private JTextField txtNationality;
    private JTextField txtOccupation;
    private JTextField txtBlockNumber;
    private JTextField txtLotNumber;
    private JTextField txtStreet;
    private JTextField txtBarangay;
    private JTextField txtCity;
    private JButton btnSave;
    private JButton btnClear;
    private int customerId = -1; 
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerForm frame = new CustomerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//For Updating
	public CustomerForm(int customerId, String firstName, String middleInitial, String lastName, java.util.Date birthday, String birthplace, String nationality, String occupation, String blockNumber, String lotNumber, String street, String barangay, String city) {
	    this(); 
	    this.customerId = customerId; 
	    
	    
	    txtFirstName.setText(firstName);
	    txtMiddleInitial.setText(middleInitial);
	    txtLastName.setText(lastName);
	    dateChooserBirthday.setDate(birthday); 
	    txtBirthplace.setText(birthplace);
	    txtNationality.setText(nationality);
	    txtOccupation.setText(occupation);
	    txtBlockNumber.setText(blockNumber);
	    txtLotNumber.setText(lotNumber);
	    txtStreet.setText(street);
	    txtBarangay.setText(barangay);
	    txtCity.setText(city);
	    
	  
	}

	

	/**
	 * Create the frame.
	 */
	public CustomerForm() {
		setResizable(false);
        setTitle("Customer Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 729);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Name category
        JLabel label = new JLabel("Name");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setBounds(192, 10, 36, 17);
        contentPane.add(label);
        txtFirstName = new JTextField();
        txtFirstName.setBounds(5, 30, 426, 50);
        txtFirstName.setBorder(BorderFactory.createTitledBorder("First Name"));
        contentPane.add(txtFirstName);

        txtMiddleInitial = new JTextField();
        txtMiddleInitial.setBounds(5, 78, 426, 50);
        txtMiddleInitial.setBorder(BorderFactory.createTitledBorder("Middle Initial"));
        contentPane.add(txtMiddleInitial);

        txtLastName = new JTextField();
        txtLastName.setBounds(5, 128, 426, 50);
        txtLastName.setBorder(BorderFactory.createTitledBorder("Last Name"));
        contentPane.add(txtLastName);

        dateChooserBirthday = new JDateChooser();
        dateChooserBirthday.setBounds(5, 179, 426, 56);
        dateChooserBirthday.setBorder(BorderFactory.createTitledBorder("Birthday"));
        contentPane.add(dateChooserBirthday);

        txtBirthplace = new JTextField();
        txtBirthplace.setBounds(5, 234, 426, 50);
        txtBirthplace.setBorder(BorderFactory.createTitledBorder("Birthplace (city only)"));
        contentPane.add(txtBirthplace);

        txtNationality = new JTextField();
        txtNationality.setBounds(5, 284, 426, 50);
        txtNationality.setBorder(BorderFactory.createTitledBorder("Nationality"));
        contentPane.add(txtNationality);

        txtOccupation = new JTextField();
        txtOccupation.setBounds(5, 334, 426, 50);
        txtOccupation.setBorder(BorderFactory.createTitledBorder("Occupation"));
        contentPane.add(txtOccupation);

        // Address category
        JLabel label_1 = new JLabel("Address");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_1.setBounds(185, 384, 50, 17);
        contentPane.add(label_1);
        txtBlockNumber = new JTextField();
        txtBlockNumber.setBounds(5, 401, 426, 50);
        txtBlockNumber.setBorder(BorderFactory.createTitledBorder("Block Number"));
        contentPane.add(txtBlockNumber);

        txtLotNumber = new JTextField();
        txtLotNumber.setBounds(5, 447, 426, 50);
        txtLotNumber.setBorder(BorderFactory.createTitledBorder("Lot Number"));
        contentPane.add(txtLotNumber);

        txtStreet = new JTextField();
        txtStreet.setBounds(5, 497, 426, 50);
        txtStreet.setBorder(BorderFactory.createTitledBorder("Street"));
        contentPane.add(txtStreet);

        txtBarangay = new JTextField();
        txtBarangay.setBounds(5, 548, 426, 50);
        txtBarangay.setBorder(BorderFactory.createTitledBorder("Barangay"));
        contentPane.add(txtBarangay);

        txtCity = new JTextField();
        txtCity.setBounds(5, 597, 426, 50);
        txtCity.setBorder(BorderFactory.createTitledBorder("City"));
        contentPane.add(txtCity);

        //Save button
        btnSave = new JButton("Save");
        btnSave.setBounds(136, 651, 69, 31);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveCustomer();
            }
        });
        contentPane.add(btnSave);
        
        btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clearInput();
        	}
        });
        btnClear.setBounds(225, 651, 69, 31);
        contentPane.add(btnClear);
    }
	
	//Save Method
	private void saveCustomer() {
		
		//Getting the input
		String firstName = txtFirstName.getText();
	    String middleInitial = txtMiddleInitial.getText();
	    String lastName = txtLastName.getText();
	    java.util.Date birthday = dateChooserBirthday.getDate();
	    String birthplace = txtBirthplace.getText();
	    String nationality = txtNationality.getText();
	    String occupation = txtOccupation.getText();
	    String blockNumber = txtBlockNumber.getText();
	    String lotNumber = txtLotNumber.getText();
	    String streetName = txtStreet.getText();
	    String barangayName = txtBarangay.getText();
	    String cityName = txtCity.getText();
        
		Connection connection = null;
		
		
		try {
	        //Establish the connection to the database
	        String url = "jdbc:mysql://localhost:3306/db_goldvision";
	        connection = DriverManager.getConnection(url, "root", "");
	        connection.setAutoCommit(false);

	        if (!validateInput()) {
	            return;
	        }

	        //Inserting or updating city, barangay, street, and address in order
	        int cityId = insertCity(connection, cityName);
	        int barangayId = insertBarangay(connection, barangayName, cityId);
	        int streetId = insertStreet(connection, streetName, barangayId);
	        int addressId = insertAddress(connection, blockNumber, lotNumber, streetId);

	        if (customerId == -1) {
	            //Inserting into the customer table with the addressId
	            insertCustomer(connection, lastName, firstName, middleInitial, birthday, birthplace, nationality, occupation, addressId);
	        } else {
	            //Updating the customer information
	            updateCustomer(connection, customerId, lastName, firstName, middleInitial, birthday, birthplace, nationality, occupation, addressId);
	        }

	        //Commit the transaction
	        connection.commit();
	        JOptionPane.showMessageDialog(this, "Customer information saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	        Customer.refreshTableStatic();
	        clearInput();
	        
	    } catch (Exception e) {
	        if (connection != null) {
	            try {
	                connection.rollback();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error adding customer. \n" + e, "Error", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	}
	
	//Insert methods
	private int insertCity(Connection connection, String cityName) throws SQLException {
	    String selectQuery = "SELECT City_ID FROM tbl_city WHERE City_Name = ?";
	    try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
	        selectStmt.setString(1, cityName);
	        ResultSet rs = selectStmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("City_ID");
	        }
	    }

	    String insertQuery = "INSERT INTO tbl_city (City_Name) VALUES (?)";
	    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
	        insertStmt.setString(1, cityName);
	        insertStmt.executeUpdate();
	        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("Creating city failed, no ID obtained.");
	            }
	        }
	    }
	}
	
	private int insertBarangay(Connection connection, String barangayName, int cityId) throws SQLException {
	    String selectQuery = "SELECT Barangay_ID FROM tbl_barangay WHERE Barangay_Name = ? AND City_ID = ?";
	    try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
	        selectStmt.setString(1, barangayName);
	        selectStmt.setInt(2, cityId);
	        ResultSet rs = selectStmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("Barangay_ID");
	        }
	    }

	    String insertQuery = "INSERT INTO tbl_barangay (Barangay_Name, City_ID) VALUES (?, ?)";
	    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
	        insertStmt.setString(1, barangayName);
	        insertStmt.setInt(2, cityId);
	        insertStmt.executeUpdate();
	        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("Creating barangay failed, no ID obtained.");
	            }
	        }
	    }
	}
	
	private int insertStreet(Connection connection, String streetName, int barangayId) throws SQLException {
	    String selectQuery = "SELECT Street_ID FROM tbl_street WHERE Street_Name = ? AND Barangay_ID = ?";
	    try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
	        selectStmt.setString(1, streetName);
	        selectStmt.setInt(2, barangayId);
	        ResultSet rs = selectStmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("Street_ID");
	        }
	    }

	    String insertQuery = "INSERT INTO tbl_street (Street_Name, Barangay_ID) VALUES (?, ?)";
	    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
	        insertStmt.setString(1, streetName);
	        insertStmt.setInt(2, barangayId);
	        insertStmt.executeUpdate();
	        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("Creating street failed, no ID obtained.");
	            }
	        }
	    }
	}
	

	private int insertAddress(Connection connection, String blockNumber, String lotNumber, int streetId) throws SQLException {
	    
	    String selectQuery = "SELECT Address_ID FROM tbl_address WHERE Block = ? AND Lot = ? AND Street_ID = ?";
	    try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
	        selectStmt.setString(1, blockNumber);
	        selectStmt.setString(2, lotNumber);
	        selectStmt.setInt(3, streetId);
	        ResultSet rs = selectStmt.executeQuery();
	        if (rs.next()) {
	        
	            return rs.getInt("Address_ID");
	        }
	    }

	    
	    String insertQuery = "INSERT INTO tbl_address (Block, Lot, Street_ID) VALUES (?, ?, ?)";
	    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
	        insertStmt.setString(1, blockNumber);
	        insertStmt.setString(2, lotNumber);
	        insertStmt.setInt(3, streetId);
	        insertStmt.executeUpdate();
	        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                
	                return generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("Creating address failed, no ID obtained.");
	            }
	        }
	    }
	}
	
	private void insertCustomer(Connection connection, String lastName, String firstName, String middleInitial, java.util.Date birthday, String birthplace, String nationality, String occupation, int addressId) throws SQLException {
	    String query = "INSERT INTO tbl_customer (Customer_LastName, Customer_FirstName, Customer_MidInt, Customer_Birthday, Customer_Birthplace, Customer_Nationality, Customer_Occupation, Address_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setString(1, lastName);
	        preparedStatement.setString(2, firstName);
	        preparedStatement.setString(3, middleInitial);
	        preparedStatement.setDate(4, new java.sql.Date(birthday.getTime())); 
	        preparedStatement.setString(5, birthplace);
	        preparedStatement.setString(6, nationality);
	        preparedStatement.setString(7, occupation);
	        preparedStatement.setInt(8, addressId);
	        preparedStatement.executeUpdate();
	    }
	}


	//Clear Method
	private void clearInput() {
		 txtFirstName.setText("");
		 txtMiddleInitial.setText("");
		 txtLastName.setText("");
		 dateChooserBirthday.setDate(null); // Clear the date chooser
		 txtBirthplace.setText("");
		 txtNationality.setText("");
		 txtOccupation.setText("");
		 txtBlockNumber.setText("");
		 txtLotNumber.setText("");
		 txtStreet.setText("");
		 txtBarangay.setText("");
		 txtCity.setText("");
	}
	
	//Error checking for empty input
	private boolean validateInput() {
		if (txtFirstName.getText().trim().isEmpty() ||
		        txtLastName.getText().trim().isEmpty() ||
		        txtMiddleInitial.getText().trim().isEmpty() ||
		        dateChooserBirthday.getDate() == null ||
		        txtBirthplace.getText().trim().isEmpty() ||
		        txtNationality.getText().trim().isEmpty() ||
		        txtOccupation.getText().trim().isEmpty() ||
		        txtStreet.getText().trim().isEmpty() ||
		        txtCity.getText().trim().isEmpty()) {
			
			JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
	        return false;
		}
		return true;
	}
	
	//Update
	private void updateCustomer(Connection connection, int customerId, String lastName, String firstName, String middleInitial, java.util.Date birthday, String birthplace, String nationality, String occupation, int addressId) throws SQLException {
	    String updateQuery = "UPDATE tbl_customer SET Customer_LastName=?, Customer_FirstName=?, Customer_MidInt=?, Customer_Birthday=?, Customer_Birthplace=?, Customer_Nationality=?, Customer_Occupation=?, Address_ID=? WHERE Customer_ID=?";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	        preparedStatement.setString(1, lastName);
	        preparedStatement.setString(2, firstName);
	        preparedStatement.setString(3, middleInitial);
	        preparedStatement.setDate(4, new java.sql.Date(birthday.getTime()));
	        preparedStatement.setString(5, birthplace);
	        preparedStatement.setString(6, nationality);
	        preparedStatement.setString(7, occupation);
	        preparedStatement.setInt(8, addressId);
	        preparedStatement.setInt(9, customerId);
	        preparedStatement.executeUpdate();
	    }
	}
	
}

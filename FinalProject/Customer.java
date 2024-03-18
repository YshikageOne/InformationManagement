package FinalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer extends JFrame {

	private JPanel contentPane;
    private JTable table;
    private JLabel lblSearch;
    private JTextField txtSearch;
    private JButton btnUpdate;
    private JButton btnAdd;
    private static Customer instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Customer() {
		instance = this;
		
		setTitle("Customer");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1062, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		//Column names
		String[] columnNames = {
            "ID", "LastName", "FirstName", "MidInt", "AddressID", 
            "Birthday", "Birthplace", "Nationality", "Occupation"
        };

		//Create a model for the table with the column names and zero rows
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        //Initialize the table with the model
        table = new JTable(model);

        //Set the table properties as needed, for example, to make it scrollable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 1028, 300); // Set bounds as needed
        contentPane.add(scrollPane);
        
        lblSearch = new JLabel("Search :");
        lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblSearch.setBounds(678, 333, 89, 29);
        contentPane.add(lblSearch);
        
        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
        txtSearch.setBounds(777, 332, 261, 30);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);
        
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int customerId = (Integer) model.getValueAt(selectedRow, 0);
                    int addressId = (Integer) model.getValueAt(selectedRow, 4); 
                    
                    AddressDetails addressDetails = getAddressDetails(addressId);
                    
                    CustomerForm customerForm = new CustomerForm(customerId, 
                                                                  model.getValueAt(selectedRow, 2).toString(), // FirstName
                                                                  model.getValueAt(selectedRow, 3).toString(), // MiddleInitial
                                                                  model.getValueAt(selectedRow, 1).toString(), // LastName
                                                                  (java.util.Date)model.getValueAt(selectedRow, 5), // Birthday
                                                                  model.getValueAt(selectedRow, 6).toString(), // Birthplace
                                                                  model.getValueAt(selectedRow, 7).toString(), // Nationality
                                                                  model.getValueAt(selectedRow, 8).toString(), // Occupation
                                                                  addressDetails.getBlockNumber(),
                                                                  addressDetails.getLotNumber(),
                                                                  addressDetails.getStreet(),
                                                                  addressDetails.getBarangay(),
                                                                  addressDetails.getCity());
                    customerForm.setVisible(true);
                }
            }
        });
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnUpdate.setBounds(27, 333, 110, 29);
        contentPane.add(btnUpdate);
        
        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CustomerForm customerForm = new CustomerForm();
        		customerForm.setVisible(true);
        	}
        });
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdd.setBounds(156, 333, 110, 29);
        contentPane.add(btnAdd);
        
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                searchDatabase(txtSearch.getText().trim());
            }

            public void removeUpdate(DocumentEvent e) {
                searchDatabase(txtSearch.getText().trim());
            }

            public void changedUpdate(DocumentEvent e) {
           
            }
        });
        
        
        
        loadDataFromDatabase();
	}

	//MySQL
	private void loadDataFromDatabase(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			//Loading the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish the connection to the database
			String url = "jdbc:mysql://localhost:3306/db_goldvision";
			connection = DriverManager.getConnection(url, "root", "");
			
			//Create a statement
			statement = connection.createStatement();
			
			//Execute a query
			String query = "Select * from tbl_customer";
			resultSet = statement.executeQuery(query);
			
			//Extracting data from result
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			while (resultSet.next()) {
				tableModel.addRow(new Object[] {
						resultSet.getInt("Customer_ID"),
						resultSet.getString("Customer_LastName"),
						resultSet.getString("Customer_FirstName"),
						resultSet.getString("Customer_MidInt"),
						resultSet.getInt("Address_ID"),
						resultSet.getDate("Customer_Birthday"),
						resultSet.getString("Customer_Birthplace"),
						resultSet.getString("Customer_Nationality"),
						resultSet.getString("Customer_Occupation")
				});
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Cleanup
			try {
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Other methods
	private void searchDatabase(String searchText) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			//Loading the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish the connection to the database
	        String url = "jdbc:mysql://localhost:3306/db_goldvision";
	        connection = DriverManager.getConnection(url, "root", "");
	        
	        //Create a statement
	        statement = connection.createStatement();
	        
	        //Execute a query with search text
	        String query = "SELECT * FROM tbl_customer WHERE " +
	                       "Customer_LastName LIKE '%" + searchText + "%' OR " +
	                       "Customer_FirstName LIKE '%" + searchText + "%'";
	        resultSet = statement.executeQuery(query);
	        
	        //Extracting data from result
	        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	        tableModel.setRowCount(0); //Clear existing data
	        
	        while (resultSet.next()) {
	            tableModel.addRow(new Object[] {
	                    resultSet.getInt("Customer_ID"),
	                    resultSet.getString("Customer_LastName"),
	                    resultSet.getString("Customer_FirstName"),
	                    resultSet.getString("Customer_MidInt"),
	                    resultSet.getInt("Address_ID"),
	                    resultSet.getDate("Customer_Birthday"),
	                    resultSet.getString("Customer_Birthplace"),
	                    resultSet.getString("Customer_Nationality"),
	                    resultSet.getString("Customer_Occupation")
	            });
	        }
	        
		}catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        //Cleanup
	        try {
	            if(resultSet != null) resultSet.close();
	            if(statement != null) statement.close();
	            if(connection != null) connection.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		loadDataFromDatabase();
	}
	
	public static void refreshTableStatic() {
        if (instance != null) {
            instance.refreshTable();
        }
    }
	
	private AddressDetails getAddressDetails(int addressId) {
	    AddressDetails details = new AddressDetails();
	    
	    //Database connection setup
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	         PreparedStatement preparedStatement = connection.prepareStatement(
	                 "SELECT a.Block, a.Lot, s.Street_Name, b.Barangay_Name, c.City_Name " +
	                 "FROM tbl_address a " +
	                 "JOIN tbl_street s ON a.Street_ID = s.Street_ID " +
	                 "JOIN tbl_barangay b ON s.Barangay_ID = b.Barangay_ID " +
	                 "JOIN tbl_city c ON b.City_ID = c.City_ID " +
	                 "WHERE a.Address_ID = ?")) {
	        preparedStatement.setInt(1, addressId);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            details.setBlockNumber(resultSet.getString("Block"));
	            details.setLotNumber(resultSet.getString("Lot"));
	            details.setStreet(resultSet.getString("Street_Name"));
	            details.setBarangay(resultSet.getString("Barangay_Name"));
	            details.setCity(resultSet.getString("City_Name"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return details;
	}
}

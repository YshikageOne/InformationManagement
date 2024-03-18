package FinalProject;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import com.toedter.calendar.JTextFieldDateEditor;

public class Pawnticket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Pawnticket_ID;
	private JDateChooser DateTrans;
	private JLabel lblNewLoan;
	private JLabel lblDateMaturity;
	private JDateChooser DateMaturity;
	private JLabel lblDateExpiry;
	private JDateChooser DateExpiry;
	private JTextField CustomerID;
	private JLabel lblCategory;
	private JLabel lblQuantity;
	private JTextField textField_5;
	private JLabel lblItemID;
	private JTextField textField_6;
	private JPanel panel_1;
	private JLabel lblCondition;
	private JTextField textField_10;
	private JLabel lblDescription;
	private JTextField Description;
	private JLabel lblInterest;
	private JTextField Interest;
	private JLabel lblItemValue;
	private JTextField ItemValue;
	private JTextField NetValue;
	private JLabel lblNetValue;
	private JTextField Principal;
	private JLabel lblPrincipal;
	private JLabel lblNetProceed;
	private JTextField NetProceed;
	private JTextField txtPawnTicketItemID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pawnticket frame = new Pawnticket();
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
	public Pawnticket() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1195, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPawnticketItem_ID = new JLabel("Pawnticket Item ID# :");
		lblPawnticketItem_ID.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblPawnticketItem_ID.setBounds(28, 128, 284, 35);
		lblPawnticketItem_ID.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblPawnticketItem_ID);
		
		Pawnticket_ID = new JTextField();
		Pawnticket_ID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Pawnticket_ID.setBounds(266, 76, 349, 39);
		contentPane.add(Pawnticket_ID);
		Pawnticket_ID.setColumns(10);
		
		JLabel lblDateTrans = new JLabel("Date Transaction:");
		lblDateTrans.setVerticalAlignment(SwingConstants.TOP);
		lblDateTrans.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblDateTrans.setBounds(28, 178, 240, 40);
		contentPane.add(lblDateTrans);
		
		DateTrans = new JDateChooser();
	    DateTrans.setBounds(266, 179, 349, 39);
	    ((JTextFieldDateEditor)DateTrans.getDateEditor()).setFont(new Font("Tahoma", Font.PLAIN, 18));
	    contentPane.add(DateTrans);
	    DateTrans.setDate(new Date());
		
		lblNewLoan = new JLabel("New Loan");
		lblNewLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLoan.setVerticalAlignment(SwingConstants.TOP);
		lblNewLoan.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLoan.setBounds(475, 11, 240, 40);
		contentPane.add(lblNewLoan);
		
		lblDateMaturity = new JLabel("Date Maturity:");
		lblDateMaturity.setVerticalAlignment(SwingConstants.TOP);
		lblDateMaturity.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblDateMaturity.setBounds(694, 76, 240, 40);
		contentPane.add(lblDateMaturity);
		
		DateMaturity = new JDateChooser();
        DateMaturity.setBounds(928, 76, 227, 39);
        ((JTextFieldDateEditor)DateMaturity.getDateEditor()).setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(DateMaturity);
        Calendar calMaturity = Calendar.getInstance();
        calMaturity.add(Calendar.MONTH, 1);
        DateMaturity.setDate(calMaturity.getTime());
		
		lblDateExpiry = new JLabel("Date Expiry:");
		lblDateExpiry.setVerticalAlignment(SwingConstants.TOP);
		lblDateExpiry.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblDateExpiry.setBounds(694, 127, 240, 40);
		contentPane.add(lblDateExpiry);
		
		DateExpiry = new JDateChooser();
        DateExpiry.setBounds(928, 127, 227, 39);
        ((JTextFieldDateEditor)DateExpiry.getDateEditor()).setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(DateExpiry);
        Calendar calExpiry = Calendar.getInstance();
        calExpiry.add(Calendar.MONTH, 6);
        DateExpiry.setDate(calExpiry.getTime());
		
		JLabel lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setVerticalAlignment(SwingConstants.TOP);
		lblCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblCustomerID.setBounds(694, 178, 240, 40);
		contentPane.add(lblCustomerID);
		
		CustomerID = new JTextField();
		CustomerID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CustomerID.setColumns(10);
		CustomerID.setBounds(981, 181, 174, 39);
		contentPane.add(CustomerID);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(28, 243, 779, 486);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 174, 424, 181);
		panel.add(panel_1);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(null);
		
		JComboBox Category = new JComboBox();
		Category.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Category.setBounds(155, 124, 223, 40);
		panel.add(Category);
		
		Category.addItem("Select Category");
		Category.addItem("Jewelry");
		Category.addItem("Appliance");
		
		
		// Initialize additional fields for Jewelry and Appliance
		JLabel lblType = new JLabel("Type:");
		JTextField txtType = new JTextField();
		JLabel lblWeight = new JLabel("Weight in (grams g):");
		JTextField txtWeight = new JTextField();
		JLabel lblPurity = new JLabel("Purity:");
		JTextField txtPurity = new JTextField();

		JLabel lblBrand = new JLabel("Brand:");
		JTextField txtBrand = new JTextField();
		JLabel lblModel = new JLabel("Model:");
		JTextField txtModel = new JTextField();
		JLabel lblSerialNumber = new JLabel("Serial Number:");
		JTextField txtSerialNumber = new JTextField();
		
		//Initially add these components to panel_1 but set them invisible
		panel_1.setLayout(null); //Set layout manager to null for absolute positioning
		panel_1.add(lblType);
		panel_1.add(txtType);
		panel_1.add(lblWeight);
		panel_1.add(txtWeight);
		panel_1.add(lblPurity);
		panel_1.add(txtPurity);
		panel_1.add(lblBrand);
		panel_1.add(txtBrand);
		panel_1.add(lblModel);
		panel_1.add(txtModel);
		panel_1.add(lblSerialNumber);
		panel_1.add(txtSerialNumber);

		//Set all components to invisible initially
		lblType.setVisible(false);
		txtType.setVisible(false);
		lblWeight.setVisible(false);
		txtWeight.setVisible(false);
		lblPurity.setVisible(false);
		txtPurity.setVisible(false);
		lblBrand.setVisible(false);
		txtBrand.setVisible(false);
		lblModel.setVisible(false);
		txtModel.setVisible(false);
		
		//Add action listener to Category JComboBox
		Category.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Hide all components initially
		        lblType.setVisible(false);
		        txtType.setVisible(false);
		        lblWeight.setVisible(false);
		        txtWeight.setVisible(false);
		        lblPurity.setVisible(false);
		        txtPurity.setVisible(false);
		        lblBrand.setVisible(false);
		        txtBrand.setVisible(false);
		        lblModel.setVisible(false);
		        txtModel.setVisible(false);
		        lblSerialNumber.setVisible(false);
		        txtSerialNumber.setVisible(false);

		        String selectedCategory = (String) Category.getSelectedItem();
		        if ("Jewelry".equals(selectedCategory)) {
		            //Position and show components for Jewelry
		            lblType.setBounds(10, 20, 140, 30);
		            txtType.setBounds(160, 20, 220, 30);
		            lblWeight.setBounds(10, 60, 140, 30);
		            txtWeight.setBounds(160, 60, 220, 30);
		            lblPurity.setBounds(10, 100, 140, 30);
		            txtPurity.setBounds(160, 100, 220, 30);

		            lblType.setVisible(true);
		            txtType.setVisible(true);
		            lblWeight.setVisible(true);
		            txtWeight.setVisible(true);
		            lblPurity.setVisible(true);
		            txtPurity.setVisible(true);
		        } else if ("Appliance".equals(selectedCategory)) {
		            //Position and show components for Appliance
		            lblBrand.setBounds(10, 20, 140, 30);
		            txtBrand.setBounds(160, 20, 220, 30);
		            lblModel.setBounds(10, 60, 140, 30);
		            txtModel.setBounds(160, 60, 220, 30);
		            lblSerialNumber.setBounds(10, 100, 140, 30);
		            txtSerialNumber.setBounds(160, 100, 220, 30);

		            lblBrand.setVisible(true);
		            txtBrand.setVisible(true);
		            lblModel.setVisible(true);
		            txtModel.setVisible(true);
		            lblSerialNumber.setVisible(true);
		            txtSerialNumber.setVisible(true);
		        }

		        //Refresh panel_1 to show the new components
		        panel_1.revalidate();
		        panel_1.repaint();
		    }
		});
		
		lblCategory = new JLabel("Category:");
		lblCategory.setVerticalAlignment(SwingConstants.TOP);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblCategory.setBounds(10, 124, 134, 40);
		panel.add(lblCategory);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setVerticalAlignment(SwingConstants.TOP);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblQuantity.setBounds(10, 73, 134, 40);
		panel.add(lblQuantity);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(154, 73, 107, 39);
		panel.add(textField_5);
		
		lblItemID = new JLabel("Item ID :");
		lblItemID.setVerticalAlignment(SwingConstants.TOP);
		lblItemID.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblItemID.setBounds(10, 22, 124, 40);
		panel.add(lblItemID);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(155, 22, 93, 39);
		panel.add(textField_6);
		
		lblCondition = new JLabel("Condition :");
		lblCondition.setVerticalAlignment(SwingConstants.TOP);
		lblCondition.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblCondition.setBounds(412, 22, 164, 40);
		panel.add(lblCondition);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_10.setColumns(10);
		textField_10.setBounds(570, 22, 171, 39);
		panel.add(textField_10);
		
		lblDescription = new JLabel("Description :");
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblDescription.setBounds(444, 124, 164, 40);
		panel.add(lblDescription);
		
		Description = new JTextField();
		Description.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Description.setColumns(10);
		Description.setBounds(444, 185, 299, 181);
		panel.add(Description);
		
		lblInterest = new JLabel("Interest :");
		lblInterest.setVerticalAlignment(SwingConstants.TOP);
		lblInterest.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblInterest.setBounds(20, 377, 124, 40);
		panel.add(lblInterest);
		
		Interest = new JTextField();
		Interest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Interest.setColumns(10);
		Interest.setBounds(165, 377, 93, 39);
		panel.add(Interest);
		
		lblItemValue = new JLabel("Item Value :");
		lblItemValue.setVerticalAlignment(SwingConstants.TOP);
		lblItemValue.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblItemValue.setBounds(21, 435, 172, 40);
		panel.add(lblItemValue);
		
		ItemValue = new JTextField();
		ItemValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemValue.setColumns(10);
		ItemValue.setBounds(197, 435, 124, 39);
		panel.add(ItemValue);
		
		NetValue = new JTextField();
		NetValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NetValue.setColumns(10);
		NetValue.setBounds(534, 435, 124, 39);
		panel.add(NetValue);
		
		lblNetValue = new JLabel("Net Value :");
		lblNetValue.setVerticalAlignment(SwingConstants.TOP);
		lblNetValue.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNetValue.setBounds(374, 435, 172, 40);
		panel.add(lblNetValue);
		
		Principal = new JTextField();
		Principal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Principal.setColumns(10);
		Principal.setBounds(984, 597, 171, 39);
		contentPane.add(Principal);
		
		lblPrincipal = new JLabel("Principal :");
		lblPrincipal.setVerticalAlignment(SwingConstants.TOP);
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblPrincipal.setBounds(826, 597, 164, 40);
		contentPane.add(lblPrincipal);
		
		lblNetProceed = new JLabel("Net Proceed:");
		lblNetProceed.setVerticalAlignment(SwingConstants.TOP);
		lblNetProceed.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNetProceed.setBounds(826, 660, 174, 40);
		contentPane.add(lblNetProceed);
		
		NetProceed = new JTextField();
		NetProceed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NetProceed.setColumns(10);
		NetProceed.setBounds(1000, 660, 171, 39);
		contentPane.add(NetProceed);
		
		JButton btnAdd = new JButton("Add Pawnticket");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int customerId = Integer.parseInt(CustomerID.getText());
		            double principalValue = Double.parseDouble(Principal.getText());
		            Date maturityDate = DateMaturity.getDate();
		            Date expiryDate = DateExpiry.getDate();
		            
		            if (!doesCustomerExist(customerId)) {
		                JOptionPane.showMessageDialog(null, "Customer ID does not exist.");
		                return;
		            }
		            
		            addPawnticket(customerId, principalValue, maturityDate, expiryDate);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter valid numbers for Customer ID and Principal Value.");
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error adding pawnticket: " + ex.getMessage());
		        }
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(826, 243, 174, 47);
		contentPane.add(btnAdd);
		
		JButton btnAddPawnticketItem = new JButton("Add Pawnticket Item");
		btnAddPawnticketItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int itemId = Integer.parseInt(textField_6.getText()); 
		            int pawnticketId = Integer.parseInt(Pawnticket_ID.getText());
		            int pawnticketItemId = Integer.parseInt(txtPawnTicketItemID.getText());
		            int quantity = Integer.parseInt(textField_5.getText()); 
		            double itemValue = Double.parseDouble(ItemValue.getText());
		            String conditionDescription = textField_10.getText(); 
		            int conditionId = getConditionId(conditionDescription);
		            String description = Description.getText();
		            double interest = Double.parseDouble(Interest.getText());
		            double netValue = Double.parseDouble(NetValue.getText());
		            
		            boolean itemAddedSuccessfully = false;
		            
		            String selectedCategory = (String) Category.getSelectedItem();
		            if ("Jewelry".equals(selectedCategory)) {
		                // Get jewelry attributes
		                String type = txtType.getText();
		                int weight = Integer.parseInt(txtWeight.getText());
		                String purity = txtPurity.getText();
		                
		                itemAddedSuccessfully = addJewelryItem(pawnticketItemId, type, weight, purity);
		                
		            } else if ("Appliance".equals(selectedCategory)) {
		                String brand = txtBrand.getText();
		                String model = txtModel.getText();
		                String serialNumber = txtSerialNumber.getText();
		                
		                itemAddedSuccessfully = addApplianceItem(pawnticketItemId, brand, model, serialNumber);
		            }
		            
		            if (itemAddedSuccessfully) {
		                addPawnticketItem(itemId, pawnticketItemId, pawnticketId, quantity, itemValue, conditionId, description, interest, netValue);
		            } else {
		                JOptionPane.showMessageDialog(null, "Error adding item. Please check the details and try again.");
		            }
		            
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter valid numbers for Item ID, Quantity, Item Value, Interest, and Net Value.");
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error adding pawnticket item: " + ex.getMessage());
		        }
		    }
		});
		btnAddPawnticketItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddPawnticketItem.setBounds(826, 316, 227, 58);
		contentPane.add(btnAddPawnticketItem);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(826, 517, 174, 47);
		contentPane.add(btnClear);
		
		JLabel lblPawnticket_ID_1 = new JLabel("Pawnticket ID# :");
		lblPawnticket_ID_1.setVerticalAlignment(SwingConstants.TOP);
		lblPawnticket_ID_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblPawnticket_ID_1.setBounds(28, 73, 240, 40);
		contentPane.add(lblPawnticket_ID_1);
		
		txtPawnTicketItemID = new JTextField();
		txtPawnTicketItemID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPawnTicketItemID.setColumns(10);
		txtPawnTicketItemID.setBounds(322, 128, 284, 39);
		contentPane.add(txtPawnTicketItemID);


		fetchNextPawnticketID();
		fetchNextItemId();
	}
	
	private void fetchNextPawnticketID() {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        String query = "SELECT MAX(Pawnticket_ID) AS maxID FROM tbl_pawnticket";
	        
	        preparedStatement = connection.prepareStatement(query);
	        resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int nextID = resultSet.getInt("maxID") + 1;
	            Pawnticket_ID.setText(String.valueOf(nextID));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private void fetchNextItemId() {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	    	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        String query = "SELECT MAX(Item_ID) AS maxID FROM tbl_pawnticketitem";
	        
	        preparedStatement = connection.prepareStatement(query);
	        resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int nextID = resultSet.getInt("maxID") + 1;
	            textField_6.setText(String.valueOf(nextID)); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private boolean doesCustomerExist(int customerID) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        String query = "SELECT COUNT(*) AS count FROM tbl_customer WHERE Customer_ID = ?";
	        
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, customerID);
	        resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getInt("count") > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}
	
	private void addPawnticket(int customerId, double principalValue, Date maturityDate, Date expiryDate) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        String query = "INSERT INTO tbl_pawnticket (Customer_ID, Principal_Value, Maturity_Date, Expiry_Date) VALUES (?, ?, ?, ?)";
	        
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, customerId);
	        preparedStatement.setDouble(2, principalValue);
	        preparedStatement.setDate(3, new java.sql.Date(maturityDate.getTime()));
	        preparedStatement.setDate(4, new java.sql.Date(expiryDate.getTime()));
	        
	        preparedStatement.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Pawnticket added successfully.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error adding pawnticket: " + e.getMessage());
	    } finally {
	        try {
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private int getConditionId(String conditionType) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int conditionId = -1;
	    
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        // Check if the condition exists
	        String queryCheck = "SELECT Condition_ID FROM tbl_condition WHERE condition_type = ?";
	        preparedStatement = connection.prepareStatement(queryCheck);
	        preparedStatement.setString(1, conditionType);
	        resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            conditionId = resultSet.getInt("Condition_ID");
	        } else {
	            // Condition does not exist, insert new condition
	            String queryInsert = "INSERT INTO tbl_condition (condition_type) VALUES (?)";
	            preparedStatement = connection.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
	            preparedStatement.setString(1, conditionType);
	            preparedStatement.executeUpdate();
	            resultSet = preparedStatement.getGeneratedKeys();
	            if (resultSet.next()) {
	                conditionId = resultSet.getInt(1); // Retrieve the generated condition ID
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error processing condition: " + e.getMessage());
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return conditionId;
	}
	
	private void addPawnticketItem(int itemId, int pawnticketItemId,int pawnticketId, int quantity, double itemValue, int conditionId, String description, double interest, double netValue) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        String query = "INSERT INTO tbl_pawnticketitem (Item_ID, PawnticketItem_ID, Pawnticket_ID, Quantity, Item_Value, Condition_ID, Description, Interest, Net_Value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, itemId);
	        preparedStatement.setInt(2, pawnticketItemId);
	        preparedStatement.setInt(3, pawnticketId);
	        preparedStatement.setInt(4, quantity);
	        preparedStatement.setDouble(5, itemValue);
	        preparedStatement.setInt(6, conditionId);
	        preparedStatement.setString(7, description);
	        preparedStatement.setDouble(8, interest);
	        preparedStatement.setDouble(9, netValue);
	        
	        preparedStatement.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Pawnticket item added successfully.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error adding pawnticket item: " + e.getMessage());
	    } finally {
	        try {
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private int ensureTypeExistsAndGetId(String type) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int typeId = -1;
	    
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        //Check if the type exists
	        String queryCheck = "SELECT Type_ID FROM tbl_type WHERE Type_Name = ?";
	        preparedStatement = connection.prepareStatement(queryCheck);
	        preparedStatement.setString(1, type);
	        resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            typeId = resultSet.getInt("Type_ID");
	        } else {
	            //Type does not exist, insert new type
	            String queryInsert = "INSERT INTO tbl_type (Type_Name) VALUES (?)";
	            preparedStatement = connection.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
	            preparedStatement.setString(1, type);
	            preparedStatement.executeUpdate();
	            resultSet = preparedStatement.getGeneratedKeys();
	            if (resultSet.next()) {
	                typeId = resultSet.getInt(1); //Retrieve the generated type ID
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error processing type: " + e.getMessage());
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return typeId;
	}
	
	private int ensureBrandAndModelExistsAndGetModelId(String brand, String model) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int modelId = -1;
	    int brandId = -1;
	    
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        //Check if the brand exists
	        String queryCheckBrand = "SELECT Brand_ID FROM tbl_brand WHERE Brand_Name = ?";
	        preparedStatement = connection.prepareStatement(queryCheckBrand);
	        preparedStatement.setString(1, brand);
	        resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            brandId = resultSet.getInt("Brand_ID");
	        } else {
	            //Brand does not exist, insert new brand
	            String queryInsertBrand = "INSERT INTO tbl_brand (Brand_Name) VALUES (?)";
	            preparedStatement = connection.prepareStatement(queryInsertBrand, Statement.RETURN_GENERATED_KEYS);
	            preparedStatement.setString(1, brand);
	            preparedStatement.executeUpdate();
	            resultSet = preparedStatement.getGeneratedKeys();
	            if (resultSet.next()) {
	                brandId = resultSet.getInt(1); //Retrieve the generated brand ID
	            }
	        }
	        
	        //Now check if the model exists
	        String queryCheckModel = "SELECT Model_ID FROM tbl_model WHERE Model_Name = ? AND Brand_ID = ?";
	        preparedStatement = connection.prepareStatement(queryCheckModel);
	        preparedStatement.setString(1, model);
	        preparedStatement.setInt(2, brandId);
	        resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            modelId = resultSet.getInt("Model_ID");
	        } else {
	            //Model does not exist, insert new model
	            String queryInsertModel = "INSERT INTO tbl_model (Model_Name, Brand_ID) VALUES (?, ?)";
	            preparedStatement = connection.prepareStatement(queryInsertModel, Statement.RETURN_GENERATED_KEYS);
	            preparedStatement.setString(1, model);
	            preparedStatement.setInt(2, brandId);
	            preparedStatement.executeUpdate();
	            resultSet = preparedStatement.getGeneratedKeys();
	            if (resultSet.next()) {
	                modelId = resultSet.getInt(1); //Retrieve the generated model ID
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error processing brand/model: " + e.getMessage());
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return modelId;
	}
	
	private boolean addJewelryItem(int pawnticketItemId, String type, int weight, String purity) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        String query = "INSERT INTO tbl_jewelry (PawnticketItem_ID, Type_ID, Weight, Purity) VALUES (?, ?, ?, ?)";
	        
	        int typeId = ensureTypeExistsAndGetId(type);
	        
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, pawnticketItemId);
	        preparedStatement.setInt(2, typeId);
	        preparedStatement.setInt(3, weight);
	        preparedStatement.setString(4, purity);
	        
	        int affectedRows = preparedStatement.executeUpdate();
	        if (affectedRows > 0) {
	            JOptionPane.showMessageDialog(null, "Jewelry item added successfully.");
	            return true; // Success
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to add jewelry item.");
	            return false; // Failure
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error adding jewelry item: " + e.getMessage());
	        return false; // Failure
	    } finally {
	        try {
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private boolean addApplianceItem(int pawnticketItemId, String brand, String model, String serialNumber) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_goldvision", "root", "");
	        int modelId = ensureBrandAndModelExistsAndGetModelId(brand, model);
	        
	        String query = "INSERT INTO tbl_appliance (PawnticketItem_ID, Model_ID, Serial_Number) VALUES (?, ?, ?)";
	        
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, pawnticketItemId);
	        preparedStatement.setInt(2, modelId);
	        preparedStatement.setString(3, serialNumber);
	        
	        int affectedRows = preparedStatement.executeUpdate();
	        if (affectedRows > 0) {
	            JOptionPane.showMessageDialog(null, "Appliance item added successfully.");
	            return true; // Success
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to add appliance item.");
	            return false; // Failure
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error adding appliance item: " + e.getMessage());
	        return false; // Failure
	    } finally {
	        try {
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}

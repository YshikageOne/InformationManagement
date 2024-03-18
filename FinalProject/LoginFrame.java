package FinalProject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtpassword;
	private int loginAttempts = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 240, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("GoldVision Pawnshop");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 251, 220, 39);
		panel.add(lblWelcome);
		lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/FinalProject/assets/logoPawn (1).png")));
		lblNewLabel.setBounds(50, 59, 140, 140);
		panel.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setBounds(250, 27, 84, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(250, 113, 84, 14);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setBounds(250, 41, 175, 31);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpassword.setBounds(250, 127, 175, 31);
		contentPane.add(txtpassword);
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    BufferedReader reader = new BufferedReader(new FileReader("LoginDetails.txt"));
                    String[] credentials = reader.readLine().split("#");
                    reader.close();

                    String username = txtUsername.getText();
                    String password = new String(txtpassword.getPassword());

                    if (username.equals(credentials[0]) && password.equals(credentials[1])) {
                        JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                        Menu menu = new Menu();
                        menu.setVisible(true);
                        dispose();
                    } else {
                        loginAttempts--;
                        if (loginAttempts > 0) {
                            JOptionPane.showMessageDialog(null, "Invalid login. Please try again. Attempts left: " + loginAttempts, "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No attempts left. Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
                            btnLogin.setEnabled(false); 
                        }
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
			}
		});
		btnLogin.setBounds(250, 258, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using the program", "Goodbye", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
		btnQuit.setBounds(349, 258, 89, 23);
		contentPane.add(btnQuit);
		
		
		
	}

}

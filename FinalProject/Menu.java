package FinalProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Information Management\\FinalProject\\assets\\logoPawn.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(Menu.class.getResource("/FinalProject/assets/menuBackground (3).png")));
		lblImage.setBounds(194, 0, 348, 220);
		contentPane.add(lblImage);
		
		JButton btnPawnticket = new JButton("Pawnticket");
		btnPawnticket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Pawnticket pawnticket = new Pawnticket();
					pawnticket.setVisible(true);
					dispose();
			}
		});
		btnPawnticket.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPawnticket.setBounds(84, 262, 212, 95);
		contentPane.add(btnPawnticket);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				customer.setVisible(true);
				dispose();
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCustomer.setBounds(439, 262, 212, 95);
		contentPane.add(btnCustomer);
	}
}

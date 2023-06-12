import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Loginadmin extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField pass;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginadmin frame = new Loginadmin();
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
	public Loginadmin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1366,760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(1032, 150, 145, 43);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		
		t1 = new JTextField();
		t1.setBounds(954, 209, 308, 51);
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setColumns(10);
		
		JLabel l2 = new JLabel("Password");
		l2.setBounds(1032, 268, 145, 43);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		pass = new JPasswordField();
		pass.setBounds(954, 316, 308, 51);
		pass.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JCheckBox ch1 = new JCheckBox("Show Password");
		ch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ch1.isSelected())
				{
					pass.setEchoChar((char)0);
				}
				else
					pass.setEchoChar('*');
		
			}
		});
		ch1.setBounds(1032, 394, 137, 25);
		ch1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton b4 = new JButton("Login");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals("quems") && pass.getText().equals("admin"))
				{
					setVisible(false);
					new Adminhome().setVisible(true);
				}
				else
				{
					ImageIcon icon=new ImageIcon("Incorrect Password.PNG");
							JOptionPane.showMessageDialog(null, "<html><b style=\"color: blue; font-size:10px\">Incorrect <br>Username or Password</b><html>","Alert",JOptionPane.INFORMATION_MESSAGE,icon);
				}
			}
		});
		b4.setBounds(954, 448, 115, 44);
		b4.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\login.png"));
		b4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton b5 = new JButton("Back");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		b5.setBounds(1146, 448, 115, 44);
		b5.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Back.png"));
		b5.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setLayout(null);
		contentPane.add(l1);
		contentPane.add(t1);
		contentPane.add(l2);
		contentPane.add(pass);
		contentPane.add(ch1);
		contentPane.add(b4);
		contentPane.add(b5);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\login Background.PNG"));
		lblNewLabel.setBounds(0, 0, 1376, 760);
		contentPane.add(lblNewLabel);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

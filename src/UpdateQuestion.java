import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
public class UpdateQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateQuestion frame = new UpdateQuestion();
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
	public UpdateQuestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,80,1066,650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(15, 8, 62, 72);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Update Question.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Update Question");
		lblNewLabel_1.setBounds(96, 5, 431, 68);
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminhome.open=0;
				setVisible(false);
			}
		});
		btnNewButton.setBounds(958, 16, 93, 59);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Close.png"));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 87, 1040, 15);
		separator.setForeground(Color.MAGENTA);
		
		JLabel l2 = new JLabel("Question ID :-");
		l2.setBounds(15, 108, 143, 54);
		l2.setFont(new Font("Tahoma", Font.BOLD, 20));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		
		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setFont(new Font("Tahoma", Font.BOLD, 20));
		t1.setBounds(162, 108, 77, 54);
		t1.setColumns(10);
		
		JLabel l3 = new JLabel("Question :-");
		l3.setBounds(15, 180, 143, 44);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t2 = new JTextField();
		t2.setBounds(162, 180, 825, 44);
		t2.setFont(new Font("Tahoma", Font.BOLD, 20));
		t2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Difculty Level :");
		lblNewLabel_3.setBounds(455, 113, 150, 44);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_3);
		
		JComboBox c1 = new JComboBox();
		c1.setBounds(616, 113, 118, 44);
		c1.setFont(new Font("Tahoma", Font.BOLD, 20));
		c1.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		contentPane.add(c1);
		
		JButton b1 = new JButton("Search");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String qno = t1.getText(); 
				try
				{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from question where qno='"+qno+"'");
				if(rs.next())
				{
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
					t7.setText(rs.getString(7));
				    c1.getSelectedItem().toString();
					t1.setEditable(false);
				}
				else
				{
					JFrame jf=new JFrame();
							jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"Question number Does not Exist");
				}
				}
				 catch(Exception ee)
				{
					 JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf,ee); 
				}
			}
		});
		b1.setBounds(836, 108, 151, 54);
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		b1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\search.png"));
		
		JLabel l4 = new JLabel("Option 1 :-");
		l4.setBounds(15, 242, 143, 44);
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		l4.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel l5 = new JLabel("Option 2 :-");
		l5.setBounds(15, 304, 143, 44);
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		l5.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel l6 = new JLabel("Option 3 :-");
		l6.setBounds(15, 366, 143, 44);
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		l6.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel l7 = new JLabel("Option 4 :-");
		l7.setBounds(15, 428, 143, 44);
		l7.setHorizontalAlignment(SwingConstants.CENTER);
		l7.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel l8 = new JLabel("answerwer :-");
		l8.setBounds(15, 490, 143, 44);
		l8.setHorizontalAlignment(SwingConstants.CENTER);
		l8.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t3 = new JTextField();
		t3.setBounds(162, 242, 825, 44);
		t3.setFont(new Font("Tahoma", Font.BOLD, 20));
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(162, 304, 825, 44);
		t4.setFont(new Font("Tahoma", Font.BOLD, 20));
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(162, 366, 825, 44);
		t5.setFont(new Font("Tahoma", Font.BOLD, 20));
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(162, 428, 825, 44);
		t6.setFont(new Font("Tahoma", Font.BOLD, 20));
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setBounds(162, 490, 825, 44);
		t7.setFont(new Font("Tahoma", Font.BOLD, 20));
		t7.setColumns(10);
		
		JButton b2 = new JButton("Update");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String qno = t1.getText();
                String question = t2.getText();
                String option1 = t3.getText();
                String option2 = t4.getText();
                String option3 = t5.getText();
                String option4 = t6.getText();
                String answer = t7.getText();
				try
				{
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
				PreparedStatement ps=connection.prepareStatement("update question set question=?,option1=?,option2=?,option3=?,option4=?,answer=? where qno=?");
				ps.setString(7,qno);
				ps.setString(1,question);
				ps.setString(2,option1);
				ps.setString(3,option2);
				ps.setString(4,option3);
				ps.setString(5,option4);
				ps.setString(6,answer);
				ps.executeUpdate();
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
		        JOptionPane.showMessageDialog(jf,"Successfully upadte the Question");
		        setVisible(false);
		        new UpdateQuestion().setVisible(true);
				}
				catch (Exception ee)
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
			      JOptionPane.showMessageDialog(jf,ee);
				}
			}
		});
		b2.setBounds(162, 563, 144, 45);
		b2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\save.png"));
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton b3 = new JButton("Clear");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t1.setEditable(true);
				}
			
		});
		b3.setBounds(610, 563, 144, 45);
		b3.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\clear.png"));
		b3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.setLayout(null);
		contentPane.add(t3);
		contentPane.add(t4);
		contentPane.add(t5);
		contentPane.add(t6);
		contentPane.add(t7);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnNewButton);
		contentPane.add(separator);
		contentPane.add(l2);
		contentPane.add(t1);
		contentPane.add(b1);
		contentPane.add(l3);
		contentPane.add(t2);
		contentPane.add(l4);
		contentPane.add(l5);
		contentPane.add(l6);
		contentPane.add(l7);
		contentPane.add(l8);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background admin.jpg"));
		lblNewLabel_2.setBounds(0, 91, 1051, 522);
		contentPane.add(lblNewLabel_2);
	}
}

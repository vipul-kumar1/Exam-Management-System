import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Delete extends JFrame {

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
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,80,1086,637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\delete Question.png"));
		
		JButton b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminhome.open=0;
				setVisible(false);
			}
		});
		b1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Close.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Delete Question");
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GREEN);
		
		JLabel l1 = new JLabel("Question ID :-");
		l1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setFont(new Font("Tahoma", Font.BOLD, 20));
		t1.setColumns(10);
		
		JButton b2 = new JButton("Search");
		b2.addActionListener(new ActionListener() {
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
					t1.setEditable(false);
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showConfirmDialog(jf,"Question id Does not Exist");
				}
			}
				catch(Exception e1)
				{
					 JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf,e1); 
				}
			}
		});
		b2.setHorizontalAlignment(SwingConstants.LEADING);
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		b2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\search.png"));
		
		JLabel l2 = new JLabel("Question :-");
		l2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 20));
		t2.setColumns(10);
		
		JLabel l3 = new JLabel("Option 1 :-");
		l3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 20));
		t3.setColumns(10);
		
		JLabel l4 = new JLabel("Option 2 :-");
		l4.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 20));
		t4.setColumns(10);
		
		JLabel l5 = new JLabel("Option 3 :-");
		l5.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 20));
		t5.setColumns(10);
		
		JLabel l6 = new JLabel("Option 4 :-");
		l6.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 20));
		t6.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer :-");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 20));
		
	
		
		JButton b3 = new JButton("Delete");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String qno = t1.getText();
				try
				{
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
					PreparedStatement pst = connection.prepareStatement("delete from question where qno = ? ");
					pst.setString(1, qno);
					pst.executeUpdate();
					JFrame jf = new JFrame();
	            	jf.setAlwaysOnTop(true);
	                JOptionPane.showMessageDialog(jf,"Deleted Successfully");
	                setVisible(false);
	                new Delete().setVisible(true);
				}
				catch (Exception ex)
	            {
	            	JFrame jf = new JFrame();
	            	jf.setAlwaysOnTop(true);
	                JOptionPane.showMessageDialog(jf,e);
	            }
			}
		});

		b3.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\delete.png"));
		b3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		JButton b4 = new JButton("Clear");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				
			}
			
		});
		b4.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\clear.png"));
		b4.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background admin.jpg"));
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 20));
		t7.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addGap(540)
					.addComponent(b1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1054, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(l1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(l2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(l3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(l4, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(l5, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(l6, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnswer, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(b3, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(t1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(205)
							.addComponent(b2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addComponent(t2, GroupLayout.PREFERRED_SIZE, 830, GroupLayout.PREFERRED_SIZE)
						.addComponent(t3, GroupLayout.PREFERRED_SIZE, 830, GroupLayout.PREFERRED_SIZE)
						.addComponent(t4, GroupLayout.PREFERRED_SIZE, 830, GroupLayout.PREFERRED_SIZE)
						.addComponent(t5, GroupLayout.PREFERRED_SIZE, 830, GroupLayout.PREFERRED_SIZE)
						.addComponent(t6, GroupLayout.PREFERRED_SIZE, 830, GroupLayout.PREFERRED_SIZE)
						.addComponent(t7, GroupLayout.PREFERRED_SIZE, 830, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(230)
							.addComponent(b4, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))))
				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 1069, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(b1))
					.addGap(6)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(l1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(l2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(l3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(l4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(l5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(l6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblAnswer, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(b3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(t1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(b2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(t2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(t3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(t4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(t5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(t6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(t7, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(b4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

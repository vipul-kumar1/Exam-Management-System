import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddQuestion extends JFrame {

	protected static final JLabel textfield = null;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JComboBox c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion frame = new AddQuestion();
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
	public AddQuestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,80,1066,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 60, 78);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\add new question.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Add New Question");
		lblNewLabel_1.setBounds(74, 5, 400, 78);
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(957, 14, 85, 69);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminhome.open=0;
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Close.png"));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 89, 1054, 13);
		separator.setBackground(Color.RED);
		
		JLabel l1 = new JLabel("Question ID :");
		l1.setBounds(25, 108, 154, 25);
		l1.setFont(new Font("Tahoma", Font.BOLD, 20));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel l2 = new JLabel("00");
		l2.setBounds(189, 108, 80, 25);
		l2.setForeground(Color.RED);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel l3 = new JLabel("Question :");
		l3.setBounds(25, 151, 154, 35);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel l4 = new JLabel("Option 1 :");
		l4.setBounds(25, 204, 154, 34);
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		l4.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel l5 = new JLabel("Option 2 :");
		l5.setBounds(25, 259, 154, 33);
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		l5.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel l6 = new JLabel("Option 3 :");
		l6.setBounds(25, 310, 154, 36);
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		l6.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t1 = new JTextField();
		t1.setBounds(189, 151, 831, 35);
		t1.setFont(new Font("Tahoma", Font.BOLD, 20));
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(189, 204, 831, 35);
		t2.setFont(new Font("Tahoma", Font.BOLD, 20));
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(189, 257, 831, 35);
		t3.setFont(new Font("Tahoma", Font.BOLD, 20));
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(189, 310, 831, 35);
		t4.setFont(new Font("Tahoma", Font.BOLD, 20));
		t4.setColumns(10);
		
		JLabel l7 = new JLabel("Option 4 :");
		l7.setBounds(25, 353, 154, 36);
		l7.setHorizontalAlignment(SwingConstants.CENTER);
		l7.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t5 = new JTextField();
		t5.setBounds(189, 353, 831, 35);
		t5.setFont(new Font("Tahoma", Font.BOLD, 20));
		t5.setColumns(10);
		
		JLabel l8 = new JLabel("Answer :");
		l8.setBounds(25, 407, 154, 36);
		l8.setHorizontalAlignment(SwingConstants.CENTER);
		l8.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		t6 = new JTextField();
		t6.setBounds(189, 408, 831, 35);
		t6.setFont(new Font("Tahoma", Font.BOLD, 20));
		t6.setColumns(10);
		contentPane.setLayout(null);
		
		JComboBox c1 = new JComboBox();
		c1.setBounds(866, 100, 154, 41);
		c1.setFont(new Font("Tahoma", Font.BOLD, 20));
		c1.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		contentPane.add(c1);
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
		
			Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery("select count(qno) from question");
            if (rs.next())
            {
            	int qid=rs.getInt(1);
            	qid = qid+1;
            
            	l2.setText(String.valueOf(qid));
            }
            else
            {
            	l2.setText("1");
            }
            
		}
            catch (Exception e)
            {
            	JFrame jf = new JFrame();
            	jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,e);
            }
		
		
		JButton b1 = new JButton("Save");
		b1.setBounds(48, 495, 116, 48);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String qno = l2.getText();
                String question = t1.getText();
                String option1 = t2.getText();
                String option2 = t3.getText();
                String option3 = t4.getText();
                String option4 = t5.getText();
                String answer = t6.getText();
                String level = c1.getSelectedItem().toString();

                
				try
				{
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
						String query = "INSERT INTO question values('" + qno + "','" + question + "','" + option1 + "','" + option2 + "','" + option3 + "','" + option4 + "','"+ answer + "','" + level + "')";
                      PreparedStatement ps = connection.prepareStatement(query);
                       int x = ps.executeUpdate();
                    	JFrame jf = new JFrame();
                    	jf.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(b1,"success");
                        setVisible(false);
                        new AddQuestion().setVisible(true);
				}
				catch (Exception ex)
				{
					JFrame jf = new JFrame();
	            	jf.setAlwaysOnTop(true);
	            	JOptionPane.showMessageDialog(b1,"Something Wrong ");
				}
			}
		});
		b1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\save.png"));
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton b2 = new JButton("Clear");
		b2.setBounds(440, 495, 116, 48);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				c1.setSelectedIndex(-1);
				
			}
		});
		b2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\clear.png"));
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_1);
		contentPane.add(l8);
		contentPane.add(t6);
		contentPane.add(l7);
		contentPane.add(t5);
		contentPane.add(l1);
		contentPane.add(l2);
		contentPane.add(l4);
		contentPane.add(l3);
		contentPane.add(l5);
		contentPane.add(l6);
		contentPane.add(t2);
		contentPane.add(t1);
		contentPane.add(t3);
		contentPane.add(t4);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(separator);
		contentPane.add(c1);
		
		JLabel lblNewLabel_2 = new JLabel("Difculty Level :");
		lblNewLabel_2.setBounds(702, 100, 154, 41);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background student.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1050, 563);
		contentPane.add(lblNewLabel_3);
		
		
	}
}

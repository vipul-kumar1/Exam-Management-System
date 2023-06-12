import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Clock;
import java.time.LocalDate;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Detailed extends JFrame {

	private JPanel contentPane;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField Tf1;
	private JTextField txtEnterBoard;
	private JTextField txtEnterUniversity;
	private JTextField txtEnterPercentage;
	private JTextField txtEnterPercentage_1;
	private JTextField txtEnterPercentage_2;
	private JTextField txtPassingYear;
	private JTextField txtPassingYear_1;
	private JTextField txtPassingYear_2;
	private JTextField Vipul;
	String rollno;
	String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detailed frame = new Detailed();
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
	public Detailed() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		 //SimpleDateFormat dFormat=new SimpleDateFormat("dd-mm-yyyy");
		// Vipul.setText(dFormat.format(date));
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 72, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\online test management\\qems\\index student.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Fill Up The Form");
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel_1.setBounds(83, 16, 378, 57);
//		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
		
		JLabel lblNewLabel_2 = new JLabel("DATE :-");
		lblNewLabel_2.setBounds(486, 17, 77, 57);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("NEXT");
        btnNewButton.setBounds(179, 129, 89, 23);
        btnNewButton.setEnabled(false);
        getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent argo) {
                String rollNo = textField_0.getText();
                String name= textField_1.getText();
                Information information = new Information(rollNo,name);
                information.setVisible(true);
                dispose();
            }
        });
		btnNewButton.setBounds(962, 17, 165, 57);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Next.png"));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int a=JOptionPane.showConfirmDialog(null,"Do You Want to Exit","Select",JOptionPane.YES_NO_OPTION);
							if(a==0)
							{
								System.exit(0);
							}
			}
		});
		btnNewButton_1.setBounds(1175, 16, 93, 57);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\online test management\\qems\\Close.png"));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 86, 1273, 2);
		
		JLabel lblNewLabel_4 = new JLabel("Roll Number");
		lblNewLabel_4.setBounds(5, 99, 152, 45);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_0 = new JTextField();
		textField_0.setBounds(223, 99, 289, 49);
		textField_0.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_0.setColumns(10);
		
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setBounds(5, 159, 152, 45);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 159, 289, 49);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Father Name");
		lblNewLabel_6.setBounds(5, 228, 152, 45);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 226, 289, 49);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Mother Name");
		lblNewLabel_7.setBounds(5, 295, 152, 45);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_3 = new JTextField();
		textField_3.setBounds(223, 293, 289, 49);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile No.");
		lblNewLabel_8.setBounds(5, 364, 152, 45);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_4 = new JTextField();
		textField_4.setBounds(223, 360, 289, 49);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Email Id");
		lblNewLabel_9.setBounds(5, 429, 152, 45);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_5 = new JTextField();
		textField_5.setBounds(223, 427, 289, 49);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("10th");
		lblNewLabel_10.setBounds(5, 494, 152, 45);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		Tf1 = new JTextField();
		Tf1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			    if(Tf1.getText().equals("Enter Board")) {
			    	Tf1.setText("");
			    	Tf1.setForeground(new Color(0,0,0));
			    }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(Tf1.getText().equals("")) {
					Tf1.setText("Enter Board");
					Tf1.setForeground(new Color(153,153,153));
				}
			}
		});
		Tf1.setBounds(223, 494, 289, 49);
		Tf1.setForeground(Color.LIGHT_GRAY);
		Tf1.setText("Enter Board");
		Tf1.setHorizontalAlignment(SwingConstants.CENTER);
		Tf1.setFont(new Font("Tahoma", Font.BOLD, 20));
		Tf1.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("12th");
		lblNewLabel_11.setBounds(5, 554, 152, 45);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtEnterBoard = new JTextField();
		txtEnterBoard.setForeground(Color.LIGHT_GRAY);
		txtEnterBoard.setText("Enter Board");
		txtEnterBoard.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterBoard.getText().equals("Enter Board")) {
			    	txtEnterBoard.setText("");
			    	txtEnterBoard.setForeground(new Color(0,0,0));
			    }
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterBoard.getText().equals("")) {
					txtEnterBoard.setText("Enter Board");
					txtEnterBoard.setForeground(new Color(153,153,153));
				}
			}
		});
		txtEnterBoard.setBounds(223, 554, 289, 49);
		txtEnterBoard.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterBoard.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEnterBoard.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Graduation");
		lblNewLabel_12.setBounds(5, 618, 152, 45);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtEnterUniversity = new JTextField();
		txtEnterUniversity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterUniversity.getText().equals("Enter University")) {
					txtEnterUniversity.setText("");
					txtEnterUniversity.setForeground(new Color(0,0,0));
			    }
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterUniversity.getText().equals("")) {
					txtEnterUniversity.setText("Enter University");
					txtEnterUniversity.setForeground(new Color(153,153,153));
				}
			}
		});
		txtEnterUniversity.setForeground(Color.LIGHT_GRAY);
		txtEnterUniversity.setText("Enter University");
		txtEnterUniversity.setBounds(223, 614, 289, 49);
		txtEnterUniversity.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterUniversity.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEnterUniversity.setColumns(10);
		
		txtEnterPercentage = new JTextField();
		txtEnterPercentage.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterPercentage.getText().equals("Enter percentage")) {
					txtEnterPercentage.setText("");
					txtEnterPercentage.setForeground(new Color(0,0,0));
			    }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterPercentage.getText().equals("")) {
					txtEnterPercentage.setText("Enter percentage");
					txtEnterPercentage.setForeground(new Color(153,153,153));
				}
			}
		});
		txtEnterPercentage.setForeground(Color.LIGHT_GRAY);
		txtEnterPercentage.setText("Enter percentage");
		txtEnterPercentage.setBounds(664, 494, 257, 49);
		txtEnterPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPercentage.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEnterPercentage.setColumns(10);
		
		txtEnterPercentage_1 = new JTextField();
		txtEnterPercentage_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterPercentage_1.getText().equals("Enter percentage")) {
					txtEnterPercentage_1.setText("");
					txtEnterPercentage_1.setForeground(new Color(0,0,0));
			    }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterPercentage_1.getText().equals("")) {
					txtEnterPercentage_1.setText("Enter percentage");
					txtEnterPercentage_1.setForeground(new Color(153,153,153));
				}
			}
			
		});
		txtEnterPercentage_1.setForeground(Color.LIGHT_GRAY);
		txtEnterPercentage_1.setText("Enter percentage");
		txtEnterPercentage_1.setBounds(664, 554, 257, 49);
		txtEnterPercentage_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPercentage_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEnterPercentage_1.setColumns(10);
		
		txtEnterPercentage_2 = new JTextField();
		txtEnterPercentage_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterPercentage_2.getText().equals("Enter percentage")) {
					txtEnterPercentage_2.setText("");
					txtEnterPercentage_2.setForeground(new Color(0,0,0));
			    }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterPercentage_2.getText().equals("")) {
					txtEnterPercentage_2.setText("Enter percentage");
					txtEnterPercentage_2.setForeground(new Color(153,153,153));
				}
			}
		});
		txtEnterPercentage_2.setForeground(Color.LIGHT_GRAY);
		txtEnterPercentage_2.setText("Enter percentage");
		txtEnterPercentage_2.setBounds(664, 614, 257, 49);
		txtEnterPercentage_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPercentage_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEnterPercentage_2.setColumns(10);
		
		txtPassingYear = new JTextField();
		txtPassingYear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassingYear.getText().equals("Passing Year")) {
					txtPassingYear.setText("");
					txtPassingYear.setForeground(new Color(0,0,0));
			    }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassingYear.getText().equals("")) {
					txtPassingYear.setText("Passing Year");
					txtPassingYear.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPassingYear.setForeground(Color.LIGHT_GRAY);
		txtPassingYear.setText("Passing Year");
		txtPassingYear.setBounds(1011, 494, 257, 49);
		txtPassingYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassingYear.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassingYear.setColumns(10);
		
		txtPassingYear_1 = new JTextField();
		txtPassingYear_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassingYear_1.getText().equals("Passing Year")) {
					txtPassingYear_1.setText("");
					txtPassingYear_1.setForeground(new Color(0,0,0));
			    }	
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassingYear_1.getText().equals("")) {
					txtPassingYear_1.setText("Passing Year");
					txtPassingYear_1.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPassingYear_1.setForeground(Color.LIGHT_GRAY);
		txtPassingYear_1.setText("Passing Year");
		txtPassingYear_1.setBounds(1011, 554, 257, 49);
		txtPassingYear_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassingYear_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassingYear_1.setColumns(10);
		
		txtPassingYear_2 = new JTextField();
		txtPassingYear_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassingYear_2.getText().equals("Passing Year")) {
					txtPassingYear_2.setText("");
					txtPassingYear_2.setForeground(new Color(0,0,0));
			    }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassingYear_2.getText().equals("")) {
					txtPassingYear_2.setText("Passing Year");
					txtPassingYear_2.setForeground(new Color(153,153,153));
				}
			}
		});
		txtPassingYear_2.setForeground(Color.LIGHT_GRAY);
		txtPassingYear_2.setText("Passing Year");
		txtPassingYear_2.setBounds(1011, 614, 257, 49);
		txtPassingYear_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassingYear_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassingYear_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String RollNo = textField_0.getText();
		        String Name = textField_1.getText();
		        String FatherName = textField_2.getText();
		        String MotherName = textField_3.getText();
		        String MobileNo = textField_4.getText();
		        String EmailId = textField_5.getText();
		        String tenthBoardName = Tf1.getText();
		        String tenthPercentage = txtEnterPercentage.getText();
		        String tenthPassingYear = txtPassingYear.getText();
		        String twelveBoardName = txtEnterBoard.getText();
		        String twelvePercentage = txtEnterPercentage_1.getText();
		        String twelvePassingYear = txtPassingYear_1.getText();
		        String graduationUniversityName = txtEnterUniversity.getText();
		        String graduationPercentage = txtEnterPercentage_2.getText();
		        String graduationPassingYear = txtPassingYear_2.getText();
		        

		        try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
                    PreparedStatement ps = connection.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, RollNo);
                    ps.setString(2, Name);
                    ps.setString(3, FatherName);
                    ps.setString(4, MotherName);
                    ps.setString(5, MobileNo);
                    ps.setString(6, EmailId);
                    ps.setString(7, tenthBoardName);
                    ps.setString(8, tenthPercentage);
                    ps.setString(9, tenthPassingYear);
                    ps.setString(10, twelveBoardName);
                    ps.setString(11, twelvePercentage);
                    ps.setString(12, twelvePassingYear);
                    ps.setString(13, graduationUniversityName);
                    ps.setString(14, graduationPercentage);
                    ps.setString(15, graduationPassingYear);
                    

                    ps.executeUpdate();
                    btnNewButton.setEnabled(true);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Error saving data to the database: " + e1.getMessage());
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "An error occurred: " + e2.getMessage());
                }
            }
        });
    



		btnNewButton_2.setBounds(745, 17, 152, 57);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\save.png"));
		contentPane.setLayout(null);
		
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_8);
		contentPane.add(lblNewLabel_9);
		contentPane.add(textField_5);
		contentPane.add(textField_4);
		contentPane.add(textField_3);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(textField_0);
		contentPane.add(lblNewLabel_10);
		contentPane.add(Tf1);
		contentPane.add(lblNewLabel_11);
		contentPane.add(lblNewLabel_12);
		contentPane.add(txtEnterUniversity);
		contentPane.add(txtEnterBoard);
		contentPane.add(txtEnterPercentage);
		contentPane.add(txtEnterPercentage_1);
		contentPane.add(txtEnterPercentage_2);
		contentPane.add(txtPassingYear_2);
		contentPane.add(txtPassingYear_1);
		contentPane.add(txtPassingYear);
		contentPane.add(separator);
		
		JTextArea txtrExaminationManagementSystem = new JTextArea();
		txtrExaminationManagementSystem.setBounds(733, 113, 464, 307);
		txtrExaminationManagementSystem.setFont(new Font("Monospaced", Font.BOLD, 25));
		txtrExaminationManagementSystem.setText("Examination management System\r\nIs Managing All the Activities Related \r\nTo Examination Management \r\nRight Form receipt of \r\nEnrollement forms And \r\nExamination Forms through \r\nThe processing of Results \r\nAnd Grading Report.");
		txtrExaminationManagementSystem.setEditable(false);
		contentPane.add(txtrExaminationManagementSystem);
		
		JTextField Vipul = new JTextField(LocalDate.now().toString());
		Vipul.setEditable(false);
		Vipul.setFont(new Font("Tahoma", Font.BOLD, 20));
		Vipul.setBounds(573, 16, 135, 60);
		contentPane.add(Vipul);
		Vipul.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background student.jpg"));
		lblNewLabel_3.setBounds(5, 5, 1278, 669);
		contentPane.add(lblNewLabel_3);
	}

	private void setText(String format) {
		// TODO Auto-generated method stub
		
	}
}

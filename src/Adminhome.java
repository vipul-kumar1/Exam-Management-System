import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminhome extends JFrame {
public static int open=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminhome frame = new Adminhome();
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
	public Adminhome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,1366, 680);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JButton b6 = new JButton("Add Question");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)	
				{
					new AddQuestion().setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"One is already open");
				}
			}
		});
		b6.setHorizontalAlignment(SwingConstants.LEADING);
		b6.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\add new question.png"));
		b6.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(b6);
		
		JButton b7 = new JButton("Update Question");
		b7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)	
				{
					new UpdateQuestion().setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"One is already open");
				}
				
			}
		});
		b7.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Update Question.png"));
		b7.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(b7);
		
		JButton b8 = new JButton("All Question");
		b8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)	
				{
					new Allquestion().setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"One is already open");
				}
			}
		});
		b8.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\all questions.png"));
		b8.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(b8);
		
		JButton b9 = new JButton("Delete Question");
		b9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)	
				{
					new Delete().setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"One is already open");
				}
			}
		});
		b9.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\delete Question.png"));
		b9.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(b9);
		
		JButton b10 = new JButton("Student Result");
		
		b10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0)	
				{
					new Allresult().setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"One is already open");
				}
			}
		});
		b10.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\all student result.png"));
		b10.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(b10);
		
		JButton b11 = new JButton("Log Out");
		b11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				int a=JOptionPane.showConfirmDialog(jf,"Do You Want To LogOut","Select",JOptionPane.YES_NO_OPTION);
				if (a==0)
				{
					setVisible(false);
					new Loginadmin().setVisible(true);
				}
			}
		});
		b11.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Logout.png"));
		b11.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(b11);
		
		JButton b12 = new JButton("Exit");
		b12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				int a=JOptionPane.showConfirmDialog(jf,"Do You Want To Exit","Select",JOptionPane.YES_NO_OPTION);
				if (a==0)
				{
					System.exit(0); 
				}
			}
		});
		b12.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Close.png"));
		b12.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(b12);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\index background.png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 1283, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}

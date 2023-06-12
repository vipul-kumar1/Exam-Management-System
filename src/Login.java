import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final Action action= new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1374, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton b1 = new JButton("Student");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Detailed().setVisible(true);
			}
		});
		b1.setBounds(600, 43, 160, 56);
		b1.setHorizontalAlignment(SwingConstants.LEFT);
		b1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\index student.png"));
		b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton b2 = new JButton("Admin");
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				setVisible(false);
				new Loginadmin().setVisible(true);
			}
		});
		b2.setBounds(860, 43, 150, 56);
		b2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\index admin.png"));
		b2.setHorizontalAlignment(SwingConstants.LEFT);
		b2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton b3 = new JButton("Exit");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do You Want to Exit","Select",JOptionPane.YES_NO_OPTION);
						if(a==0)
						{
							System.exit(0);
						}
			}
		});
		b3.setBounds(1111, 43, 150, 56);
		b3.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Close.png"));
		b3.setHorizontalAlignment(SwingConstants.LEFT);
		b3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setLayout(null);
		panel.setBounds(51, 220, 0, 0);
		contentPane.add(panel);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\index background.png"));
		lblNewLabel.setBounds(0, 0, 1283, 672);
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

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.SwingUtilities;


public class Showresult extends JFrame {
    private int totalMarks;
    private String rollNo1;
    private String name;
    private JPanel contentPane;
    private JLabel l2;

    public Showresult(int totalMarks, String name, String rollNo1) {
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.totalMarks = totalMarks;
        this.name = name;
        this.rollNo1 = rollNo1;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 80, 1066, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Marks Obtained:-");
        l1.setBounds(349, 204, 339, 73);
        l1.setFont(new Font("Tahoma", Font.BOLD, 35));
        contentPane.add(l1);

        l2 = new JLabel(Integer.toString(totalMarks));
        l2.setBounds(691, 215, 45, 50);
        l2.setFont(new Font("Tahoma", Font.BOLD, 35));
        contentPane.add(l2);

        JLabel l3 = new JLabel(name);
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        l3.setBounds(266, 65, 300, 58);
        contentPane.add(l3);

        JLabel l4 = new JLabel(rollNo1);
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        l4.setBounds(687, 65, 300, 58);
        contentPane.add(l4);
        
           JButton b1 = new JButton("SUBMIT SUCCESSFULLY");
           b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (source.getText().equals("SUBMIT SUCCESSFULLY")) {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
                        String query = "INSERT INTO result (name, rollNo, totalMarks) VALUES (?, ?, ?)";
                        PreparedStatement ps = connection.prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, rollNo1);
                        ps.setInt(3, totalMarks);
                        int rowsInserted = ps.executeUpdate();

                        if (rowsInserted > 0) {
                            System.out.println("Data inserted successfully.");
                        } else {
                            System.out.println("Data insertion failed.");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    source.setText("CLOSE");
                } else if (source.getText().equals("CLOSE")) {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(source);
                    frame.dispose();
                }
            }
        });

        b1.setFont(new Font("Tahoma", Font.BOLD, 25));
        b1.setBounds(349, 327, 397, 66);
        contentPane.add(b1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background student.jpg"));
        lblNewLabel_1.setBounds(0, 0, 1052, 563);
        contentPane.add(lblNewLabel_1);
    }
}

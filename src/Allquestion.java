import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Allquestion extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Allquestion frame = new Allquestion();
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
    public Allquestion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 80, 1066, 590);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\all questions.png"));
        lblNewLabel.setBounds(0, 0, 66, 60);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ALL QUESTION");
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 50));
        lblNewLabel_1.setBounds(76, 0, 367, 60);
        contentPane.add(lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 104, 1019, 417);
        contentPane.add(scrollPane);
        
        
        

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"qno", "question", "option1", "option2", "option3", "option4", "answer"}
        ));
        JButton b1 = new JButton("");
        b1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\Close.png"));
        b1.setBounds(964, 0, 78, 60);
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminhome.open=0;
				setVisible(false);
			}
		});
        contentPane.add(b1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background student.jpg"));
        lblNewLabel_2.setBounds(0, 0, 1052, 553);
        contentPane.add(lblNewLabel_2);
        
        
        
        fetchQuestions(); // Fetch questions from the database and populate the table
    }
    
    private void fetchQuestions() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM question";
            ResultSet resultSet = statement.executeQuery(query);

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

            while (resultSet.next()) {
                String qno = resultSet.getString("qno");
                String question = resultSet.getString("question");
                String option1 = resultSet.getString("option1");
                String option2 = resultSet.getString("option2");
                String option3 = resultSet.getString("option3");
                String option4 = resultSet.getString("option4");
                String answer = resultSet.getString("answer");

                tableModel.addRow(new Object[] {qno, question, option1, option2, option3, option4, answer});
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

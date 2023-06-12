import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Information extends JFrame {
    private JPanel contentPane;
    private JLabel l2;

    public Information(String rollNo,String name) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1370, 690);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("");
        l1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\index student.png"));
        l1.setBounds(0, 0, 60, 56);
        // l1.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\index student.png"));
        contentPane.add(l1);

        JLabel lblNewLabel_1 = new JLabel("Instruction");
        lblNewLabel_1.setBounds(70, 0, 268, 56);
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 40));
        contentPane.add(lblNewLabel_1);

        JTextArea txtrpleaseReadThe = new JTextArea();
        txtrpleaseReadThe.setBounds(0, 81, 1273, 449);
        txtrpleaseReadThe.setEditable(false);
        txtrpleaseReadThe.setFont(new Font("Monospaced", Font.BOLD, 25));
        txtrpleaseReadThe.setText("Please read the instructions carefully before starting the quiz.\n\n1. The student may not use his or her textbook, course notes, or receive help from a proctor or any other outside source.\n2. Student must complete the 10 multiple choice question within 10-minute time frame allotted for the quizExamStudent.\n3. Student must not stop the session and then return to it. This is especially important in the online quizExamStudent environment where the system will \"time-out\" and not allow the student or you to reenter the quizExamStudent.\n\nNumber of question: 10\nquizExamStudent Duration: 10 min.\nAll the Best !");
        contentPane.add(txtrpleaseReadThe);

        JButton btnNewButton = new JButton("Start Exam");
        btnNewButton.setBounds(495, 547, 255, 56);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0){
        		quizExamStudent quiz=new quizExamStudent(rollNo,name);
        		dispose();
        		quiz.setVisible(rootPaneCheckingEnabled);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 36));
        contentPane.add(btnNewButton);
       

        JLabel lblNewLabel_3 = new JLabel("Roll no:");
        lblNewLabel_3.setBounds(820, 11, 78, 42);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_3);

        l2 = new JLabel(rollNo);
        l2.setBounds(920, 11, 171, 42);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(l2);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background student.jpg"));
        lblNewLabel.setBounds(0, 0, 1283, 653);
        contentPane.add(lblNewLabel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Information frame = new Information("1900560100","name");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends JPanel {
    private JLabel lblTitle;
    private JLabel lblInstructions;
    private JButton btnStartQuiz;

    /**
     * Create the panel.
     */
    public Instruction(String rollNo) {
        initialize(rollNo);
    }

    private void initialize(String rollNo) {
        setBounds(0, 0, 1248, 544);
        setLayout(null);

        lblTitle = new JLabel("Welcome to the Quiz!");
        lblTitle.setBounds(237, 22, 464, 57);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
        add(lblTitle);

        lblInstructions = new JLabel("<html><p align=\"center\">Please read the instructions carefully before starting the quiz:</p><br/><p>1. There are 10 questions in total.</p><p>2. Each question has 4 options, out of which only one is correct.</p><p>3. For each correct answer, you will get 1 point.</p><p>4. There is no negative marking for wrong answers.</p><p>5. You will have 30 seconds to answer each question.</p><br/><p align=\"center\">Good luck!</p></html>");
        lblInstructions.setBounds(138, 121, 837, 239);
        lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
        lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblInstructions);

        btnStartQuiz = new JButton("Start Exam");
        btnStartQuiz.setBounds(464, 432, 207, 51);
        btnStartQuiz.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnStartQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                quizExamStudent quiz = new quizExamStudent(rollNo);
                quiz.setVisible(true);

                // Close the parent panel (Instruction)
                JFrame frame = (JFrame) SwingUtilities.getRoot(Instruction.this);
                frame.dispose();
            }
        });
        add(btnStartQuiz);

        JLabel lblRollNo = new JLabel("Roll No: " + rollNo);
        lblRollNo.setBounds(891, 22, 250, 40);
        lblRollNo.setHorizontalAlignment(SwingConstants.CENTER);
        lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblRollNo);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background student.jpg"));
        lblNewLabel.setBounds(10, 11, 1206, 522);
        add(lblNewLabel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1248, 544);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(new Instruction("12345"));
        frame.setVisible(true);
    }
}

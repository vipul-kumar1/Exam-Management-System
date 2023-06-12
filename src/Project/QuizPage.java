import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizPage extends JFrame {
    private String rollNo;

    public QuizPage(String rollNo) {
        this.rollNo = rollNo;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Quiz Page");
        setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel questionLabel = new JLabel("Question");
        panel.add(questionLabel, BorderLayout.NORTH);

        JRadioButton option1 = new JRadioButton("Option 1");
        JRadioButton option2 = new JRadioButton("Option 2");
        JRadioButton option3 = new JRadioButton("Option 3");
        JRadioButton option4 = new JRadioButton("Option 4");

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        panel.add(option1, BorderLayout.WEST);
        panel.add(option2, BorderLayout.CENTER);
        panel.add(option3, BorderLayout.EAST);
        panel.add(option4, BorderLayout.SOUTH);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fetch next question and options from the backend
                // Update the questionLabel and radio buttons with new data

                // Example code:
                questionLabel.setText("New Question");
                option1.setText("New Option 1");
                option2.setText("New Option 2");
                option3.setText("New Option 3");
                option4.setText("New Option 4");
            }
        });

        panel.add(nextButton, BorderLayout.PAGE_END);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String rollNo = ""; // Provide the roll number here
                new QuizPage(rollNo).setVisible(true);
            }
        });
    }
}

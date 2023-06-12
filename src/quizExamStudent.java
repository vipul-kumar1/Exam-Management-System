import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class quizExamStudent extends JFrame {
    private String[] questions;
    private String rollNo;
    private String name;
    private String[][] options;
    private String[] correctAnswers;
    private int currentQuestionIndex;
    private int totalMarks;
    private String[] levels;
    private JLabel rollNoLabel;
    private JLabel nameLabel;
    private JLabel questionLabel;
    private JLabel timeLabel;
    private JRadioButton optionButton1;
    private JRadioButton optionButton2;
    private JRadioButton optionButton3;
    private JRadioButton optionButton4;
    private JButton actionButton; // Next/Submit button
    private JButton previousButton; // Previous button
    private ButtonGroup optionGroup;

    private Timer timer;
    private int timeCounter;
    private Panel panel;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private Panel panel_1;
    private JLabel l2;
    private Panel panel_2;
    private Panel panel_3;
    private JLabel lblNewLabel_4;
    private JLabel l9;

    public quizExamStudent(String rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        fetchQuestionsFromDatabase();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1370, 690);
        getContentPane().setLayout(null);

        optionGroup = new ButtonGroup();

        panel = new Panel();
        panel.setBounds(10, 10, 1263, 95);
        panel.setBackground(new Color(255, 215, 0));
        getContentPane().add(panel);
        panel.setLayout(null);
        
        

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\index student.png"));
        lblNewLabel.setBounds(10, 0, 67, 73);
        panel.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("WELCOME");
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 50));
        lblNewLabel_1.setBounds(87, 0, 253, 73);
        panel.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Date:-");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(495, 24, 67, 35);
        panel.add(lblNewLabel_2);


        JLabel l1 = new JLabel(LocalDate.now().toString());
        l1.setBounds(563, 25, 136, 35);
        panel.add(l1);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));

        lblNewLabel_3 = new JLabel("Total Time:-10 min");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_3.setBounds(978, 0, 259, 46);
        panel.add(lblNewLabel_3);

        timeLabel = new JLabel("Time Taken: 10 min 0 sec");
        timeLabel.setBounds(978, 43, 259, 41);
        panel.add(timeLabel);
        timeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        timeLabel.setForeground(new Color(255, 0, 0));

        panel_1 = new Panel();
        panel_1.setBounds(10, 111, 363, 532);
        panel_1.setBackground(new Color(255, 215, 0));
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        rollNoLabel = new JLabel("Roll No: " + rollNo);
        rollNoLabel.setBounds(10, 11, 297, 51);
        rollNoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_1.add(rollNoLabel);

        nameLabel = new JLabel("Name: " + name);
        nameLabel.setBounds(10, 96, 297, 51);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_1.add(nameLabel);
        
        l2 = new JLabel(" ");
        l2.setBounds(10, 173, 204, 51);
        panel_1.add(l2);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        lblNewLabel_4 = new JLabel("Difficulty Level :-");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_4.setBounds(10, 246, 178, 59);
        panel_1.add(lblNewLabel_4);
        
        l9 = new JLabel("New label");
        l9.setFont(new Font("Tahoma", Font.BOLD, 20));
        l9.setBounds(198, 246, 122, 59);
        panel_1.add(l9);
                        
        panel_3 = new Panel();
        panel_3.setBackground(new Color(220, 220, 220));
        panel_3.setBounds(379, 111, 894, 532);
        getContentPane().add(panel_3);
        panel_3.setLayout(null);
                        
        questionLabel = new JLabel();
        questionLabel.setBounds(10, 11, 874, 50);
        panel_3.add(questionLabel);
        questionLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                                
        optionButton1 = new JRadioButton();
        optionButton1.setBounds(10, 91, 370, 50);
        panel_3.add(optionButton1);
        optionGroup.add(optionButton1);
                                        
        optionButton2 = new JRadioButton();
        optionButton2.setBounds(510, 91, 370, 50);
        panel_3.add(optionButton2);
        optionGroup.add(optionButton2);
                                                
        optionButton3 = new JRadioButton();
        optionButton3.setBounds(10, 200, 370, 50);
        panel_3.add(optionButton3);
        optionGroup.add(optionButton3);
                                                        
        optionButton4 = new JRadioButton();
        optionButton4.setBounds(510, 200, 370, 50);
        panel_3.add(optionButton4);
        optionGroup.add(optionButton4);
                                                                
       previousButton = new JButton("Previous");
       previousButton.setFont(new Font("Tahoma", Font.BOLD, 30));
       previousButton.setBounds(29, 407, 201, 45);
       panel_3.add(previousButton);
                                                                        
        actionButton = new JButton("Next");
        actionButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        actionButton.setBounds(523, 409, 201, 45);
        panel_3.add(actionButton);
                                                                                
                                                                                
       actionButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                        processAction();
                     }
                       });
        previousButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                         showPreviousQuestion();
                        
                         
                      }
                         });

        // Display the first question
        currentQuestionIndex = 0;
        totalMarks = 0;
        timeCounter = 10 * 60; // Set the timer to 10 minutes (10 minutes * 60 seconds)

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeCounter--;
                updateTimeLabel();
                if (timeCounter <= 0) {
                    timer.stop();
                    processAction();
                }
            }
        });
        timer.start();

        displayQuestion(currentQuestionIndex);
    }

    private void fetchQuestionsFromDatabase() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
            String query = "SELECT * FROM question";
            PreparedStatement ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();

            // Get the total number of questions
            rs.last();
            int totalQuestions = rs.getRow();
            rs.beforeFirst();

            // Initialize the arrays to store questions, options, and correct answers
            questions = new String[totalQuestions];
            options = new String[totalQuestions][4];
            correctAnswers = new String[totalQuestions];
            levels = new String[totalQuestions];

            // Retrieve the questions, options, and correct answers from the database
            int index = 0;
            while (rs.next()) {
                String question = rs.getString("question");
                String option1 = rs.getString("option1");
                String option2 = rs.getString("option2");
                String option3 = rs.getString("option3");
                String option4 = rs.getString("option4");
                String correctAnswer = rs.getString("answer"); // Retrieve the correct answer
                String level = rs.getString("level");
                
                questions[index] = question;
                options[index][0] = option1;
                options[index][1] = option2;
                options[index][2] = option3;
                options[index][3] = option4;
                correctAnswers[index] = correctAnswer; // Store the correct answer
                levels[index] = level;
                index++;
            }

            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayQuestion(int index) {
    	l2.setText("Question No:-" + (index + 1));
    	l9.setText(levels[index]);
        questionLabel.setText(questions[index]);
        optionGroup.clearSelection();
        optionButton1.setText(options[index][0]);
        optionButton2.setText(options[index][1]);
        optionButton3.setText(options[index][2]);
        optionButton4.setText(options[index][3]);

        if (index == questions.length - 1) {
            actionButton.setText("Submit");
        } else {
            actionButton.setText("Next");
        }

        // Set the selected option if previously selected
        String selectedOption = getSelectedOption(index);
        if (!selectedOption.equals("")) {
            if (optionButton1.getText().equals(selectedOption)) {
                optionButton1.setSelected(true);
            } else if (optionButton2.getText().equals(selectedOption)) {
                optionButton2.setSelected(true);
            } else if (optionButton3.getText().equals(selectedOption)) {
                optionButton3.setSelected(true);
            } else if (optionButton4.getText().equals(selectedOption)) {
                optionButton4.setSelected(true);
            }
        }

        // Enable/disable previous button based on the current question index
        previousButton.setEnabled(index > 0);
    }

    private String getSelectedOption(int index) {
        if (optionButton1.isSelected()) {
            return optionButton1.getText();
        } else if (optionButton2.isSelected()) {
            return optionButton2.getText();
        } else if (optionButton3.isSelected()) {
            return optionButton3.getText();
        } else if (optionButton4.isSelected()) {
            return optionButton4.getText();
        }
        return "";
    }
   
    private void processAction() {
        String selectedAnswer = getSelectedOption(currentQuestionIndex);
        String correctAnswer = correctAnswers[currentQuestionIndex];
      if (selectedAnswer.equals(correctAnswer)) {
            String level = levels[currentQuestionIndex];
          
          
            switch (level) {
                case "Easy":
                    totalMarks= totalMarks + 1;
                    break;
                case "Medium":
                    totalMarks += 2;
                    break;
                case "Hard":
                    totalMarks += 5;
                    break;
                default:
                    break;
            }
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            displayQuestion(currentQuestionIndex);
        } else {
            timer.stop(); // Stop the timer when all questions are answered
            clearSelection(); // Clear all the radio button selections at the end
            submitQuiz();
        }
    }

    private void showPreviousQuestion() {
        currentQuestionIndex--;
        displayQuestion(currentQuestionIndex);
    }
    
    private void clearSelection() {
        optionGroup.clearSelection();
    }

    private void updateTimeLabel() {
        int minutes = timeCounter / 60;
        int seconds = timeCounter % 60;
        timeLabel.setText("Time Taken: " + minutes + " min " + seconds + " sec");
    }
    
    

    private void submitQuiz() {
        Showresult resultPage = new Showresult(totalMarks,name,rollNo);
        resultPage.setVisible(true);
        dispose(); // Close the current frame
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    quizExamStudent frame = new quizExamStudent("", "");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

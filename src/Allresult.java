import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Allresult extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel lblNewLabel_2;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Allresult frame = new Allresult();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Allresult() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 80, 1066, 590);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        scrollPane = new JScrollPane();
        scrollPane.setEnabled(false);
        scrollPane.setBounds(10, 113, 1032, 375);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setEnabled(false);
        scrollPane.setViewportView(table);
        table.setToolTipText("");
        table.setFont(new Font("Tahoma", Font.BOLD, 10));
        table.setBorder(new LineBorder(Color.BLUE, 3));
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Roll No", "Score" }));

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(0, 0, 68, 68);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\all student result.png"));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ALL STUDENT RESULT");
        lblNewLabel_1.setBounds(75, 0, 545, 68);
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 50));
        contentPane.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vipul Kumar\\eclipse-workspace\\Online Quiz\\pages background student.jpg"));
        lblNewLabel_2.setBounds(0, 0, 1052, 553);
        contentPane.add(lblNewLabel_2);

        fetchDataFromDatabase();
        customizeTableCellRenderer();
    }

    private void fetchDataFromDatabase() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vipul", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, rollNo, totalMarks FROM result");

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String rollNo = resultSet.getString("rollNo");
                int totalMarks = resultSet.getInt("totalMarks");

                model.addRow(new Object[] { name, rollNo, totalMarks });
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void customizeTableCellRenderer() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                if (column == 0) {
                    String text = "  " + value.toString(); // Add 2px space before the name
                    ((JLabel) component).setText(text);
                    ((JLabel) component).setHorizontalAlignment(JLabel.CENTER);
                }
                else if(column==1) {
                	String text = "  " + value.toString(); // Add 2px space before the name
                    ((JLabel) component).setText(text);
                }
                else if(column==2) {
                	String text = "  " + value.toString(); // Add 2px space before the name
                    ((JLabel) component).setText(text);
                }
                return component;
            }
        };

        table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table.getColumnModel().getColumn(1).setCellRenderer(renderer);
        table.getColumnModel().getColumn(2).setCellRenderer(renderer);
    }
}

import javax.swing.*;

public class CertificateFrame extends JFrame {
    public CertificateFrame(String certificateContent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        setTitle("Certificate");

        JLabel certificateLabel = new JLabel(certificateContent);
        certificateLabel.setBounds(10, 10, 380, 180);
        certificateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        certificateLabel.setVerticalAlignment(SwingConstants.CENTER);
        getContentPane().add(certificateLabel);
    }
}

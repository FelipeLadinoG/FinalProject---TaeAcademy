package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame {
    private JTextField userTextField;
    private JPasswordField passwordTextField;
    private JButton loginBtn;
    private JButton exitBtn;

    public LoginPanel() {
        setTitle("LOGIN");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("User:");
        userTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordTextField = new JPasswordField();
        loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(97, 221, 78));
        exitBtn = new JButton("Exit");
        exitBtn.setBackground(new Color(255, 102, 102));

        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        panel.add(loginBtn);
        panel.add(exitBtn);

        add(panel);
        setResizable(false);
    }

    public void setExitListener(ActionListener listener) {
        exitBtn.addActionListener(listener);
    }

    public void setLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }

    public void showView() {
        setVisible(true);
    }

    public String getUserText() {
        return userTextField.getText();
    }

    public String getPasswordText() {
        return passwordTextField.getText();
    }
}

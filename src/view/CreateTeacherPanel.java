package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateTeacherPanel extends JFrame{

    private JTextField userTextField;
    private JPasswordField passwordTextField;
    private JButton loginBtn;
    private JButton createBtn;

    public CreateTeacherPanel() {
        // Configurar la ventana
        setTitle("CREATE TEACHER");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(3, 2));


        JLabel userLabel = new JLabel("Name:");
        userTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Email:");
        passwordTextField = new JPasswordField();
        loginBtn = new JButton("Login");
        createBtn = new JButton("Create Teacher");

        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        panel.add(loginBtn);
        panel.add(createBtn);


        add(panel);
        setResizable(false);
    }

    public void setCreateListener(ActionListener listener) {
        createBtn.addActionListener(listener);
    }

    public void setLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }

    public void showView() {
        setVisible(true);
    }
}

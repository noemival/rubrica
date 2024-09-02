package view;
import javax.swing.*;

import foundation.AddressBookDb;
import model.AddressBook;

import model.Utent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
	private JFrame frame = new JFrame("Login");

	public LoginGUI(){

		this.frame.setSize(300, 150);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

		Utent utent = new Utent("noemi","1234");
		JLabel usernameLabel = new JLabel("Username");
        JTextField usernameField = new JTextField(); 
		panel.add(usernameLabel);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(); 
		passwordField.setEchoChar('*');
		panel.add(passwordLabel);
        panel.add(passwordField);


	    JButton loginButton = new JButton("Login");

	    loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (usernameField.getText().equals(utent.username)&& String.valueOf(passwordField.getPassword()).equals(utent.password) ) {
					AddressBookDb adDB= new AddressBookDb();
					AddressBook addressBook = adDB.loadDataDir();
					LoginGUI.this.frame.dispose();
					new AddressBookGUI(addressBook).show();

                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password");
                }
            }
        });
		panel.add(loginButton);
        frame.add(panel);
    }
 	public void show(){
		this.frame.setVisible(true);

 	}
}


package view;
import javax.swing.*;
import java.util.ArrayList;

import controller.AddressBookC;
import foundation.AddressBookDb;
import model.AddressBook;
import model.Person;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorFrame extends JFrame {     
    private AddressBookDb adDB=new AddressBookDb();
    private AddressBookC adC = new AddressBookC();
    private JFrame frame = new JFrame("Editor Frame");

    public EditorFrame(AddressBook addressBook, int index) {
        Person person = addressBook.getContact(index);
        
        this.frame.setTitle(person == null ? "Add Contact" : "Edit Contact");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(600, 400);
        this.frame.setLayout(new GridLayout(6, 2, 20, 20)); 
       
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(person == null ? "Insert name" : person.getName()); 

        JLabel surnLabel = new JLabel("Surname");
        JTextField surnField = new JTextField(person == null ? "Insert surname" : person.getSurname()); 

        JLabel telephoneLabel = new JLabel("Telephone");
        JTextField telephoneField = new JTextField(person == null ? "Insert telephone" : person.getTelephone()); 
        
        JLabel addressLabel = new JLabel("Address");
        JTextField addressField = new JTextField(person == null ? "Insert address" : person.getAddress()); 
        
        JLabel ageLabel = new JLabel("Age");
        JTextField ageField = new JTextField(person == null ? "Insert age" :  String.valueOf(person.getAge())); 
        JToolBar toolBar = new JToolBar();
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
      
        toolBar.add(cancelButton);
        toolBar.add(saveButton);
 
        toolBar.addSeparator();

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditorFrame.this.frame.dispose();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<String> data = new ArrayList<>();
                    data.add(nameField.getText());             
                    data.add(surnField.getText());          
                    data.add(addressField.getText());   
                    data.add(telephoneField.getText());       
                    data.add(ageField.getText());  
                
                    if (!adC.checkInsert(data)) {
                        throw new IllegalArgumentException("Invalid data input");
                    }
                
                    if (!adC.checkTelephone(telephoneField.getText())) {
                        throw new IllegalArgumentException("Invalid telephone number");
                    }
                
                    Person contact = new Person(data.get(0), data.get(1), data.get(2), data.get(3), Integer.parseInt(data.get(4)));
                
                    if (person != null) {
                        addressBook.modifyContact(index, contact);
                    } else {
                        addressBook.addContact(contact);
                    }
                
                    EditorFrame.this.adDB.saveDataDir(addressBook);
                    addressBook.fireTableDataChanged();
                    EditorFrame.this.frame.dispose();
                
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditorFrame.this.frame, "Insert valid age");
                
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(EditorFrame.this.frame, ex.getMessage());
                
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditorFrame.this.frame, "An unexpected error occurred: " + ex.getMessage());
                }

    }
});
        this.frame.add(nameLabel);
        this.frame.add(nameField);
        this.frame.add(surnLabel);
        this.frame.add(surnField);
        this.frame.add(addressLabel);
        this.frame.add(addressField);
        this.frame.add(telephoneLabel);
        this.frame.add(telephoneField);
        this.frame.add(ageLabel);
        this.frame.add(ageField);
        this.frame.add(saveButton);
        this.frame.add(cancelButton);
    
    }
    public void show(){
		this.frame.setVisible(true);

 	}
}
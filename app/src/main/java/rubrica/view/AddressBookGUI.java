package view;
import javax.swing.*;

import foundation.AddressBookDb;
import model.AddressBook;
import model.Person;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookGUI extends JFrame {
	private JFrame frame = new JFrame("Address Boook");

	public AddressBookGUI(AddressBook addressBook){
		AddressBookDb adDb=new AddressBookDb();

		this.frame.setSize(600, 400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        this.frame.setLayout(new BorderLayout());

       JTable table = new JTable(addressBook );
	   JScrollPane scrollpane = new JScrollPane(table);
	   this.frame.add(scrollpane,BorderLayout.CENTER);
	  
	   JToolBar toolBar = new JToolBar();

	   JButton deleteButton = new JButton("Delete");
	   JButton modifyButton = new JButton("Modify");
	   JButton addButton = new JButton("Add");

	   toolBar.add(deleteButton);
	   toolBar.add(modifyButton);
	   toolBar.add(addButton);

	   toolBar.addSeparator();
	   this.frame.add(toolBar, BorderLayout.NORTH);


	   deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
					Person contact =  addressBook.getContact(selectedRow);
					int response = JOptionPane.showConfirmDialog(
						AddressBookGUI.this.frame,
						"Do you want to delete " + contact.getName() + " " + contact.getSurname() + "?",
						"Confirm Delete",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE
					);
			
					if (response == JOptionPane.YES_OPTION) {
						System.out.print(selectedRow);	
						adDb.deleteFile(addressBook.getPeople().size());
						addressBook.deleteContact(selectedRow);
						adDb.saveDataDir(addressBook);
						addressBook.fireTableDataChanged();
					} else {
					}                

                } else {
                    JOptionPane.showMessageDialog(frame, "No row selected.");
                }
            }
        });

		modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {			

					new EditorFrame(addressBook,selectedRow).show();
                } else {
                    JOptionPane.showMessageDialog(frame, "No row selected.");
                }
            }
        });

		addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				new EditorFrame(addressBook,addressBook.getPeople().size()+1).show();
			}
        });



    }
 	public void show(){
		this.frame.setVisible(true);

 	}
}


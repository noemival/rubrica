package model;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class AddressBook extends AbstractTableModel {

    private Vector<Person> people = new Vector<>();
    private String[] columnNames = { "Name", "Surname", "Telephone" };

    public AddressBook(){

    }    
    
    public void addContact(Person person) {
        people.add(person);
    }

    public void modifyContact(int index, Person person) {
        if (index >= 0 && index < people.size()) {
            people.set(index, person);
        } else {
            System.out.println("Contatto non trovato.");
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < people.size()) {
            people.remove(index);
        } else {
            System.out.println("Contatto non trovato.");
        }
    }

    public void listContacts() {
        for (int i = 0; i < people.size(); i++) {
            System.out.println("Indice " + i + ": " + people.get(i).toString());
        }
    }

    public Person getContact(int index) {
        // Verifica se l'indice è valido
        if (index >= 0 && index < people.size()) {
            Person person = people.get(index);
            System.out.println("Person at index " + index + ": " + person);
            return person;
        } else {
            return null;
        }
    }
    public Vector<Person> getPeople() {
        return people;
    }


    // Restituisce il numero di righe (quanti oggetti ci sono)
    @Override
    public int getRowCount() {
        return people.size();
    }

    // Restituisce il numero di colonne (quante proprietà dell'oggetto vogliamo visualizzare)
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // Restituisce il nome della colonna
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = people.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.getName();
            case 1:
                return person.getSurname();
            case 2:
                return person.getTelephone();
            default:
                return null;
        }
    }
}



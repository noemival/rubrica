package model;
import java.util.*;


import javax.swing.table.AbstractTableModel;

public class AddressBook extends AbstractTableModel {

    private Vector<Person> people = new Vector<>();
    private String[] columnNames = { "Name", "Surname", "Telephone" };

    public AddressBook(){
    }    

    public Vector<Person> getPeople() {
        return this.people;
    }

    public void setPeople(Vector<Person> people) {
        this.people = people;
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
        if (index >= 0 && index < people.size()) {
            Person person = people.get(index);
            System.out.println("Person at index " + index + ": " + person);
            return person;
        } else {
            return null;
        }
    }
    public static void sortPeopleByOrderList(Vector<Person> people, List<Integer> orderList) {
        Map<Person, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < orderList.size(); i++) {
            if (i < people.size()) {
                positionMap.put(people.get(i), orderList.get(i));
            }
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int pos1 = positionMap.getOrDefault(p1, Integer.MAX_VALUE);
                int pos2 = positionMap.getOrDefault(p2, Integer.MAX_VALUE);
                return Integer.compare(pos1, pos2);
            }
        });
    }

    @Override
    public int getRowCount() {
        return people.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

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



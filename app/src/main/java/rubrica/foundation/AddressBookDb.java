package foundation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.util.Scanner;

import model.AddressBook;
import model.Person;

public class AddressBookDb {

    private static final String FILE_NAME = "./informazioni.txt";
    private static final String DIR_NAME = "./informazioni";
    File directory;
    public AddressBookDb(){        
        this.directory = new File(DIR_NAME);
        if (!this.directory.exists()) {
            this.directory.mkdir();
        }
    }

    public void saveData(AddressBook data) {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(FILE_NAME))) {
            for (Person dataPerson : data.getPeople()) {
                String parString= dataPerson.getName()+";"+dataPerson.getSurname()+";"+dataPerson.getAddress()+";"+dataPerson.getTelephone()+";"+ String.valueOf(dataPerson.getAge());   
                printStream.println(parString);
            }
            System.out.println("Saved succesfuly");
        } catch (FileNotFoundException e) {
            System.err.println("Error creation file: " + e.getMessage());
        }
    }
      
    public AddressBook loadData() {
        AddressBook addressBook = new AddressBook();       
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(";");
                    if (parts.length == 5) {
                        addressBook.addContact(new Person(parts[0], parts[1],parts[2],parts[3],Integer.parseInt(parts[4])));
                    }
            }
            System.out.println("Data loaded succesfully");
        } catch (FileNotFoundException e) {
            System.err.println("Error file not found:  " + e.getMessage());
        }
        return addressBook;
    }
    public void saveDataDir(AddressBook data) {
        int personN=1;
            for (Person dataPerson : data.getPeople()) {
                File file = new File(this.directory, "Person" + personN + ".txt");
                try (PrintStream printStream = new PrintStream(file)) {
                    String parString = dataPerson.getName() + ";" +
                                       dataPerson.getSurname() + ";" +
                                       dataPerson.getAddress() + ";" +
                                       dataPerson.getTelephone() + ";" +
                                       dataPerson.getAge();
                    printStream.println(parString);
                    personN++;
            System.out.println("Saved succesfuly");
        } catch (FileNotFoundException e) {
            System.err.println("Error creation file: " + e.getMessage());
        }
    }
    }
    public void deleteFile(int index) {
        File file = new File(DIR_NAME + "/Person" + index + ".txt");
       if(file.delete())
       {
           System.out.println("File deleted successfully");
       }
       else
       {
           System.out.println("Failed to delete the file");
       }
    }
      
    public AddressBook loadDataDir() {
        AddressBook addressBook = new AddressBook();       
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while(scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            String[] parts = line.split(";");
                            if (parts.length == 5) {
                                addressBook.addContact(new Person(parts[0], parts[1],parts[2],parts[3],Integer.parseInt(parts[4])));
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.err.println("Error file not found:  " + e.getMessage());
                    }
                }
            }           
        
        }
        return addressBook;

    }

}


 
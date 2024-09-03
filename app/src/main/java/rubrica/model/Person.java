package model;
public class Person {

    public int id;
    public String name;
    public String surname;
    public String address;
    public String telephone;
    public int age;

public Person(String name, String surname, String address, String telephone, int age){
    this.name = name;
    this.surname= surname;
    this.address=address;
    this.telephone=telephone;
    this.age=age;
}


public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getSurname() {
    return surname;
}

public void setSurname(String surname) {
    this.surname = surname;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getTelephone() {
    return telephone;
}

public void setTelephone(String telephone) {
    this.telephone = telephone;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}
// Metodo toString per rappresentazione testuale dell'oggetto
@Override
public String toString() {
    return "Person [Name=" + name + ", Surname=" + surname + ", Address=" + address +
           ", Telephone=" + telephone + ", Age=" + age + "]";
 }

}



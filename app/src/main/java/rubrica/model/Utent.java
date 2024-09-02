package model;

public class Utent{
    
    public String username;
    public String password;

public Utent(String username, String password){
    this.username = username;
    this.password= password;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

// Metodo toString per rappresentazione testuale dell'oggetto
@Override
public String toString() {
    return "Utent [Username=" + username + ", Password=" + password + "]";
 }

}



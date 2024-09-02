package controller;
import java.util.ArrayList;

public class AddressBookC {
    public AddressBookC(){

    }
    public boolean checkInsert(ArrayList<String> data){
        boolean bool= true;
        for (String string : data){
        if (string.startsWith("Insert ")) {
            bool= false;
        }else{ bool = true;}
    }
        return bool;
}
public boolean checkTelephone(String data){
    boolean bool= true;
    if (data.matches("\\d+")) {
        bool= true;
    } else {
        bool= false;
    }
    return bool;

}
}

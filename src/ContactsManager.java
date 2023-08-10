import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {

Input userInput = new Input();
 private Scanner scanner;
public ContactsManager(){
    this.scanner = new Scanner(System.in);
    System.out.println("1. View contacts\n2. Add a new contact.\n3. Search contact by name.\n4. Delete an existing contact\n5. Exit");
    int userMainMenuChoice = userInput.getInt("Enter an option (1,2,3,4,or 5):");
    if(userMainMenuChoice == 1){
        viewContacts();
    }
    if(userMainMenuChoice == 2){
        addContact();
    }

}
public static void viewContacts(){
Path contactsList = Paths.get("src/contacts.txt");
    List<String> contactList = null;
    try {
        contactList = Files.readAllLines(contactsList);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    for(int i=0; i< contactList.size();i++){
        System.out.println(contactList.get(i));
    }
}

    public static void main(String[] args) {
        ContactsManager newContacts = new ContactsManager();

    }

}

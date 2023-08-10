package src;

import util.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsManager {

    static Input userInput = new Input();
    private Scanner scanner;

    public ContactsManager() {
        this.scanner = new Scanner(System.in);
        System.out.println("1. View contacts\n2. Add a new contact.\n3. Search contact by name.\n4. Delete an existing contact\n5. Exit");
        int userMainMenuChoice = userInput.getInt("Enter an option (1,2,3,4,or 5):");
        if (userMainMenuChoice == 1) {
            viewContacts();
        }
        if (userMainMenuChoice == 2) {
            addContact();
        }
        if (userMainMenuChoice == 3) {
            searchContact();
        }
        if (userMainMenuChoice == 4) {
            deleteContact();
        }
    }

    public static void viewContacts() {
        Path contactsList = Paths.get("src/contacts.txt");
        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(contactsList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i));
        }
    }

    public static void addContact() {
        Path contactsList = Paths.get("src/contacts.txt");
        List<String> contacts = new ArrayList<>();
        try {
            String contactInfo = userInput.getString("Please input contact name and number");
            contacts.add(contactInfo);
            Files.write(contactsList, contacts, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchContact() {
        Path contactsListPath = Paths.get("src/contacts.txt");
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsListPath);
            String searchContactInfo = userInput.getString("Please input contact name");

            for (String line : contactsList) {
                if (line.toLowerCase().contains(searchContactInfo)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void deleteContact() {
        Path contactsListPath = Paths.get("src/contacts.txt");
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsListPath);
        String searchContactInfo = userInput.getString("Please input contact name to delete.").toLowerCase();
        List<String> updatedContacts = new ArrayList<>();
        for(String line : contactsList){
            if(!line.toLowerCase().contains(searchContactInfo)){
                updatedContacts.add(line);
                userInput.yesNo("Are you sure you want to delete? " + searchContactInfo);
            }
        }
        Files.write(contactsListPath, updatedContacts, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//            String deleteContact = "";
//            for (String line : contactsList) {
//                if (line.toLowerCase().contains(searchContactInfo)) {
//                    userInput.yesNo("Are you sure you want to delete" + line);
//                    if(true){
//                        deleteContact = line.replace(line, "");
//                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/contacts.txt"))) {
//                            writer.write(line);
//                            writer.newLine();
//                        } catch(IOException e){
//                            throw new RuntimeException (e);
//                        }
//
//                    } else {
//                        System.out.println("ok");
//
//                    }
//                }
//            }
        }


    public static void main(String[] args) {
        ContactsManager newContacts = new ContactsManager();

    }

}

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

    public static void returnToMain() {
        boolean userConfirmMenu = userInput.yesNo("Would you like to return to the main menu? (y/n)");
        if (userConfirmMenu == true) {
            ContactsManager returnToMenu = new ContactsManager();
        } else {
            System.out.println("Bye!");
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
        returnToMain();

    }

    private static String formatContactNumber(int number) {
        String contactNumber = String.valueOf(number);
        return contactNumber.substring(0, 3) + "-" + contactNumber.substring(3, 6) + "-" + contactNumber.substring(6);

    }

    private static boolean isValidContactNumber(int number) {
        String contactNumber = String.valueOf(number);
        return contactNumber.length() == 10;
    }

    public static void addContact() {
        Path contactsList = Paths.get("src/contacts.txt");
        List<String> contacts = new ArrayList<>();
        try {
            String contactName = userInput.getString("Please input contact name");
            int contactNumber;
while(true) {
    contactNumber = userInput.getInt("Please input 10-digit contact number");
    if (isValidContactNumber(contactNumber)) {
        break;
    } else {
        System.out.println("Contact number should have exactly 10 digits.");
    }
}
            String formattedContactNumber = formatContactNumber(contactNumber);
            String contactInfo = String.format("%-10s | %-15s\n", contactName, formattedContactNumber);

//            String contactInfo = String.format("%-10s | %-10s\n", contactName, contactNumber.substring(0,3) + "-" +contactNumber.substring(3,6)+ "-" + contactNumber.substring(6));
            contacts.add(contactInfo);

            Files.write(contactsList, contacts, StandardOpenOption.APPEND);
            viewContacts();
//            returnToMain();
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
            returnToMain();
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
            boolean foundContact = false;

            for (String line : contactsList) {
                if (!line.toLowerCase().contains(searchContactInfo)) {
                    updatedContacts.add(line);
                } else {
                    foundContact = true;
                }
            }

            if (foundContact) {
                boolean userConfirmDelete = userInput.yesNo("Are you sure you want to delete? " + searchContactInfo);
                if (userConfirmDelete == true) {
                    Files.write(contactsListPath, updatedContacts, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                    System.out.println("Contact deleted.");
//                    returnToMain();

                } else {
                    System.out.println("Deletion canceled.");
                    returnToMain();
                }
            } else {
                System.out.println("There is no contact with that name");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        ContactsManager newContacts = new ContactsManager();

    }

}

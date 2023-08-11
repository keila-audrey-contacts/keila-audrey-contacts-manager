package manage;

import util.CallAFriend;
import util.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static util.CallAFriend.callingFriend;

public class ContactsManager {

    static Input userInput = new Input();
    private Scanner scanner;

    public ContactsManager() {
        this.scanner = new Scanner(System.in);
        System.out.println("1. View contacts\n2. Add a new contact.\n3. Search contact by name.\n4. Delete an existing contact\n5. Call a friend \n6. Exit");
        int userMainMenuChoice = userInput.getInt("Enter an option (1,2,3,4,5, or 6):");
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
        if(userMainMenuChoice == 5){
            callAFriend();
        }
        if(userMainMenuChoice == 6){
            exitContactsApp();
        }
    }

    public static void returnToMain() {
        boolean userConfirmMenu = userInput.yesNo("Would you like to return to the main menu? (y/n)");
        if (userConfirmMenu == true) {
            ContactsManager returnToMenu = new ContactsManager();
        } else {
            exitContactsApp();
        }
    }

    public static void viewContacts() {
        Path contactsList = Paths.get("manage/contacts.txt");
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

    private static String formatContactNumber(long number) {
        String contactNumber = String.valueOf(number);
        return contactNumber.substring(0, 3) + "-" + contactNumber.substring(3, 6) + "-" + contactNumber.substring(6);

    }

    private static boolean isValidContactNumber(long number) {
        String contactNumber = String.valueOf(number);
        return contactNumber.length() == 10;
    }

    public static void addContact() {
        Path contactsList = Paths.get("manage/contacts.txt");
        List<String> contacts = new ArrayList<>();
        try {
            String contactName = userInput.getString("Please input contact name");
            long contactNumber;
            while (true) {
                contactNumber = userInput.getLong("Please input 10-digit contact number");
                if (isValidContactNumber(contactNumber)) {
                    break;
                } else {
                    System.out.println("Contact number should have exactly 10 digits.");
                }
            }
            String formattedContactNumber = formatContactNumber(contactNumber);
            String contactInfo = String.format("%-10s | %-15s\n", contactName, formattedContactNumber);

            contacts.add(contactInfo);

            Files.write(contactsList, contacts, StandardOpenOption.APPEND);
            viewContacts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchContact() {
        Path contactsListPath = Paths.get("manage/contacts.txt");
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsListPath);
            String searchContactInfo = userInput.getString("Please input contact name");
            boolean didNotFindContact = false;
            for (String line : contactsList) {
                if (line.toLowerCase().contains(searchContactInfo)) {
                    System.out.println(line);
                    returnToMain();
                } else {
                    didNotFindContact = true;
                }
            }
            if (didNotFindContact) {
                System.out.println("Could not find contact with that name.");
                searchContact();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteContact() {
        Path contactsListPath = Paths.get("manage/contacts.txt");
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
                    viewContacts();
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
        exitContactsApp();
    }


    public static void callAFriend(){
        String whoToCall = userInput.getString("Who would you like to call?");
        System.out.printf("Calling %s%n", whoToCall);
        System.out.println("""
                                                .
                     .              .   .'.     \\   /
                   \\   /      .'. .' '.'   '  -=  o  =-
                 -=  o  =-  .'   '              / | \\
                   / | \\                          |
                     |                            |
                     |                            |
                     |                      .=====|
                     |=====.                |.---.|
                     |.---.|                ||=o=||
                     ||=o=||                ||   ||
                     ||   ||                ||   ||
                     ||   ||                ||___||
                     ||___||                |[:::]|
                jgs  |[:::]|                '-----'
                     '-----'
                
                """);
        System.out.println("\n****RING RING****\n");
        CallAFriend callContact = new CallAFriend();
        callingFriend();
    }

    public static void exitContactsApp(){
        System.out.println("""
                    .-'~~~-.          88                                 \s
                   .'o  oOOOo`.       88                                 \s 
                  :~~~-.oOo   o`.     88                                 \s
                   `. \\ ~-.  oOOo.    88,dPPYba,  8b       d8  ,adPPYba, \s 
                     `.; / ~.  OO:    88P'    "8a `8b     d8' a8P_____ 88 \s
                     .'  ;-- `.o.'    88       d8  `8b   d8'  8PP""\"""\""s
                    ,'  ; ~~--'~      88b,   ,a8"   `8b,d8'   "8b,   ,aa \s
                    ;  ;              8Y"Ybbd8"'      Y88'     `"Ybbd8"' \s
                _\\\\;_\\\\//________________.__..-'__    d8'_`.__.'____`....'`..____.'_`._.'____
                ==------===========--------========- d8'   \s=====-------------===--------=======
                """);
        System.exit(0);
    }



}

package util;

import java.util.Scanner;

public class CallAFriend {
    public static void callingFriend() {
        Scanner scanner = new Scanner(System.in);
//
//# Java Control Structures and Loops Bonuses
//
//### Simple Chat Bot
//
//        Be creative in communicating with your
//        user different options and for given scenerios. Create at three phases of the chat, for example...
//
//        "How are you?" (AI says)
//			           |                              |
//        good                        bad (user types)
//
//        "Awesome! Are you super happy?" 	    "Will cake make you better?"
//
//        yes          no                     yes             no
//
//        Keep the chat options relatively simple and plan it out clearly before coding it.

        System.out.println("How are you lil bean burrito (:? (Good / Bad)?");
        String userResponse = scanner.next();
        while(userResponse.equalsIgnoreCase("good")){
            System.out.println("CHOICE bruh samesies! Do you like really nice cupcakes? (Yes/No)");
            String userCupcakeReply = scanner.next();
            if(userCupcakeReply.equalsIgnoreCase("yes")){
                System.out.println("OKURR we have like.. SO MUCH in common! Are we like.. besties now? (Yes/No)");
                String userBestieReply = scanner.next();
                if(userBestieReply.equalsIgnoreCase("yes")){
                    System.out.println("i love you (: c u l8r sk8r \n *kisses your forehead and gives you a rock that looks like a cupcake*");
                    break;
                } else if (userBestieReply.equalsIgnoreCase("no")) {
                    System.out.println("fine... My feelings aren't hurt ): \n *cries in binary and throws rock that looks like a cupcake on the ground* c u l8r h8r");
                    break;
                } else {
                    System.out.println("that wasn't a response I understand sooo... baiiii!:P \n *throws spinach and cheese frittata*");
                    break;
                }
            } else if (userCupcakeReply.equalsIgnoreCase("no")) {
                System.out.println("wow ok. cupcake h8r? das weird... I don't think we can talk.. \n *eats your wallet and logs off*");
                break;
            }else {
                System.out.println("idk whut you just said so Ima head out :S  \n *glitterbombs the room and exits* ");
                break;
            }
        }
        while(userResponse.equalsIgnoreCase("bad")){
            System.out.println("Aw sorry bud :/ ... did you want a high five maybe? (Yes/No)");
            String userHighFive = scanner.next();
            if(userHighFive.equalsIgnoreCase("yes")){
                System.out.println("YAY! *high fives* I hope ur day becomes supercalifragilisticexpialodocious! Can we be friends? (Yes/No) (:");
                String userFriendOrNah = scanner.next();
                if(userFriendOrNah.equalsIgnoreCase("yes")){
                    System.out.println("AW YAH! I'll call you l8r g8r c: \n *viking yells and rappels down building onto flying dutchman*");
                    break;
                } else if (userFriendOrNah.equalsIgnoreCase("no")) {
                    System.out.println("das kinda rude. i mean i gave u a high five n errything.. :{( you look like a nerd anyway \n *rides off on large white stallion into grand canyon*");
                    break;
                } else {
                    System.out.println("that wasn't an expected response to my very valid question, n i don't have time \n *gets on pet goose and waddles away with a go-gurt*");
                    break;
                }
            } else if (userHighFive.equalsIgnoreCase("no")) {
                System.out.println("o. oki... didn't wanna give you anyway ): \n *walks off into sunset with fabio and 3 quesaritos*");
                break;
            }else {
                System.out.println("i dunno what that means :> \n *gets on canoe and rows furiously away*");
                break;
            }
        }


//
//### Word Guessing Game
//
//                - prompt a player to enter a word
//        - use a loop to print out several empty lines to hide the answer
//        - allow the user to guess the letters in the word
//                - track the number of letter guesses
//                - display to the user the partially completed word for each correctly guessed character
//        - before prompting the user to guess a letter, give them the option to solve the word
//                - limit the number of guesses based on the length of the word for an extra challenge!



    }

}

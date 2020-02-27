package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    static public void validatePhoneNumber() {
        System.out.println("\nPhone numbers (valid for numbers having total digits from 7 - 14)----------------------\n");

        String[] phoneNumbers = {
                "08-12 34 56",
                "040-123 45",
                "0704-12 34 56",
                "0707321654",
                "0707 555 666",
                "070-7321654",
                "073-860 43 12",
                "073-86 04312",
                "0-7-4-5-6-7-6",
                "0091-964533632767898",
                "0091-94-26880777" // Indian number with country code(14 digits)
        };
       // Pattern pattern = Pattern.compile("^(\\d[\\s-]?){10}$|^(\\d[\\s-]?){8}$|^(\\d[\\s-]?){12}$|^(\\d[\\s-]?){14}$");
        Pattern pattern = Pattern.compile("^(\\d[\\s-]?){7,14}$");

        for (String s : phoneNumbers) {
            Matcher m = pattern.matcher(s);
            System.out.println(s + " ------ " + (m.matches() ? "Valid" : "Invalid"));

        }
    }

    static public void validateEmail() {
        System.out.println("\nEmails----------------------------------------------------------------\n");

        String[] email = {
                "snehal.patel@gmail.com",
                "bhav.pa@axis.se",
                "sneh@gmail.co.in",
                "sl@st.eu",
                "sneh.kath@hotmail.c"
        };

        Pattern pattern = Pattern.compile("^(.{2,})@(.{2,})\\.([A-Za-z]{2,})$");
        for (String s : email) {
            Matcher m = pattern.matcher(s);
            System.out.println(s + " ------ " + (m.matches() ? "Valid" : "Invalid"));
        }
    }

    static public void validateBirthDate() {
        System.out.println("\nBirth dates----------------------------------------------------------\n");
        String[] birthdates = {
                "1990-08-21 1234",
                "9008211234",
                "900821-1234",
                "1918-09-22 2345",
                "180922+2345",
                "90-08-02 4321",
                "90-08-03-4353",
                "900821-342",
                "900821-32"
        };


        Pattern pattern = Pattern.compile("^(\\d{2}[\\s-]?|\\d{4}[\\s-]?)\\d{2}[\\s-]?\\d{2}[\\s-+]?\\d{4}$");

        for (String s : birthdates) {
            Matcher m = pattern.matcher(s);
            System.out.println(s + "------ " + (m.matches() ? "Valid" : "Invalid"));
        }
    }

    public static void removeNumbers() {
        System.out.println("\nRemove numbers from the String-----------------------------------------\n");
        String string = "hej\n" +
                "hejsan1\n" +
                "\n" +
                "hall100å\n" +
                "what's up";

        System.out.println(string.replaceAll("[\\d]+", ""));
    }

    public static void removeSpacesFromTheString() {
        System.out.println("\n-------------------------------------------------------------------------\n");

        String s = "hej      på  dig\n" +
                "   hejsan\n" +
                " hej      \n" +
                "     hej    hej";
        String[] strings = s.split("\n");
        for (String string : strings) {
            String newString = string.trim()
                                     .replaceAll(" +", " ");
            System.out.println(newString);

        }

    }

    public static void validatePasswords() {
        System.out.println("\nPassword--------------------------------------------------------------\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter password");
        String password = input.nextLine();

        Pattern pattern = Pattern.compile("(?=.{8,})(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[\\W])\\S*");
        Matcher m = pattern.matcher(password);
        System.out.println("Your password is : " + (m.matches() ? "Valid" : "Invalid"));

    }
}

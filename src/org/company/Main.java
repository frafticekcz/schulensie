package org.company;

import org.company.accountManager.AccountManager;

import java.util.Scanner;

public class Main {

    private static AccountManager accountManager;

    public static void main(String[] args) {
        accountManager = new AccountManager();
        getLoginScreenInput();
    }

    public static void getLoginScreenInput()
    {
        writeLines();
        System.out.println("[1] - Login");
        System.out.println("[2] - Register");
        System.out.println("[3] - Quit");
        System.out.println(" ");
        System.out.println("Choose your option!");
        Scanner sc = new Scanner(System.in);
        try
        {
            int input =  sc.nextInt();
            switch (input)
            {
                case 1:
                    accountManager.startLogin();
                    break;
                case 2:
                    accountManager.getRegistrationCode();
                    break;
                case 3:
                    quit();
                    break;
                default:
                    System.out.println("Wrong input!");
                    try {
                        Thread.sleep(2000);
                        getLoginScreenInput();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
        } catch (NumberFormatException e)
        {
            System.out.println("Wrong input!");
            try {
                Thread.sleep(2000);
                getLoginScreenInput();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void getMainScreeninput()
    {
        writeLines();
        System.out.println("Info:");
        System.out.println("Name: " + accountManager.currentLoggedAccount.getFirstName() + " " + accountManager.currentLoggedAccount.getLastName());
        System.out.println("Group: " + accountManager.currentLoggedAccount.getGroup().name());
        System.out.println(" ");
        System.out.println("[1] - TODO");
        System.out.println(" ");
        System.out.println("Choose your option!");
        Scanner sc = new Scanner(System.in);
        try
        {
            int input =  sc.nextInt();
            switch (input)
            {
                case 1:
                    break;
                case 2:
                    accountManager.getRegistrationCode();
                    break;
                case 3:
                    quit();
                    break;
                default:
                    System.out.println("Wrong input!");
                    try {
                        Thread.sleep(2000);
                        getLoginScreenInput();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
        } catch (NumberFormatException e)
        {
            System.out.println("Wrong input!");
            try {
                Thread.sleep(2000);
                getLoginScreenInput();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void writeLines()
    {
        for (int i = 0; i < 50; i++)
            System.out.println(" ");
    }

    public static void quit()
    {
        System.exit(0);
    }

}

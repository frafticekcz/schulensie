package org.company.accountManager;

import org.company.Main;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class AccountManager {

    protected HashMap<String, Account> accounts = new HashMap<>();
    protected HashMap<Integer, Group> registrationCodes = new HashMap<>();

    public Account currentLoggedAccount;

    public AccountManager() {
        getRegistrationCodes();
    }

    public void getRegistrationCodes()
    {
        File file = new File("R:\\soukrome\\Intellij\\schulensie\\src\\org\\company\\files/RegCodes.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext())
            {
                String[] doubles = sc.next().split(";");
                for (String doub : doubles)
                {
                    String group = doub.split(",")[1];
                    int code = Integer.parseInt(doub.split(",")[0]);
                    registrationCodes.put(code, Group.toGroup(group));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void registerAccount(String nickname, String firstName, String lastName, Group group, String password)
    {
        Account account = new Account(nickname, firstName, lastName, group, password);
        accounts.put(nickname, account);
        System.out.println("Account registered!");
        try {
            Thread.sleep(2000);
            Main.getLoginScreenInput();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void getRegistrationCode()
    {
        Main.writeLines();
        System.out.println("Write your registration code");
        Scanner sc = new Scanner(System.in);
        try {
            int number = sc.nextInt();
            if (registrationCodes.containsKey(number))
            {
                startRegister(registrationCodes.get(number), number);
            }
            else
            {
                System.out.println("Wrong registration code!");
                try {
                    Thread.sleep(2000);
                    Main.getLoginScreenInput();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Wrong registration code!");
            try {
                Thread.sleep(2000);
                Main.getLoginScreenInput();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void startRegister(Group group, int regCode)
    {
        System.out.println("Write your first name");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Write your last name");
        String lastName = sc.next();
        System.out.println("Write your nickname");
        String nickname = sc.next();
        System.out.println("Write your password");
        String password = sc.next();
        registerAccount(nickname, name, lastName, group, password);
        registrationCodes.remove(regCode);
    }

    public void startLogin()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your nickname");
        String nickname = sc.next();
        System.out.println("Write your password");
        String password = sc.next();
        if (accounts.containsKey(nickname))
        {
            Account acc = accounts.get(nickname);
            String pass = acc.getPassword();
            if (pass.equals(password))
            {
                System.out.println("Logged in!");
                currentLoggedAccount = acc;
                try {
                    Thread.sleep(2000);
                    Main.getMainScreeninput();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            else
            {
                System.out.println("Wrong login!");
                try {
                    Thread.sleep(2000);
                    Main.getLoginScreenInput();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("Wrong login!");
            try {
                Thread.sleep(2000);
                Main.getLoginScreenInput();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}

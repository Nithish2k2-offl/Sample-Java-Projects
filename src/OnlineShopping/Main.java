package OnlineShopping;

import java.util.*;

public class Main {
    static int id = 1;
    static String str, struser;

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        mainmenu();
    }

    static void mainmenu() {
        System.out.println("Buyer or seller?..(b or s)");
        struser = s.next();
        System.out.println("Login or signup?...(l or s)");
        str = s.next();
        checkActivity(struser, str);
    }

    static void checkActivity(String struser, String str) {
        if (struser.equals("b") && str.equals("l"))
            login(0);
        else if (struser.equals("b") && str.equals("s"))
            signup(0);
        else if (struser.equals("s") && str.equals("l"))
            login(1);
        else if (struser.equals("s") && str.equals("s"))
            signup(1);
    }

    static void signup(int x) {

        String name, email, password;
        if (x == 0) {
            System.out.println("hey buyer...");
            System.out.println("Enter your name");
            name = s.next();
            System.out.println("Enter email");
            email = s.next();
            System.out.println("Enter password");
            password = s.next();
            Buyer.buyers.add(new Buyer(name, id++, new HashMap<>(), email, password));
            System.out.println("----------------------new user created !!");
            mainmenu();

            System.out.println("continue? y or n 1. login 2. signup 3. end 4. printdetails");
            switch (s.nextInt()) {
                case 1:
                    login(0);
                    break;
                case 2:
                    signup(0);
                    break;
                case 4:
                    printdetails();
                    break;
                default:
                    System.exit(0);
            }
        } else {
            System.out.println("hey seller");
            System.out.println("Enter your name");
            name = s.next();
            System.out.println("Enter email");
            email = s.next();
            System.out.println("Enter password");
            password = s.next();
            Seller.sellers.add(new Seller(email, password, name));
            System.out.println("----------------------new seller created !!");
            mainmenu();

            System.out.println("continue? y or n 1. login 2. signup 3. end 4. printdetails");
            switch (s.nextInt()) {
                case 1:
                    login(1);
                    break;
                case 2:
                    signup(1);
                    break;
                case 4:
                    printdetails();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    static void login(int x) {
        boolean temp = false;
        String email, password;
        if (x == 0) { // for buyer login
            if (Buyer.buyers.isEmpty()) {
                System.out.println("list empty... add users");
                signup(0);
            } else {
                System.out.println("Enter email...");
                email = s.next();
                System.out.println("Enter password...");
                password = s.next();
                for (Buyer b : Buyer.buyers) {
                    if (b.getEmail().equals(email) && b.getPassword().equals(password)) {
                        System.out.println("Login successfull");
                        temp = true;
                        Buyer.buyermenu(b, b.hm);
                    }
                }
                if (!temp) {
                    System.out.println("try again");
                    login(0);
                }
            }
        } else // if seller login
        {
            if (Seller.sellers.isEmpty()) {
                System.out.println("list is empty...add sellers");
                signup(1);
            } else {
                System.out.println("Enter email...");
                email = s.next();
                System.out.println("Enter password...");
                password = s.next();
                for (Seller s : Seller.sellers) {
                    if (s.getEmail().equals(email) && s.getPassword().equals(password)) {
                        System.out.println("Login successfull");
                        temp = true;
                        Seller.sellerMenu(s);
                    }
                }
                if (!temp) {
                    System.out.println("try again");
                    login(1);
                }
            }

        }
    }

    static void printdetails() {
        System.out.println("hey");
        System.out.println("buyers..");
        for (Buyer b : Buyer.buyers) {
            System.out.println();
            System.out.print(
                    b.getId() + " " + b.getName() + " " + b.getEmail() + " " + b.getPassword() + " " + b.hm);
        }
        System.out.println();
        System.out.println("Sellers...");
        for (Seller s : Seller.sellers) {
            System.out.print(s.getName() + " " + s.getEmail() + " " + s.getPassword());
            System.out.println();
        }
        System.out.println();
        mainmenu();
    }
}
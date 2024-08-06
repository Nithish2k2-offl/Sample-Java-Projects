package OnlineShopping;

import java.util.*;

public class Buyer {
    String name;
    HashMap<String, Integer> hm;
    String email, password;
    int id;

    static int input;
    static String prodname;
    static int quantity;

    static List<Buyer> buyers = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getHm() {
        return hm;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public Buyer(String name, int id, HashMap<String, Integer> hm, String email, String password) {
        this.name = name;
        this.hm = hm;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public static void buyermenu(Buyer b, HashMap<String, Integer> hm) {
        System.out.println();
        System.out.println("1. list cart \n2. makepayment\n3.buy item\n4.add to cart\n5. back\n6.List inventory");
        input = s.nextInt();
        switch (input) {
            case 1:
                listCart(hm);
                buyermenu(b, hm);
                break;
            case 2:
                makePayment();
                break;
            case 3:
                buyItem();
                break;
            case 4:
                addToCart(hm);
                buyermenu(b, hm);
                break;
            case 5:
                Main.mainmenu();
                break;
            case 6:
                listInventory();
                buyermenu(b, hm);
                break;
        }
    }

    static void listInventory() {
        System.out.println();
        for (Map.Entry<String, Integer> x : Products.inventory.entrySet()) {
            System.out.print(x.getKey() + " " + x.getValue());
            System.out.println();
        }
    }

    private static void addToCart(HashMap<String, Integer> hm) {
        System.out.println("Enter the name of the product...");
        prodname = s.next();
        System.out.println("Enter the quantity");
        quantity = s.nextInt();
        hm.put(prodname,quantity);
    }

    private static void buyItem() {
    }

    private static void makePayment() {
    }

    static void listCart(HashMap<String, Integer> hm) {
        if (hm.isEmpty())
            System.out.println("Cart is empty... add products");
        else {
            // for (Map.Entry<String, Integer> x : Products.inventory.entrySet()) {
            //     System.out.println();
            //     System.out.println(x.getKey() + " " + x.getValue());
            // }
            System.out.println(hm);
        }
        System.out.println();
    }
}

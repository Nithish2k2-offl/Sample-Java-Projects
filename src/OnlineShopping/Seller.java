package OnlineShopping;

import java.util.*;

public class Seller extends Products {
    static List<Seller> sellers = new ArrayList<>();

    String email, password, name;
    static int input;
    static Scanner sc = new Scanner(System.in);

    static int quantity;
    static String productName;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Seller(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static void sellerMenu(Seller s) {
        System.out.println("-------------");
        System.out.println("1.add an Item 2. Update an Item 3. List inventory 4. back");
        input = sc.nextInt();

        switch (input) {
            case 1:
                addItem(s);
                break;
            case 2:
                updateItem(s);
                break;
            case 3:
                listInventory();
                break;
            case 4:
                Main.mainmenu();
                break;
        }
    }

    static void listInventory() {
        System.out.println();

        // for (Map.Entry<String, Integer> x : Products.inventory.entrySet()) {
        //     System.out.print(x.getKey() + " " + x.getValue());
        //     System.out.println();
        // }
        System.out.println(inventory);
        Main.mainmenu();
    }

    static void addItem(Seller s) {
        System.out.println("Enter the name of the product");
        sc.nextLine();
        productName = sc.nextLine();
        System.out.println("Enter quantity");
        quantity = sc.nextInt();

        Products.inventory.put(productName, quantity);
        System.out.println("---------added");
        sellerMenu(s);
    }

    static void updateItem(Seller s) {
        System.out.println("enter the name of the item to be updated...");
        productName = sc.nextLine();
        sc.nextLine();
        if (Products.inventory.containsKey(productName)) {
            System.out.println(("Enter new name and price"));
            productName = sc.nextLine();
            quantity = sc.nextInt();
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.containsKey(productName)) {
                    inventory.replace(productName, quantity);
                    System.out.println("------item successfully updated");
                    sellerMenu(s);
                }
            }
        } else {
            System.out.println("product not found...enter correct details..");
            updateItem(s);
        }
    }
}

import java.util.*;

public class Cart {
    final static Scanner s = new Scanner(System.in);
    static int choice;
    static List<String> itemsList = new ArrayList<>(), commentList = new ArrayList<>();
    static List<Integer> priceList = new ArrayList<>(), likes = new ArrayList<>();
    static String itemName;
    static int price;
    static String choiceYes, comment;

    public static void main(String[] args) {
        System.out.println("------------------\n WELCOME TO CART\n");
        displayMenu();
    }

    static void displayMenu() {
        do {
            try {
                System.out.println(
                        "1. Add Items 2. Remove Items 3. Display Cart Items \n\n4. Likes     5. Comment      6. Edit Comment");
                choice = s.nextInt();

                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        if (itemsList.isEmpty()) {
                            System.out.println("Cart is empty , add elements");
                        } else {
                            System.out.println("Delete the name of item to remove");
                            itemName = s.next();
                            deleteItem(itemName);
                            break;
                        }
                    case 3:
                        displayCart();
                        if (itemsList.isEmpty()) {
                            System.out.println("Cart is empty , add elements");
                        }
                        break;
                    case 4:
                        System.out.println("Enter the name of item to be liked ");
                        itemName = s.next();
                        likeItem(itemName);
                        break;
                    case 5:
                        System.out.println("Enter the name of item to comment ");
                        itemName = s.next();
                        s.nextLine();
                        System.out.println("Enter the comment");
                        comment = s.nextLine();
                        commentItem(itemName, comment);
                        break;
                    case 6:
                        System.out.println("Enter the price of the item");
                        price = s.nextInt();
                        s.nextLine();
                        if (checkPrice(price) > 1) {
                            System.out.println("Enter the name of item");
                            itemName = s.next();
                            s.nextLine();
                            System.out.println("Give the edited comment");
                            comment = s.nextLine();
                            commentEdit(itemName, comment);
                        } else {
                            System.out.println("Give the edited comment");
                            comment = s.nextLine();
                            commentEdit(price, comment);
                        }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                s.nextLine(); // Clear the input buffer
            }
            System.out.println("\nYou wanna continue (yes or no) : ");
            choiceYes = s.next();

        } while (choiceYes.equalsIgnoreCase("yes"));
        System.out.println("Have a good day");

    }

    static int checkPrice(int price) {
        int count = 0;
        for (int x : priceList) {
            if (price == x)
                ++count;
        }
        return count;
    }

    static void displayCart() {
        for (String o : itemsList) {
            System.out.println(
                    o + " Rs." + priceList.get(itemsList.indexOf(o)) + " Likes:" + likes.get(itemsList.indexOf(o))
                            + " Comments:" + commentList.get(itemsList.indexOf(o)));
        }
    }

    static void deleteItem(String itemName) {
        priceList.remove(itemsList.indexOf(itemName));
        commentList.remove(itemsList.indexOf(itemName));
        likes.remove(itemsList.indexOf(itemName));
        itemsList.remove(itemName); // removing the item from the itemList first would affect the priceList,
        // commentList, likesList. (Because the item is deleted first, so the price,
        // comment, likes for the item is not accessible, hence error occurs).
    }

    static void addItem() {
        System.out.println("Enter the item name and price");
        itemName = s.next();
        price = s.nextInt();
        itemsList.add(itemName);
        priceList.add(price);
        likes.add(0);
        commentList.add(null);
    }

    static void likeItem(String itemName) {
        if (likes.indexOf(itemsList.indexOf(itemName)) == 1) {
            System.out.println("An user can only like once !!");
        } else
            likes.set(itemsList.indexOf(itemName), 1);
    }

    static void commentItem(String itemName, String comment) {
        commentList.set(itemsList.indexOf(itemName), comment);
    }

    static void commentEdit(String itemName, String comment) {
        commentList.set(itemsList.indexOf(itemName), comment);
    }

    static void commentEdit(int price, String comment) {
        commentList.set(priceList.indexOf(price), comment);
    }
}

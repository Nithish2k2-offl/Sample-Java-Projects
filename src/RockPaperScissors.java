import java.util.*;

/**
 * RockPaperScissors
 */
public class RockPaperScissors {
    static Scanner s = new Scanner(System.in);
    static String usersChoice, choice1, choice2;
    static Random rand = new Random();
    static int matches, userScore = 0, systemScore = 0;

    public static void main(String[] args) {
        displayMain();
        gamePlay();
    }

    static void gamePlay() {
        int i = 1;

        do {
            choice1 = getInput();
            choice2 = getInput(1);

            if (choice1.equalsIgnoreCase("rock")) {
                switch (choice2) {
                    case "paper":
                        ++systemScore;
                        break;
                    case "scissors":
                        ++userScore;
                        break;
                }
            } else if (choice1.equalsIgnoreCase("paper")) {
                switch (choice2) {
                    case "scissors":
                        ++systemScore;
                        break;
                    case "rock":
                        ++userScore;
                        break;
                }
            } else if (choice1.equalsIgnoreCase("scissors")) {
                switch (choice2) {
                    case "paper":
                        ++userScore;
                        break;
                    case "rock":
                        ++systemScore;
                        break;
                }
            }
            ++i;

        } while (i <= matches);
        if (userScore > systemScore) {
            System.out.println("User won !!!");
            if (playAgain()) {
                gamePlay();
            }
        } else {
            System.out.println("The Computer won !!");
            if (playAgain()) {
                gamePlay();
            }
        }

    }

    static boolean playAgain() {
        try {
            System.out.println("wanna play again ? (yes / no)");
            usersChoice = s.next();
            if (usersChoice.equalsIgnoreCase("yes")) {
                return true;
            } else if (usersChoice.equalsIgnoreCase("no")) {
                System.out.println("Have a good day");
                return false;
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("please enter yes or no...");
            return playAgain();
        }
    }

    private static void displayMain() {
        System.out.println("Welcome to ROCK - PAPERS - SCISSORS");
        System.out.println("You will be playing against the computer...LET'S START\n");
        System.out.println("But how many matches do you want ?...\n");
        matches = s.nextInt();
    }

    private static String getInput() {
        System.out.println("Choose your input from (rock,paper,scissors)...");
        usersChoice = s.next();
        return usersChoice;
    }

    private static String getInput(int n) {
        String inputs[] = { "rock", "paper", "scissors" };
        int i = rand.nextInt(inputs.length);
        String input = inputs[i];
        System.out.println("Computer chose..." + input);
        return input;
    }
}
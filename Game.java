import java.util.Scanner;
import java.util.Random;

public class Game {

    public static final String RESET = "\u001b[0m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001b[34m";
    public static final String PURPLE = "\u001b[35m";
    public static final String CYAN = "\u001b[36m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(BLUE + "Choose your troop: Knight, Wizard, MegaKnight" + RESET);
        String choice = sc.nextLine();
        Troop player;
        switch(choice) {
            case "Knight":
                player = new Knight();
                break;
            case "Wizard":
                player = new Wizard();
                break;
            case "MegaKnight":
                player = new MegaKnight();
                break;
            default:
                System.out.println(RED + "Invalid choice, defaulting to Knight." + RESET);
                player = new Knight();
        }

        Troop enemy;
        int enemyType = rand.nextInt(3);
        if(enemyType == 0) enemy = new Knight("Enemy Knight");
        else if(enemyType == 1) enemy = new Wizard("Enemy Wizard");
        else enemy = new MegaKnight("Enemy MegaKnight");

        printStatus(player, enemy);

        while(player.getHP() > 0 && enemy.getHP() > 0) {
            System.out.println(YELLOW + "\nChoose action: attack, special, support, quit" + RESET);
            String action = sc.nextLine();

            String result = "";
            switch(action) {
                case "attack":
                    result = player.attack(enemy);
                    break;
                case "special":
                    result = player.specialAttack(enemy);
                    break;
                case "support":
                    result = player.support();
                    break;
                case "quit":
                    System.out.println(RED + "You quit the game. Goodbye!" + RESET);
                    sc.close();
                    return;
                default:
                    System.out.println(RED + "Invalid action. Try again." + RESET);
                    continue;
            }

            System.out.println(GREEN + "\nYour action: " + RESET + result);

            if(enemy.getHP() <= 0) break;

            int enemyAction = rand.nextInt(3);
            String enemyResult = "";
            if(enemyAction == 0) enemyResult = enemy.attack(player);
            else if(enemyAction == 1) enemyResult = enemy.specialAttack(player);
            else enemyResult = enemy.support();

            System.out.println(RED + "\nEnemy's turn: " + RESET + enemyResult);

            printStatus(player, enemy);
        }

        if(player.getHP() <= 0) System.out.println(RED + "\nYou were defeated! Game over." + RESET);
        else if(enemy.getHP() <= 0) System.out.println(GREEN + "\nYou defeated the enemy! Victory!" + RESET);

        sc.close();
    }

    public static void printStatus(Troop player, Troop enemy) {
        System.out.println(CYAN + "\nCurrent Status:" + RESET);
        System.out.println(BLUE + player.getName() + RESET + " | HP: " + player.getHP() + " | " + player.getSpecialName() + ": " + player.getSpecial());
        System.out.println(PURPLE + enemy.getName() + RESET + " | HP: " + enemy.getHP() + " | " + enemy.getSpecialName() + ": " + enemy.getSpecial());
    }
}

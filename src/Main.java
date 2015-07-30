import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.next();
        Player player1 = new Human(name);
        Player player2 = new Computer("Eva");

        Sea sea = Sea.getUnique_instance(player1, player2);
        sea.menu();


    }
}

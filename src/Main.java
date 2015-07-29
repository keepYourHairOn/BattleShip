public class Main {

    public static void main(String[] args) {
        Player player1 = new Human("Sofiia");
        Player player2 = new Computer("Eva");

        Sea sea = new Sea(player1, player2);
        sea.menu();
    }
}

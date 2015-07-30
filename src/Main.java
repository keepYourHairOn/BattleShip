public class Main {

    public static void main(String[] args) {
        Player player1 = new Human("Sofiia");
        Player player2 = new Computer("Eva");

        Sea sea = Sea.getUnique_instance(player1, player2);
        sea.menu();
    }
}

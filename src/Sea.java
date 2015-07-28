import java.util.ArrayList;

/**
 * Created by Admin on 28.07.2015.
 */
public class Sea {
    private Player player1;
    private Player player2;
    private Cell[][] field1 = new Cell[11][11];
    private Cell[][] field2 = new Cell[11][11];
    private String[][] drawing1 = new String[11][11];
    private String[][] drawing2 = new String[11][11];
    private Integer count_of_steps = 0;

    public Sea(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        formulateField();
    }

    private void formulateField() {
        ArrayList<Cell> field = player2.getCells();
        for (Cell cell : field) {
            for (int i = 1; i <= 10; i++) {
                if (cell.getX() == i) {
                    for (int j = 1; j <= 10; j++) {
                        if (cell.getY() == j) {
                            field2[i][j] = cell;
                        }
                    }
                }
            }

        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                drawing2[i][j] = " - ";
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (field2[i][j] != null) {
                    drawing2[i][j] = " # ";
                } else {
                    drawing2[i][j] = " - ";
                }
            }
        }
    }

    private void showComputersField() {
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
            for (int j = 1; j <= 10; j++) {
                System.out.print(drawing2[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    private void showEmptyField() {
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
            for (int j = 1; j <= 10; j++) {
                System.out.print(" - ");
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void shootTheField(int x, int y){

    }

}

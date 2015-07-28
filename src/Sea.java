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
        formulateField(this.player1, this.field1);
        formulateField(this.player2, this.field2);
        draw(this.field1, this.drawing1);
        draw(this.field2, this.drawing2);
        showYourField(this.drawing1);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        showYourField(this.drawing2);
    }

    private void formulateField(Player player, Cell[][] field) {
        if(player.getCells() != null) {
        ArrayList<Cell> ships = player.getCells();

            for (Cell cell : ships) {
                if (cell != null) {
                    for (int i = 1; i <= 10; i++) {
                        if (cell.getX() == i) {
                            for (int j = 1; j <= 10; j++) {
                                if (cell.getY() == j) {
                                    field[i][j] = cell;
                                }
                            }
                        }
                    }
                }

            }
        }

    }

    private void draw(Cell[][] field, String[][] drawing){
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (field[i][j] != null) {
                    drawing[i][j] = " # ";
                } else {
                    drawing[i][j] = " - ";
                }
            }
        }
    }

    public void showYourField(String[][] drawing) {
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
            for (int j = 1; j <= 10; j++) {
                System.out.print(drawing[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void shootTheField(Cell[][] field, int x, int y){
        for (int i = 1; i < 11; i++) {
            if(x == i) {
                for (int j = 1; j < 11; j++) {
                    if (y == j){
                        field[x][y] = null;
                    }
                }
            }
        }
    }

}

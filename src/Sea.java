import java.util.ArrayList;

/**
 * Created by Admin on 28.07.2015.
 */
public class Sea {
    private Player player1;
    private Player player2;
    private Cell[][] field1 = new Cell[11][11];
    private Cell[][] field2 = new Cell[11][11];
    private String[][] drawing_player1 = new String[11][11];
    private String[][] drawing_player2 = new String[11][11];
    private Integer count_of_steps = 0;

    public Sea(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        formulateField(this.player1, this.field1);
        formulateField(this.player2, this.field2);
        //draw(this.field1, this.drawing1);
        //draw(this.field2, this.drawing2);
        showField(this.drawing_player1);
        System.out.println();
        //showField(this.drawing2);
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

    public void showField(String[][] drawing) {
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
            for (int j = 1; j <= 10; j++) {
                System.out.print(drawing[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }


    public void shootTheField(Player player, int x, int y){
        if(player != null){
            if( x > 1 && x <= 11){
                if(y > 1 && y <= 11){
                    if(field2[x][y] != null && field2[x][y].isFree() == false){
                        field2[x][y].setIsFree(true);
                        if(field2[x + 1][y] != null && field2[x + 1][y].isFree() == false){
                            System.out.println("W");
                        }else if(x > 1){
                            if(field2[x - 1][y] != null && field2[x - 1][y].isFree() == false){
                                System.out.println("W");
                            }
                        }else if(field2[x][y + 1] != null && field2[x][y + 1].isFree() == false){
                            System.out.println("W");
                        }else if(y > 1){
                            if(field2[x][y - 1] != null && field2[x][y - 1].isFree() == false){
                                System.out.println("W");
                            }
                        }
                        System.out.println("K");
                    }else {
                        System.out.println("M");
                    }
                }
            }
        }
    }

}

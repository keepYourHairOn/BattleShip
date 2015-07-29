import java.util.ArrayList;
import java.util.Scanner;

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
        player1.formulateField(this.player1, this.field1);
        player2.formulateField(this.player2, this.field2);
        //draw(this.field1, this.drawing1);
        draw(this.field2, this.drawing_player2);
        showField(this.drawing_player2);
        System.out.println();
        //showField(this.drawing2);
    }


    private void draw(Cell[][] field, String[][] drawing) {
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


    public void shootTheField(Player player, int x, int y) {
        if (player != null) {
            if (x > 0 && x <= 11) {
                if (y > 0 && y <= 11) {
                    if (field2[x][y] != null && field2[x][y].isFree() == false) {
                        field2[x][y].setIsFree(true);
                        field2[x][y].getShip().setStateOfShip(StateOfShip.HITTED);
                        if (field2[x + 1][y] != null && field2[x + 1][y].isFree() == false) {
                            System.out.println("W");
                        } else if (x > 1) {
                            if (field2[x - 1][y] != null && field2[x - 1][y].isFree() == false) {
                                System.out.println("W");
                            }
                        } else if (field2[x][y + 1] != null && field2[x][y + 1].isFree() == false) {
                            System.out.println("W");
                        } else if (y > 1) {
                            if (field2[x][y - 1] != null && field2[x][y - 1].isFree() == false) {
                                System.out.println("W");
                            }
                        } else {
                            field2[x][y].getShip().setStateOfShip(StateOfShip.KILLED);
                            System.out.println("K");
                        }

                    } else {
                        System.out.println("M");
                    }

                    if (field2[x][y] != null) {
                        if (field2[x][y].getShip().getStateOfShip().equals(StateOfShip.HITTED) || field2[x][y].getShip().getStateOfShip().equals(StateOfShip.KILLED)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("It was a good shot!");
                            System.out.println(player.name + ", it is your turn again!");
                            System.out.println("Enter coordinates to shoot again!");

                            System.out.println("Please enter coordinates of the cell you wanted to shoot!");
                            System.out.println("Enter X coordinate! It should be a number from 1 to 10!");
                            x = scanner.nextInt();
                            System.out.println("Enter Y coordinate! It should be a character from A to K, except letter J!");
                            String y1 = scanner.next();
                            analyseInput(player, y1, x);
                            shootTheField(player, x, y);
                        }
                    }

                }

            }
        }
    }

    /**
     * method for converting y coordinate into integer value
     * and to check the correctness of the input
     */
    public void analyseInput(Player player, String y, int x){
        Scanner scanner = new Scanner(System.in);
        if(x > 0 && x < 11){
           int codeOfY = (int)y.charAt(0);
           if(codeOfY >= 65 && codeOfY <= 75 && codeOfY != 74){
               int y1 = 0;
               if(codeOfY == 65){
                   y1 = 1;
               }else if(codeOfY == 66){
                   y1 = 2;
               }else if(codeOfY == 67){
                   y1 = 3;
               }else if(codeOfY == 68){
                   y1 = 4;
               }else if(codeOfY == 69){
                   y1 = 5;
               }else if(codeOfY == 70){
                   y1 = 6;
               }else if(codeOfY == 71){
                   y1 = 7;
               }else if(codeOfY == 72){
                   y1 = 8;
               }else if(codeOfY == 73){
                   y1 = 9;
               }else if(codeOfY == 75){
                   y1 = 10;
               }

               shootTheField(player, x, y1);
           }else {
               System.out.println("You entered wrong Y coordinate! Try again! It should be a character from A to K, except letter J!");
               y = scanner.next();
               analyseInput(player, y, x);
           }
        }else {
            System.out.println("You entered wrong X coordinate! Try again! It should be a number from 1 to 10!");
            x = scanner.nextInt();
            analyseInput(player, y, x);
        }
    }

    /**
     * menu for asking player to input coordinates
     */
    public void shootMenu(String y, int x){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter coordinates of the cell you wanted to shoot!");
        System.out.println("Enter X coordinate! It should be a number from 1 to 10!");
        x = scanner.nextInt();
        System.out.println("Enter Y coordinate! It should be a character from A to K, except letter J!");
        y = scanner.next();
    }

    public void menu(Player player){
        int x = 0;
        String y = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter coordinates of the cell you wanted to shoot!");
        System.out.println("Enter X coordinate! It should be a number from 1 to 10!");
        x = scanner.nextInt();
        System.out.println("Enter Y coordinate! It should be a character from A to K, except letter J!");
        y = scanner.next();
        analyseInput(player, y, x);
    }
}


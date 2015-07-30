import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 28.07.2015.
 */
public class Sea implements Serializable {
    private static Sea unique_instance;
    private Player player1;
    private Player player2;
    private Cell[][] field = new Cell[11][11];
    private Cell[][] field1 = new Cell[11][11];
    private Cell[][] field2 = new Cell[11][11];
    private String[][] drawing_player = new String[11][11];
    private String[][] drawing_player1 = new String[11][11];
    private String[][] drawing_player2 = new String[11][11];
    private Integer count_of_steps = 0;


    public static Sea getUnique_instance(Player human, Player computer) {
        if (unique_instance == null) {
            unique_instance = new Sea(human, computer);
        }
        return unique_instance;
    }

    /**
     * constructor with parameters
     *
     * @param human    is a human
     * @param computer is a computer
     */
    private Sea(Player human, Player computer) {
        this.player1 = human;
        this.player2 = computer;
        formulateField(this.player1, this.field1);
        formulateField(this.player2, this.field2);
        draw(this.field, this.drawing_player);
        draw(this.field2, this.drawing_player2);
        //showField(this.drawing_player2);
        System.out.println();
        //showField(this.drawing2);
    }

    /**
     * default constructor
     */
    private Sea() {
    }

    /**
     * method for forming the field
     *
     * @param field   cells for formulating of field
     * @param drawing is a field to output
     */
    private void draw(Cell[][] field, String[][] drawing) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (field[i][j] != null) {
                    if (field[i][j].isFree()) {
                        drawing[i][j] = " X ";
                    } else {
                        drawing[i][j] = " # ";
                    }
                } else {
                    drawing[i][j] = " - ";
                }
            }
        }
    }

    /**
     * method for formulating the field
     *
     * @param drawing is field to output
     */
    public void showField(String[][] drawing) {
        System.out.println("     A   B   C   D   E   F   G   H   I   K    ");
        for (int i = 1; i <= 10; i++) {
            if (i != 10) {
                System.out.print(i + "  |");
            } else {
                System.out.print(i + " |");
            }
            for (int j = 1; j <= 10; j++) {
                System.out.print(drawing[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    /**
     * method for transform array of cells
     *
     * @param player is player who plays now
     * @param field  is array to put into all the cells
     */
    public void formulateField(Player player, Cell[][] field) {
        if (player.getCells() != null) {
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
        } else {
            System.out.println("You already done with formulating the field on your paper");
        }
    }

    /**
     * method for human to shoot the field
     *
     * @param player human
     * @param x      coordinate x
     * @param y      coordinate y
     */
    public void manShootTheField(Player player, int x, int y) {
        if (player != null) {
            if (x > 0 && x <= 11) {
                if (y > 0 && y <= 11) {
                    if (field2[x][y] != null && field2[x][y].isFree() == false) {
                        field2[x][y].setIsFree(true);
                        field2[x][y].getShip().setStateOfShip(StateOfShip.HITTED);
                        if ((field2[x + 1][y] != null && field2[x + 1][y].isFree() == false) || (x > 1 && field2[x - 1][y] != null && field2[x - 1][y].isFree() == false)) {
                            System.out.println("W");
                            writeToFile("   W\n");
                            field1[x][y] = field2[x][y];

                        } else if ((field2[x][y + 1] != null && field2[x][y + 1].isFree() == false) || y > 1 && field2[x][y - 1] != null && field2[x][y - 1].isFree() == false) {
                            System.out.println("W");
                            writeToFile("   W\n");
                        } else {
                            field2[x][y].getShip().setStateOfShip(StateOfShip.KILLED);
                            player.minimizeCountOfLiveShips();
                            System.out.println("K");
                            writeToFile("K\n");
                        }
                    } else {
                        System.out.println("M");
                        writeToFile("   M\n");
                        draw(this.field1, this.drawing_player1);
                        showField(this.drawing_player1);
                    }

                    if (field2[x][y] != null) {
                        if (field2[x][y].getShip().getStateOfShip().equals(StateOfShip.HITTED) || field2[x][y].getShip().getStateOfShip().equals(StateOfShip.KILLED)) {
                            field1[x][y] = field2[x][y];
                            draw(this.field1, this.drawing_player1);
                            showField(this.drawing_player1);
                            field2[x][y] = null;
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("________________________________________");
                            System.out.println(player.name + ", it is your turn again!");

                            System.out.println("Enter coordinate! It should be a character from A to K, except letter J and then a number from 1 to 10!");
                            String tmp = scanner.next();
                            if (!tmp.equalsIgnoreCase("save")) {

                                char[] arr = tmp.toCharArray();
                                x = Character.getNumericValue(arr[1]);
                                char y1 = arr[0];
                                String str = player.name + ": " + y1 + "" + x;
                                writeToFile(str);
                                analyseInput(player, y1, x);

                            } else {
                                save(this);
                                tmp = scanner.next();
                                char[] arr = tmp.toCharArray();
                                x = Character.getNumericValue(arr[1]);
                                char y1 = arr[0];
                                String str = player.name + ": " + y1 + "" + x;
                                writeToFile(str);
                                analyseInput(player, y1, x);

                            }
                        }
                    }

                }

            }
        }
    }

    /**
     * method for computer to shoot the field
     *
     * @param player computer
     * @param x      coordinate x
     * @param y      coordinate y
     */
    public void compShootTheField(Player player, int x, int y, char y2) {
        if (player != null) {
            if (x > 0 && x <= 11) {
                if (y > 0 && y <= 11) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println(player.name + ": Do I miss(M), kill(K) or wounded(W)?");
                    String input = scanner.next();
                    if (input.equalsIgnoreCase("W")) {
                        writeToFile("   W\n");
                        drawing_player[x][y] = " X ";
                        showField(this.drawing_player);
                        System.out.println("________________________________________");
                        System.out.println(player.name + ", it is your turn again!");

                        Random random = new Random();
                        x = random.nextInt(10);
                        y2 = (char) (random.nextInt((75 - 65) + 1) + 65);
                        String str = player.name + ": " + y2 + "" + x;
                        System.out.println(str);
                        writeToFile(str);
                        analyseInput(player, y2, x);

                    } else if (input.equalsIgnoreCase("K")) {
                        writeToFile("   K\n");
                        drawing_player[x][y] = " X ";
                        player.minimizeCountOfLiveShips();
                        showField(this.drawing_player);
                        System.out.println("________________________________________");
                        System.out.println("It is " + player.name + "'s turn again!");

                        Random random = new Random();
                        x = random.nextInt(10);
                        y2 = (char) (random.nextInt((75 - 65) + 1) + 65);
                        String str = player.name + ": " + y2 + "" + x;
                        System.out.println(str);
                        writeToFile(str);
                        analyseInput(player, y2, x);
                    } else {
                        writeToFile("   M\n");
                        return;
                    }
                }

            }
        }
    }

    /**
     * method for converting y coordinate into integer value
     * and to check the correctness of the input
     */
    public void analyseInput(Player player, char y, int x) {
        Scanner scanner = new Scanner(System.in);
        if (x > 0 && x < 11) {
            int codeOfY = changeCharToInt(y);
            if (codeOfY > 0) {

                if (player instanceof Human) {
                    String str = player1.name + ": " + y + "" + x;
                    //System.out.println(str);
                    //writeToFile(str);
                    manShootTheField(player, x, codeOfY);
                } else {
                    String str = player2.name + ": " + y + "" + x;
                    //System.out.println(str);
                    //writeToFile(str);
                    compShootTheField(player, x, codeOfY, y);
                }

            } else {

                if (player instanceof Human) {
                    System.out.println("You entered wrong coordinates! Try again! It should be a character from A to K, except letter J and then a number from 1 to 10!");
                    String tmp = scanner.next();
                    if (!tmp.equalsIgnoreCase("save")) {
                        char[] arr = tmp.toCharArray();
                        x = Character.getNumericValue(arr[1]);
                        char y1 = arr[0];
                        analyseInput(player, y1, x);
                    } else {
                        save(this);
                        tmp = scanner.next();
                        char[] arr = tmp.toCharArray();
                        x = Character.getNumericValue(arr[1]);
                        char y1 = arr[0];
                        analyseInput(player, y1, x);

                    }
                } else {
                    Random random = new Random();
                    x = random.nextInt(10);
                    y = (char) (random.nextInt((75 - 65) + 1) + 65);
                    analyseInput(player2, y, x);
                }

            }
        } else {

            if (player instanceof Human) {
                System.out.println("You entered wrong coordinates! Try again! It should be a character from A to K, except letter J and then a number from 1 to 10!");
                String tmp = scanner.next();
                if (!tmp.equalsIgnoreCase("save")) {
                    char[] arr = tmp.toCharArray();
                    x = Character.getNumericValue(arr[1]);
                    char y1 = arr[0];
                    analyseInput(player, y1, x);
                } else {
                    save(this);
                    tmp = scanner.next();
                    char[] arr = tmp.toCharArray();
                    x = Character.getNumericValue(arr[1]);
                    char y1 = arr[0];
                    analyseInput(player, y1, x);
                }
            } else {
                Random random = new Random();
                x = random.nextInt(10);
                analyseInput(player2, y, x);
            }
        }
    }

    /**
     * menu for players
     */
    public void menu() {
        try {
            continueGame();
        } catch (Exception e) {
            System.out.println("There is no saved games!");
            System.out.println("Starting new one...");
        }

        int countOfStep = 1;
        Integer x = 0;

        Scanner scanner = new Scanner(System.in);

        while (player1.getCountOfLiveShips() != 0 && player2.getCountOfLiveShips() != 0) {
            if (countOfStep % 2 != 0) {
                System.out.println(player1.name + "'s turn to shoot");
                System.out.println("Please enter coordinates of the cell you wanted to shoot!");
                String tmp = scanner.next();
                if (!tmp.equalsIgnoreCase("save")) {
                    char[] arr = tmp.toCharArray();
                    x = Character.getNumericValue(arr[1]);
                    char y1 = arr[0];
                    String str = player1.name + ": " + y1 + "" + x;
                    System.out.println(str);
                    writeToFile(str);
                    analyseInput(player1, y1, x);
                } else {
                    save(this);
                    tmp = scanner.next();
                    char[] arr = tmp.toCharArray();
                    x = Character.getNumericValue(arr[1]);
                    char y1 = arr[0];
                    String str = player1.name + ": " + y1 + "" + x;
                    System.out.println(str);
                    writeToFile(str);
                    analyseInput(player1, y1, x);
                }
                countOfStep++;
            } else {
                System.out.println(player2.name + "'s turn to shoot");
                System.out.println("Entered coordinates:");
                Random random = new Random();
                x = random.nextInt(10);
                char tmp = (char) (random.nextInt((75 - 65) + 1) + 65);
                String str = player2.name + ": " + tmp + "" + x;
                System.out.println(str);
                writeToFile(str);
                analyseInput(player2, tmp, x);
                countOfStep++;

            }
        }
        if (player1.getCountOfLiveShips() != 0 && player2.getCountOfLiveShips() == 0) {
            String str = player1.name + ":    YOU WIN     ";
            System.out.println(str);
            writeToFile(str);
        } else {
            String str = "Game over :(";
            System.out.println(str);
            writeToFile(str);
        }
    }

    /**
     * method for getting the value of cell according to unicode number
     *
     * @param y is char to detect the code of
     * @return column for element with y coordinate to put in
     */
    public int changeCharToInt(char y) {
        int codeOfY = (int) y;
        int y1 = 0;
        if (codeOfY >= 65 && codeOfY <= 75 && codeOfY != 74) {

            if (codeOfY == 65) {
                y1 = 1;
            } else if (codeOfY == 66) {
                y1 = 2;
            } else if (codeOfY == 67) {
                y1 = 3;
            } else if (codeOfY == 68) {
                y1 = 4;
            } else if (codeOfY == 69) {
                y1 = 5;
            } else if (codeOfY == 70) {
                y1 = 6;
            } else if (codeOfY == 71) {
                y1 = 7;
            } else if (codeOfY == 72) {
                y1 = 8;
            } else if (codeOfY == 73) {
                y1 = 9;
            } else if (codeOfY == 75) {
                y1 = 10;
            }
        }
        return y1;
    }

    /**
     * method for sea serialization into file
     *
     * @param sea is object to serialize
     */
    public void save(Sea sea) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("D:/Development/GitHub/BattleShip/saved.txt", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sea);
            out.close();
            fileOut.close();
            String str = "Serialized data is saved in saved.txt file";
            System.out.println(str + "\n");
            System.exit(0);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * method for deserialization
     *
     * @return deserialized object read from the file
     */
    public Sea continueGame() throws Exception {
        Sea sea = null;
        try {
            FileInputStream fileIn = new FileInputStream("D:/Development/GitHub/BattleShip/saved.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sea = (Sea) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception i) {
            throw i;
        }
        String str = "Deserialized data is saved in saved.txt file";
        String str1 = "Player 1: " + sea.player1.name + " VS Player 2: " + sea.player2.name;
        System.out.println(str1);

        return sea;
    }

    /**
     * method for writing game steps to file
     *
     * @param str is string to write
     */
    public void writeToFile(String str) {
        try {
            BufferedWriter stream = new BufferedWriter(new FileWriter("D:/Development/GitHub/BattleShip/log.txt", true));
            stream.write(str);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }
}


import java.util.ArrayList;

/**
 * Created by Admin on 28.07.2015.
 */
public abstract class Player {
    protected String name;
    protected ArrayList<Ship> ships;
    protected boolean isHitted;
    protected int countOfLiveShips = 10;


    abstract void locateShips();

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public ArrayList<Cell> getCells() {
        ArrayList<Cell> cells = new ArrayList<>();
        Ship ship;
        ArrayList<Cell> tmp;
        if(ships.size() > 0) {
            for (int i = 0; i < 10; i++) {
                ship = ships.get(i);
                tmp = ship.getCoordinates();
                for (int j = 0; j < tmp.size(); j++) {
                    cells.add(tmp.get(j));
                }
            }
            return cells;
        }
        return null;
    }

    public void formulateField(Player player, Cell[][] field) {
        if(player.getCells() != null) {
            ArrayList<Cell> ships = this.getCells();

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
        }else {
            System.out.println("You already done with formulating the field on your paper");
        }
    }

    public int getCountOfLiveShips() {
        return countOfLiveShips;
    }

}

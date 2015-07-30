import java.util.ArrayList;

/**
 * Created by Admin on 28.07.2015.
 */
public abstract class Player {
    protected String name;
    protected ArrayList<Ship> ships;
    protected boolean isHitted;
    protected int countOfLiveShips = 10;

    /**
     * method for overloading by child classes
     */
    abstract void locateShips();

    /**
     * getter for all ships of the
     * @return ships
     */
    public ArrayList<Ship> getShips() {
        return ships;
    }

    /**
     * getter for all cells of all ships
     * @return
     */
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


    /**
     * counter of alive ships
     * @return number of live ships
     */
    public int getCountOfLiveShips() {
        return countOfLiveShips;
    }

    /**
     * method for changing the number of live ships
     */
    public void minimizeCountOfLiveShips() {
        this.countOfLiveShips = countOfLiveShips - 1;
    }
}

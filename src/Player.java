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

    public ArrayList<Cell> getCells(){
        ArrayList<Cell> cells = new ArrayList<>();
        Ship ship;
        ArrayList<Cell> tmp;
        for (int i = 0; i < 10; i++) {
            ship = ships.get(i);
            tmp = ship.getCoordinates();
            for (int j = 0; j < tmp.size(); j++) {
                cells.add(tmp.get(j));
            }
        }
        return cells;
    }

    public int getCountOfLiveShips() {
        return countOfLiveShips;
    }
}

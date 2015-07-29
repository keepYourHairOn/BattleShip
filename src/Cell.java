/**
 * Created by Admin on 28.07.2015.
 */
public class Cell {
    private Integer y;
    private Integer x;
    private boolean isFree;
    private Ship ship;

    public Cell(Integer x, Integer y, Ship ship) {
        this.y = y;
        this.x = x;
        this.isFree = false;
        this.ship = ship;
    }

    public Cell(){
        isFree = true;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    public boolean isFree() {
        return isFree;
    }

    public Ship getShip() {
        return ship;
    }
}

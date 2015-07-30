/**
 * Created by Admin on 28.07.2015.
 */
public class Cell {
    private Integer y;
    private Integer x;
    private boolean isFree;
    private Ship ship;

    /**
     * constructor with parameters
     * @param x is coordinate on X-axis
     * @param y is coordinate on the Y-axis
     * @param ship ship in which the cell is located
     */
    public Cell(Integer x, Integer y, Ship ship) {
        this.y = y;
        this.x = x;
        this.isFree = false;
        this.ship = ship;
    }

    /**
     * default constructor
     */
    public Cell(){
        isFree = true;
    }

    /**
     * setter for making the cell free from the ship
     * @param isFree is true, when the cell should be free
     */
    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    /**
     * getter for Y variable
     * @return y coordinate of the cell
     */
    public Integer getY() {
        return y;
    }

    /**
     * getter for X variable
     * @return x coordinate of the cell
     */
    public Integer getX() {
        return x;
    }

    /**
     * method for checking if the cell is free
     * @return true if so
     */
    public boolean isFree() {
        return isFree;
    }

    /**
     * getter for the ship
     * @return parental ship of the cell
     */
    public Ship getShip() {
        return ship;
    }
}

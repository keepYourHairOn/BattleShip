import java.util.ArrayList;

/**
 * Created by Admin on 28.07.2015.
 */
public class Ship {
    private ArrayList<Cell> coordinates;
    private StateOfShip stateOfShip;

    /**
     * constructor with parameters
     * @param coordinates is set of coordinates of all cells of the ship
     * @param stateOfShip is the state of the ship
     */
    public Ship(ArrayList<Cell> coordinates, StateOfShip stateOfShip){
        this.coordinates = coordinates;
        this.stateOfShip = stateOfShip;
    }

    /**
     * setter
     * @param stateOfShip is state of ship to change to
     */
    public void setStateOfShip(StateOfShip stateOfShip) {
        this.stateOfShip = stateOfShip;
    }

    /**
     * getter of the state
     * @return state of the ship
     */
    public StateOfShip getStateOfShip() {
        return stateOfShip;
    }

    /**
     * getter
     * @return array of coordinates of the ship
     */
    public ArrayList<Cell> getCoordinates() {
        return coordinates;
    }

    /**
     * setter
     * @param coordinates is coordinates to set
     */
    public void setCoordinates(ArrayList<Cell> coordinates) {
        this.coordinates = coordinates;
    }
}

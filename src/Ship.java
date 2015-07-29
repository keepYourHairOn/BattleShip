import java.util.ArrayList;

/**
 * Created by Admin on 28.07.2015.
 */
public class Ship {
    private ArrayList<Cell> coordinates;
    private StateOfShip stateOfShip;

    public Ship(ArrayList<Cell> coordinates, StateOfShip stateOfShip){
        this.coordinates = coordinates;
        this.stateOfShip = stateOfShip;
    }

    public void setStateOfShip(StateOfShip stateOfShip) {
        this.stateOfShip = stateOfShip;
    }

    public StateOfShip getStateOfShip() {
        return stateOfShip;
    }

    public ArrayList<Cell> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Cell> coordinates) {
        this.coordinates = coordinates;
    }
}

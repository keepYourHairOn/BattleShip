import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 28.07.2015.
 */
public class Computer extends Player implements Serializable {

    /**
     * constructor with parameters
     * @param name is name of the computer
     */
    public Computer(String name){
        this.name = name;
        this.ships = new ArrayList<>();
        locateShips();
    }

    /**
     * method for location of computer's ships
     * on defined places
     */
    @Override
    void locateShips() {
        /**
         * TODO:to add a logic about AI creation of the ships
         */
        ArrayList<Cell> coords = new ArrayList<>();
        Ship ship = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(2,3, ship));
        ship.setCoordinates(coords);
        ships.add(ship);

        coords = new ArrayList<>();
        Ship ship1 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(1,10, ship1));
        ship.setCoordinates(coords);
        ships.add(ship1);

        coords = new ArrayList<>();
        Ship ship2 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(5,10, ship2));
        ship.setCoordinates(coords);
        ships.add(ship2);

        coords = new ArrayList<>();
        Ship ship3 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(9,3, ship3));
        ship.setCoordinates(coords);
        ships.add(ship3);

        coords = new ArrayList<>();
        Ship ship4 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(2,8, ship4));
        coords.add(new Cell(3,8, ship4));
        ship.setCoordinates(coords);
        ships.add(ship4);

        coords = new ArrayList<>();
        Ship ship5 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(6,1,ship5));
        coords.add(new Cell(6,2,ship5));
        ship.setCoordinates(coords);
        ships.add(ship5);

        coords = new ArrayList<>();
        Ship ship6 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(8,10,ship6));
        coords.add(new Cell(9,10,ship6));
        ship.setCoordinates(coords);
        ships.add(ship6);

        coords = new ArrayList<>();
        Ship ship7 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(4,1,ship7));
        coords.add(new Cell(4,2,ship7));
        coords.add(new Cell(4,3,ship7));
        ship.setCoordinates(coords);
        ships.add(ship7);

        coords = new ArrayList<>();
        Ship ship8 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(8,6,ship8));
        coords.add(new Cell(8,7,ship8));
        coords.add(new Cell(8,8,ship8));
        ship.setCoordinates(coords);
        ships.add(ship8);

        coords = new ArrayList<>();
        Ship ship9 = new Ship(coords, StateOfShip.INITIAl);
        coords.add(new Cell(3,5,ship9));
        coords.add(new Cell(4,5,ship9));
        coords.add(new Cell(5,5,ship9));
        coords.add(new Cell(6,5,ship9));
        ship.setCoordinates(coords);
        ships.add(ship9);

    }


}

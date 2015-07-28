import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 28.07.2015.
 */
public class Computer extends Player {

    public Computer(String name){
        this.name = name;
        this.ships = new ArrayList<>();
        locateShips();
    }

    @Override
    void locateShips() {
        ArrayList<Cell> coords = new ArrayList<>();
        coords.add(new Cell(2,3));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(1,10));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(5,10));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(9,3));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(2,8));
        coords.add(new Cell(3,8));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(6,1));
        coords.add(new Cell(6,2));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(8,10));
        coords.add(new Cell(9,10));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(4,1));
        coords.add(new Cell(4,2));
        coords.add(new Cell(4,3));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(8,6));
        coords.add(new Cell(8,7));
        coords.add(new Cell(8,8));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

        coords = new ArrayList<>();
        coords.add(new Cell(3,5));
        coords.add(new Cell(4,5));
        coords.add(new Cell(5,5));
        coords.add(new Cell(6,5));
        ships.add(new Ship(coords, StateOfShip.INITIAl));

    }

}

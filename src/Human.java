import java.util.ArrayList;

/**
 * Created by Admin on 28.07.2015.
 */
public class Human extends Player {
    /**
     * constructor with parameters
     * @param name is name of the human
     */
    public Human(String name){
        this.name = name;
        this.ships = new ArrayList<>();
        locateShips();
    }

    /**
     * method for location of ships on the paper, indicate finishing of the process
     */
    @Override
    void locateShips() {
        System.out.println("Locate ships on your shit of paper!");
    }

}

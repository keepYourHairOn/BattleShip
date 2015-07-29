import java.util.ArrayList;

/**
 * Created by Admin on 28.07.2015.
 */
public class Human extends Player {
    public Human(String name){
        this.name = name;
        this.ships = new ArrayList<>();
        locateShips();
    }


    @Override
    void locateShips() {
        System.out.println("Locate ships on your shit of paper!");
    }

}

/**
 * Created by Admin on 28.07.2015.
 */
public class Cell {
    private Integer y;
    private Integer x;
    private boolean isFree;

    public Cell(Integer x, Integer y) {
        this.y = y;
        this.x = x;
        isFree = false;
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
}

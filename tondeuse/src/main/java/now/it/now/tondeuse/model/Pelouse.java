package now.it.now.tondeuse.model;

/**
 * Created by fatma on 26/11/2018.
 */

/**
 * It represent the pelouse when the tondeuse executes
 */
public class Pelouse {
    /**
     * Position is an X Y max value.
      */
    private Position size;

    public Pelouse(int sizeX, int sizeY) {
        this.size = new Position(sizeX, sizeY, null);
    }

    public Position getSize() {
        return size;
    }

    public void setSize(Position size) {
        this.size = size;
    }
}

package now.it.now.tondeuse.model;

/**
 * Created by fatma on 26/11/2018.
 */
public class Tondeuse {

    /**
     * The position that occupy the mower at an instant t
     * defined by x and y
     */
    private Position position;
    /**
     * movements should  be done by "the mower" resulting of
     * the instructions given in the injected file
     * G : for left movement
     * A : for forward movement
     * D : for right movement
     */
    private Instruction[] instructions;

    public Tondeuse() {
    }

    public Tondeuse(Position position, Instruction[] instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }

    public void setInstructions(Instruction[] instructions) {
        this.instructions = instructions;
    }
}

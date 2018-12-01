package now.it.now.tondeuse.model;

/**
 * Created by fatma on 26/11/2018.
 */
public class Tondeuse {

    private Position position;
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

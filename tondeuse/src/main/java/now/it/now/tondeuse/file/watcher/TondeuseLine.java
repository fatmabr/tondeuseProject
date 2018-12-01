package now.it.now.tondeuse.file.watcher;

import file.watcher.line.Line;
import now.it.now.tondeuse.model.Instruction;
import now.it.now.tondeuse.model.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatma on 28/11/2018.
 */
public class TondeuseLine implements Line{

    private List<Instruction> instructions = new ArrayList<>();

    private int tondeuseX;
    private int tondeuseY;
    private Orientation orientation;

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public int getTondeuseX() {
        return tondeuseX;
    }

    public void setTondeuseX(int tondeuseX) {
        this.tondeuseX = tondeuseX;
    }

    public int getTondeuseY() {
        return tondeuseY;
    }

    public void setTondeuseY(int tondeuseY) {
        this.tondeuseY = tondeuseY;
    }
}

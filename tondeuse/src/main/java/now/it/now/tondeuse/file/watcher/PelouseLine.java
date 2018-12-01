package now.it.now.tondeuse.file.watcher;

import file.watcher.line.Header;
import file.watcher.line.Line;

/**
 * Created by fatma on 28/11/2018.
 */
public class PelouseLine implements Header{

    public PelouseLine(int pelouseXSise, int pelouseYSise) {
        this.pelouseXSise = pelouseXSise;
        this.pelouseYSise = pelouseYSise;
    }

    private int pelouseXSise;
    private int pelouseYSise;

    public int getPelouseXSise() {
        return pelouseXSise;
    }

    public void setPelouseXSise(int pelouseXSise) {
        this.pelouseXSise = pelouseXSise;
    }

    public int getPelouseYSise() {
        return pelouseYSise;
    }

    public void setPelouseYSise(int pelouseYSise) {
        this.pelouseYSise = pelouseYSise;
    }
}

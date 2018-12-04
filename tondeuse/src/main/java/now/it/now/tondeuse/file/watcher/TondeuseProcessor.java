package now.it.now.tondeuse.file.watcher;

import file.watcher.line.Header;
import file.watcher.line.Line;
import file.watcher.processor.AbstractFileProcessor;
import now.it.now.tondeuse.model.Instruction;
import now.it.now.tondeuse.model.Pelouse;
import now.it.now.tondeuse.model.Position;
import now.it.now.tondeuse.model.Tondeuse;
import now.it.now.tondeuse.service.MovementsExecutor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by fatma on 30/11/2018.
 */

public class TondeuseProcessor extends AbstractFileProcessor {

    @Autowired
    private MovementsExecutor movementsExecutor;

    @Override
    public void process(Line line) {
        throw new IllegalStateException("The pelouse size must be the first line of the file.");
    }

    @Override
    public void processWithHeader(Header header, Line line) {
        if (header != null) {
            Pelouse pelouse = createPelouse((PelouseLine) header);
            Tondeuse tondeuse = createTondeuse((TondeuseLine) line);
            movementsExecutor.execute(pelouse, tondeuse);
            System.out.println(tondeuse.getPosition().toString());
        } else {
            throw new IllegalStateException("The pelouse size must be the first line of the file.");
        }
    }

    private Tondeuse createTondeuse(TondeuseLine line) {
        List<Instruction> instructions = line.getInstructions();
        Instruction[] instructionsArray = instructions.toArray(new Instruction[instructions.size()]);
        return new Tondeuse(new Position(line.getTondeuseX(), line.getTondeuseY(), line.getOrientation()), instructionsArray);
    }

    private Pelouse createPelouse(PelouseLine pelouseLine) {
        return new Pelouse(pelouseLine.getPelouseXSise(), pelouseLine.getPelouseYSise());
    }

    @Override
    public boolean validate(Line line) {
        return true;
    }
}

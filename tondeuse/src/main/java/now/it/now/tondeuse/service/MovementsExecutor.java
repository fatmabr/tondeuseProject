package now.it.now.tondeuse.service;

import now.it.now.tondeuse.factory.MovementFactory;
import now.it.now.tondeuse.model.Instruction;
import now.it.now.tondeuse.model.Pelouse;
import now.it.now.tondeuse.model.Position;
import now.it.now.tondeuse.model.Tondeuse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatma on 26/11/2018.
 */
@Component
public class MovementsExecutor {

    /**
     * @param pelouse
     * @param tondeuse
     * @return
     */
    public void execute(Pelouse pelouse, Tondeuse tondeuse) {
        List<Movement> movements = new ArrayList();

        for (Instruction instruction : tondeuse.getInstructions()) {
            movements.add(MovementFactory.create(instruction));
        }
        for (Movement movement : movements) {
            Position position = tondeuse.getPosition();
            movement.move(pelouse, position);
        }
    }
}

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
     * tondeuse execution
     *
     * @param pelouse
     * @param tondeuse
     */
    public void execute(Pelouse pelouse, Tondeuse tondeuse) {
        for (Instruction instruction : tondeuse.getInstructions()) {
            Movement movement = MovementFactory.create(instruction);
            Position position = tondeuse.getPosition();
            movement.move(pelouse, position);
        }
    }
}

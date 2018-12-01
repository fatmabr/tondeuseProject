package now.it.now.tondeuse.factory;

import now.it.now.tondeuse.model.Instruction;
import now.it.now.tondeuse.service.ForwardMovement;
import now.it.now.tondeuse.service.Movement;

/**
 * Created by fatma on 26/11/2018.
 */
public class MovementFactory {

    public static Movement create(Instruction instruction){
       return instruction.create();
    }
}

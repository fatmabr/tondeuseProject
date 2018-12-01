package now.it.now.tondeuse;

import now.it.now.tondeuse.factory.MovementFactory;
import now.it.now.tondeuse.model.Instruction;
import now.it.now.tondeuse.service.ForwardMovement;
import now.it.now.tondeuse.service.LeftMovement;
import now.it.now.tondeuse.service.Movement;
import now.it.now.tondeuse.service.RightMovement;
import org.junit.Test;

import java.lang.management.ManagementFactory;

/**
 * Created by fatma on 30/11/2018.
 */
public class MovementFactoryTest {

    @Test
    public void testRightMovementCreationWhenInstructionD(){
        Movement movement = MovementFactory.create(Instruction.D);
        assert movement instanceof RightMovement;
    }
    @Test
    public void testLeftMovementCreationWhenInstructionG(){
        Movement movement = MovementFactory.create(Instruction.G);
        assert movement instanceof LeftMovement;
    }
    @Test
    public void testRightMovementCreationWhenInstructionF(){
        Movement movement = MovementFactory.create(Instruction.A);
        assert movement instanceof ForwardMovement;
    }
}

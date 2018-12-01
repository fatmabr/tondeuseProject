package now.it.now.tondeuse;

import now.it.now.tondeuse.model.*;
import now.it.now.tondeuse.service.MovementsExecutor;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by fatma on 30/11/2018.
 */

public class MovementsExecutorTest {

    private Tondeuse tondeuse;
    private Pelouse pelouse;

    @Before
    public void setUp() throws Exception {
        pelouse = new Pelouse(5, 5);
    }

    @Test
    public void testMovementExecutor() throws Exception {
        Instruction[] instructions = {Instruction.G, Instruction.A,
                Instruction.G, Instruction.A,
                Instruction.G, Instruction.A,
                Instruction.G, Instruction.A,
                Instruction.G, Instruction.A,
                Instruction.A,
        };
        tondeuse = new Tondeuse(new Position(1, 2, Orientation.N), instructions);
        MovementsExecutor movementsExecutor = new MovementsExecutor();
        movementsExecutor.execute(pelouse, tondeuse);
        assert tondeuse.getPosition().getX() == 1 && tondeuse.getPosition().getY() == 3 &&
                tondeuse.getPosition().getOrientation().equals(Orientation.N);
    }

    @Test
    public void testMovementExecutor2() throws Exception {
        Instruction[] instructions = {Instruction.G, Instruction.A,
                Instruction.A, Instruction.A,
                Instruction.D, Instruction.A,
                Instruction.A, Instruction.D,
                Instruction.A, Instruction.D,
                Instruction.D, Instruction.A
        };
        tondeuse = new Tondeuse(new Position(3, 3, Orientation.E), instructions);
        MovementsExecutor movementsExecutor = new MovementsExecutor();
        movementsExecutor.execute(pelouse, tondeuse);
        assert tondeuse.getPosition().getX() == 5 && tondeuse.getPosition().getY() == 1 &&
                tondeuse.getPosition().getOrientation().equals(Orientation.E);
    }

    @Test
    public void testConcurrency() throws Exception {
        Instruction[] instructions1 = {Instruction.G, Instruction.A,
                Instruction.A, Instruction.A,
                Instruction.D, Instruction.A,
                Instruction.A, Instruction.D,
                Instruction.A, Instruction.D,
                Instruction.D, Instruction.A
        };
        Tondeuse tondeuse1 = new Tondeuse(new Position(3, 3, Orientation.E), instructions1);
        MovementsExecutor movementsExecutor = new MovementsExecutor();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                movementsExecutor.execute(pelouse, tondeuse1);
            }
        });
        movementsExecutor.execute(pelouse, tondeuse1);


        Instruction[] instructions2 = {Instruction.G, Instruction.A,
                Instruction.G, Instruction.A,
                Instruction.G, Instruction.A,
                Instruction.G, Instruction.A,
                Instruction.G, Instruction.A,
                Instruction.A,
        };
        Tondeuse tondeuse2 = new Tondeuse(new Position(1, 2, Orientation.N), instructions2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                movementsExecutor.execute(pelouse, tondeuse2);
            }
        });
        thread1.run();
        thread.run();
        assert tondeuse1.getPosition().getX() == 5 && tondeuse1.getPosition().getY() == 1 &&
                tondeuse1.getPosition().getOrientation().equals(Orientation.E);
        assert tondeuse2.getPosition().getX() == 1 && tondeuse2.getPosition().getY() == 3 &&
                tondeuse2.getPosition().getOrientation().equals(Orientation.N);
    }
}

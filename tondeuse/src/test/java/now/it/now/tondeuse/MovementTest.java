package now.it.now.tondeuse;

import now.it.now.tondeuse.model.Orientation;
import now.it.now.tondeuse.model.Pelouse;
import now.it.now.tondeuse.model.Position;
import now.it.now.tondeuse.service.ForwardMovement;
import now.it.now.tondeuse.service.LeftMovement;
import now.it.now.tondeuse.service.RightMovement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by fatma on 30/11/2018.
 */
public class MovementTest {

    private Pelouse pelouse;

    @Before
    public void setUp() throws Exception {
        pelouse = new Pelouse(2, 3);
    }

    @Test
    public void testMovementForwardWhenNorthOrientation() {
        ForwardMovement forwardMovement = new ForwardMovement();
        Position position = new Position();
        position.setOrientation(Orientation.N);
        position.setX(1);
        position.setY(1);
        boolean move = forwardMovement.move(pelouse, position);
        Assert.assertTrue(position.getY() == 2 && move);
    }

    @Test
    public void testMovementForwardWhenSouthOrientation() {
        ForwardMovement forwardMovement = new ForwardMovement();
        Position position = new Position();
        position.setOrientation(Orientation.S);
        position.setX(1);
        position.setY(1);
        boolean move = forwardMovement.move(pelouse, position);
        Assert.assertTrue(position.getY() == 0 && move);
    }

    @Test
    public void testMovementForwardWhenWestOrientation() {
        ForwardMovement forwardMovement = new ForwardMovement();
        Position position = new Position();
        position.setOrientation(Orientation.W);
        position.setX(1);
        position.setY(1);
        boolean move = forwardMovement.move(pelouse, position);
        Assert.assertTrue(position.getX() == 0 && move);
    }

    @Test
    public void testMovementForwardWhenEstOrientation() {
        ForwardMovement forwardMovement = new ForwardMovement();
        Position position = new Position();
        position.setOrientation(Orientation.E);
        position.setX(1);
        position.setY(1);
        boolean move = forwardMovement.move(pelouse, position);
        Assert.assertTrue(position.getX() == 2 && move);
    }

    @Test
    public void testMovementForwardWhenBadNewPosition() {
        ForwardMovement forwardMovement = new ForwardMovement();
        Position position = new Position();
        position.setOrientation(Orientation.E);
        position.setX(2);
        position.setY(1);
        boolean move = forwardMovement.move(pelouse, position);
        Assert.assertTrue(position.getX() == 2 && !move);
    }

    @Test
    public void testMovementRightWhenNorthOrientation() {
        RightMovement rightMovement = new RightMovement();
        Position position = new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation(Orientation.N);
        boolean move = rightMovement.move(pelouse, position);
        Assert.assertTrue(position.getOrientation().equals(Orientation.E) && move);
    }

    @Test
    public void testMovementRightWhenSouthOrientation() {
        RightMovement rightMovement = new RightMovement();
        Position position = new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation(Orientation.S);
        boolean move = rightMovement.move(pelouse, position);
        Assert.assertTrue(position.getOrientation().equals(Orientation.W) && move);
    }

    @Test
    public void testMovementRightWhenWestOrientation() {
        RightMovement rightMovement = new RightMovement();
        Position position = new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation(Orientation.W);
        boolean move = rightMovement.move(pelouse, position);
        Assert.assertTrue(position.getOrientation().equals(Orientation.N) && move);
    }

    @Test
    public void testMovementRightWhenEstOrientation() {
        RightMovement rightMovement = new RightMovement();
        Position position = new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation(Orientation.E);
        boolean move = rightMovement.move(pelouse, position);
        Assert.assertTrue(position.getOrientation().equals(Orientation.S) && move);
    }

    @Test
    public void testMovementLeftWhenEstOrientation() {
        LeftMovement leftMovement = new LeftMovement();
        Position position = new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation(Orientation.E);
        boolean move = leftMovement.move(pelouse, position);
        Assert.assertTrue(position.getOrientation().equals(Orientation.N) && move);
    }@Test
    public void testMovementLeftWhenWestOrientation() {
        LeftMovement leftMovement = new LeftMovement();
        Position position = new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation(Orientation.W);
        boolean move = leftMovement.move(pelouse, position);
        Assert.assertTrue(position.getOrientation().equals(Orientation.S) && move);
    }@Test
    public void testMovementLeftWhenNorthOrientation() {
        LeftMovement leftMovement = new LeftMovement();
        Position position = new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation(Orientation.N);
        boolean move = leftMovement.move(pelouse, position);
        Assert.assertTrue(position.getOrientation().equals(Orientation.W) && move);
    }@Test
    public void testMovementLeftWhenSouthOrientation() {
        LeftMovement leftMovement = new LeftMovement();
        Position position = new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation(Orientation.S);
        boolean move = leftMovement.move(pelouse, position);
        Assert.assertTrue(position.getOrientation().equals(Orientation.E) && move);
    }

}

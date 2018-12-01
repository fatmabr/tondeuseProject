package now.it.now.tondeuse.service;

import now.it.now.tondeuse.model.Pelouse;
import now.it.now.tondeuse.model.Position;

/**
 * Created by fatma on 26/11/2018.
 */
public abstract class Movement {

    public boolean move(Pelouse pelouse, Position position) {
        Position newPosition = getNewPosition(position);
        if (!isRightLeftMovement() && !isBadXPosition(pelouse, newPosition.getX()) && !isBadYPosition(pelouse, newPosition.getY())) {
            position.setX(newPosition.getX());
            position.setY(newPosition.getY());
            return true;
        } else if (isRightLeftMovement()) {
            position.setOrientation(newPosition.getOrientation());
            return true;
        }
        return false;
    }

    private boolean isRightLeftMovement() {
        return this instanceof RightMovement || this instanceof LeftMovement;
    }

    protected abstract Position getNewPosition(Position originalPosition);


    protected boolean isBadYPosition(Pelouse pelouse, int y) {
        return y < 0 || y > pelouse.getSize().getY();
    }

    protected boolean isBadXPosition(Pelouse pelouse, Integer x) {
        return x < 0 || x > pelouse.getSize().getX();
    }
}

package now.it.now.tondeuse.model;

import now.it.now.tondeuse.service.ForwardMovement;
import now.it.now.tondeuse.service.LeftMovement;
import now.it.now.tondeuse.service.Movement;
import now.it.now.tondeuse.service.RightMovement;

/**
 * Created by fatma on 26/11/2018.
 */
public enum Instruction {

    /**
     * FORWARD movement
     */
    A {
        @Override
        public Movement create() {
            return new ForwardMovement();
        }
    },
    /**
     * RIGHT Movement
     **/
    D {
        @Override
        public Movement create() {
            return new RightMovement();
        }
    },
    /**
     * Left movement
     */
    G {
        @Override
        public Movement create() {
            return new LeftMovement();
        }
    };

    public abstract Movement create();
}

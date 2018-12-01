package now.it.now.tondeuse.model;

import now.it.now.tondeuse.service.ForwardMovement;
import now.it.now.tondeuse.service.LeftMovement;
import now.it.now.tondeuse.service.Movement;
import now.it.now.tondeuse.service.RightMovement;

/**
 * Created by fatma on 26/11/2018.
 */
public enum Instruction {

    A {
        @Override
        public Movement create() {
            return new ForwardMovement();
        }
    }, D {
        @Override
        public Movement create() {
            return new RightMovement();
        }
    }, G {
        @Override
        public Movement create() {
            return new LeftMovement();
        }
    };

    public abstract Movement create();
}

package now.it.now.tondeuse;

import now.it.now.tondeuse.model.*;
import now.it.now.tondeuse.service.MovementsExecutor;
import now.it.now.tondeuse.service.ForwardMovement;
import now.it.now.tondeuse.service.LeftMovement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static now.it.now.tondeuse.model.Instruction.*;

/**
 * Created by fatma on 26/11/2018.
 */
public class Executor {

    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file-poller-tondeuse.xml");
    }
}

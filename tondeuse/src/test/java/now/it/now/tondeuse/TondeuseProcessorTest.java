package now.it.now.tondeuse;

import now.it.now.tondeuse.file.watcher.PelouseLine;
import now.it.now.tondeuse.file.watcher.TondeuseLine;
import now.it.now.tondeuse.file.watcher.TondeuseProcessor;
import now.it.now.tondeuse.model.Instruction;
import now.it.now.tondeuse.model.Orientation;
import now.it.now.tondeuse.service.MovementsExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Created by fatma on 01/12/2018.
 */
@ContextConfiguration(locations = {"/file-poller-tondeuse.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TondeuseProcessorTest {

    @Autowired
    private TondeuseProcessor processor;

    @Autowired
    private MovementsExecutor movementsExecutor;

    @Test(expected = IllegalStateException.class)
    public void testProcessorWithoutHeader() {
        processor.process(new TondeuseLine());
    }

    @Test
    public void testProcessor() {
        PelouseLine header = new PelouseLine(2, 2);
        TondeuseLine line = new TondeuseLine();
        line.setOrientation(Orientation.N);
        line.setTondeuseX(1);
        line.setTondeuseY(1);
        line.setInstructions(Arrays.asList(new Instruction[]{Instruction.A}));
        processor.processWithHeader(header, line);
    }

}

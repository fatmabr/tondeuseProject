import file.watcher.handler.ProcessorRegistry;
import file.watcher.processor.AbstractFileProcessor;
import model.TesterCsvParser;
import model.TesterProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fatma on 01/12/2018.
 */
@ContextConfiguration("/file-poller-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProcessorRegistryTest {

    @Autowired
    private ProcessorRegistry processorRegistry;

    @Test
    public void fetchProcessorWithGoodFileNameShouldReturnPProcessor() {
        AbstractFileProcessor abstractFileProcessor = processorRegistry.matchProcessor("testxx.csv");
        Assert.assertNotNull(abstractFileProcessor) ;
        Assert.assertTrue(abstractFileProcessor instanceof TesterProcessor);
        Assert.assertTrue(abstractFileProcessor.getFileParser() instanceof TesterCsvParser);
    }


    @Test
    public void fetchProcessorWithBadFileNameShouldReturnNull() {
        AbstractFileProcessor abstractFileProcessor = processorRegistry.matchProcessor("xx.csv");
        Assert.assertNull(abstractFileProcessor);
    }

}

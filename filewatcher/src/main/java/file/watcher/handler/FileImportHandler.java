package file.watcher.handler;

import au.com.bytecode.opencsv.CSVReader;
import file.watcher.line.Header;
import file.watcher.line.Line;
import file.watcher.parser.FileParser;
import file.watcher.processor.AbstractFileProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * Created by bradai on 28/06/2017.
 */

/**
 * FileImportHandler handles the injected files in the watched dir.
 */
@Component
public class FileImportHandler implements InitializingBean {

    Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private ProcessorRegistry registry;

    @Value("${watched.file}")
    private String watchedDir;

    public void handle(File file) throws IOException {
        final AbstractFileProcessor fileProcessor = registry.matchProcessor(file.getName());
        if (fileProcessor != null) {
            FileParser fileParser = fileProcessor.getFileParser();
            CSVReader csvReader = fileParser.parse(file);
            Line line;
            Header header = null;
            if (fileParser.getHeaderLinesCount() != 0) {
                header = fileParser.readFileHeader(csvReader);
            }
            while ((line = fileParser.readNextItem(csvReader)) != null) {
                if (fileParser.getHeaderLinesCount() != 0) {
                    fileProcessor.processWithHeader(header, line);
                } else {
                    fileProcessor.process(line);
                }
            }
        }
    }

    public void afterPropertiesSet() throws Exception {
        Path dir = Paths.get(watchedDir);
        WatchService watcher = FileSystems.getDefault().newWatchService();
        WatchKey key = dir.register(watcher,
                StandardWatchEventKinds.ENTRY_CREATE);
        final FileImportListener importListener = new FileImportListener(dir, watcher, this);
        final Thread thread = new Thread(importListener);
        logger.info("WATCHED DIR LOG: " +watchedDir);
        System.out.print("WATCHED DIR LOG PRINT: " +watchedDir);
        thread.start();
    }
}

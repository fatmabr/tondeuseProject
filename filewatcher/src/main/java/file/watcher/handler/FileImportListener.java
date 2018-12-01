package file.watcher.handler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

/**
 * Created by bradai on 28/06/2017.
 */
/**
 * Listener to the configured watched dir.
 */
public class FileImportListener implements Runnable {

    private WatchService watcher;
    private FileImportHandler handler;
    private Path dir;

    public FileImportListener(Path dir, WatchService watcher, FileImportHandler handler) {
        this.watcher = watcher;
        this.handler = handler;
        this.dir = dir;
    }

    public void run() {
        while (true) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException ex) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path fileName = ev.context();

                System.out.println(kind.name() + ": " + fileName.toString());

                if (kind == ENTRY_CREATE) {
                    System.out.println("File imported !!!");
                    try {
                        handler.handle(new File(dir.toString()+"\\" +fileName.toString()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}

package file.watcher.parser;

import au.com.bytecode.opencsv.CSVReader;
import file.watcher.line.Header;
import file.watcher.line.Line;

import java.io.File;
import java.util.List;

/**
 * Created by bradai on 28/06/2017.
 */
public interface FileParser {

     Character lineItemSeparator =';';

     CSVReader parse(File file);

     Line newItem(List<String[]> line);

     Header readFileHeader(CSVReader csvReader);

     Line readNextItem(CSVReader csvReader);

     int getHeaderLinesCount();

     int getLinePerItem();

     Character getLineItemSeparator();
}

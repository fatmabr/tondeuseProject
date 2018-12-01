package model;

import file.watcher.line.Line;
import file.watcher.parser.CSVFileParser;

import java.util.List;

/**
 * Created by fatma on 01/12/2018.
 */
public class TesterCsvParser extends CSVFileParser {
    @Override
    public Line newItem(List<String[]> line) {
        return null;
    }

    @Override
    public int getHeaderLinesCount() {
        return 0;
    }

    @Override
    public int getLinePerItem() {
        return 0;
    }
}

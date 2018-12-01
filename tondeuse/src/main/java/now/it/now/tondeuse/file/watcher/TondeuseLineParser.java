package now.it.now.tondeuse.file.watcher;

import au.com.bytecode.opencsv.CSVReader;
import file.watcher.line.Header;
import file.watcher.line.Line;
import file.watcher.parser.CSVFileParser;
import now.it.now.tondeuse.model.Instruction;
import now.it.now.tondeuse.model.Orientation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by fatma on 30/11/2018.
 */
public class TondeuseLineParser extends CSVFileParser {
    /**
     * first line in the file represents the "pelouse" max X size and max Y size.
     */
    public static final int headerLinesCount = 1;
    /**
     * Every "Tondeuse" is given in two consecutive lines of the file.
     * First line is the initial position
     * Second line is the instructions to be fulfilled by the "Tondeuse".
     */
    public static final int linePerItem = 2;

    public final static Character lineItemSeparator = ' ';



    public Line newItem(List<String[]> lines) {
        if (lines.size() == headerLinesCount) {
            int pelouseXSise = Integer.parseInt(lines.get(0)[0]);
            int pelouseYSise = Integer.parseInt(lines.get(0)[1]);
            return new PelouseLine(pelouseXSise, pelouseYSise);
        } else if (lines.size() == linePerItem) {
            TondeuseLine tondeuse = new TondeuseLine();
            int tondeuseInitialX = Integer.parseInt(lines.get(0)[0]);
            tondeuse.setTondeuseX(tondeuseInitialX);
            int tondeuseInitialY = Integer.parseInt(lines.get(0)[1]);
            tondeuse.setTondeuseY(tondeuseInitialY);
            tondeuse.setOrientation(Orientation.valueOf(lines.get(0)[2]));
            List<Instruction> instructions = getInstructions(lines);
            tondeuse.setInstructions(instructions);
            return tondeuse;
        }
        throw new IllegalStateException("Problem in the file Format!");
    }

    private List<Instruction> getInstructions(List<String[]> lines) {
        String[] strings = lines.get(1);
        char[] chars = strings[0].toCharArray();
        List<Instruction> instructions = new ArrayList<>();
        for (Character instructionV : chars) {
            Instruction instruction = Instruction.valueOf(instructionV.toString());
            if (instruction != null) {
                instructions.add(instruction);
            }
        }
        return instructions;
    }

    public int getHeaderLinesCount() {
        return headerLinesCount;
    }

    public int getLinePerItem() {
        return linePerItem;
    }

    @Override
    public Character getLineItemSeparator() {
        return lineItemSeparator;
    }
}

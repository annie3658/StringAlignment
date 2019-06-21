import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String fileName = "input.txt";
        List<String> inputString = getInputStrings(fileName);
        Map<Pair<Integer, Integer>, CleanText> originalTextOffsets = findCleanTextInOriginal(inputString);
        for (Map.Entry<Pair<Integer, Integer>, CleanText> entry : originalTextOffsets.entrySet()) {
            System.out.println("Original text offset: " + entry.getKey());
            System.out.println(entry.getValue().toString());
        }

    }

    private static List<String> getInputStrings(String fileName) {
        String line;
        List<String> inputTexts = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                inputTexts.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

        return inputTexts;
    }

    private static Map<Pair<Integer, Integer>, CleanText> findCleanTextInOriginal(List<String> inputs) {

        Map<Pair<Integer, Integer>, CleanText> originalTextOffsets = new LinkedHashMap<>();
        String original = inputs.get(NumberUtils.INTEGER_ZERO);
        String clean = inputs.get(NumberUtils.INTEGER_ONE);

        StringBuilder match = new StringBuilder();

        int j = NumberUtils.INTEGER_ZERO;
        int i = NumberUtils.INTEGER_ZERO;

        while (i < original.length() && j < clean.length()) {

            if (original.charAt(i) == clean.charAt(j)) {
                match.append(original.charAt(i));
                j++;
            } else {
                setFoundText(originalTextOffsets, match, j, i);
            }
            i++;
        }
        setFoundText(originalTextOffsets, match, j, i);

        return originalTextOffsets;

    }

    private static void setFoundText(Map<Pair<Integer, Integer>, CleanText> originalTextOffsets, StringBuilder match, int j, int i) {
        if (!match.toString().equals(StringUtils.EMPTY)) {

            int startRangeClean = (j - 1) - match.toString().length() + 1;
            int startRangeOriginal = (i - 1) - match.toString().length() + 1;

            CleanText cleanTextOffsets = new CleanText(startRangeClean, j - 1, match.toString());

            Pair pair = new Pair(startRangeOriginal, i - 1);
            originalTextOffsets.put(pair, cleanTextOffsets);

            match.setLength(NumberUtils.INTEGER_ZERO);
        }
    }
}

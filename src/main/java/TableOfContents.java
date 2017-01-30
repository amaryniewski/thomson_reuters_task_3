import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by adrianmaryniewski on 28.01.2017.
 */
public class TableOfContents {
    public static void parseTxtFile(String fileName) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;

            ArrayList<Integer> knotsOfCurrentSection = new ArrayList<>();
            Integer currentLineNumberInSection = 0;
            Integer maxAmountOfLinesInSection = 0;

            while ((line = reader.readLine()) != null) {
                String[] dividedLine = line.split(",");

                if (isaSectionHeader(dividedLine)) {
                    maxAmountOfLinesInSection = Integer.parseInt(dividedLine[2].trim());
                    knotsOfCurrentSection.clear();
                    currentLineNumberInSection = 0;
                    System.out.println("SECTION HEADER: " + dividedLine[1].trim());
                } else {
                    knotsOfCurrentSection.add(Integer.parseInt(dividedLine[6].trim()));
                    currentLineNumberInSection++;
                }

                countTheHighestKnotsValueOfCurrentSection(knotsOfCurrentSection, currentLineNumberInSection, maxAmountOfLinesInSection);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void countTheHighestKnotsValueOfCurrentSection(ArrayList<Integer> knotsOfCurrentSection, Integer currentLineNumberInSection, Integer maxAmountOfLinesInSection) {
        Integer theHighestValueOfKnots;
        if (currentLineNumberInSection == maxAmountOfLinesInSection) {
            theHighestValueOfKnots = Collections.max(knotsOfCurrentSection);
            System.out.println("theHighestValueOfKnots: " + theHighestValueOfKnots);
        }
    }

    private static boolean isaSectionHeader(String[] dividedLine) {
        return dividedLine.length - 1 == 3;
    }
}

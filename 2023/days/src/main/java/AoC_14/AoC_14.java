package AoC_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC_14 {

    public static void main(String[] args) {

        BufferedReader reader = null;
        List<String> puzzleInput = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("inputDayFourteen.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                puzzleInput.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int totalLoad = calculateTotalLoad(puzzleInput);
        System.out.println("Total Load on North Support Beams: " + totalLoad);
    }

    private static int calculateTotalLoad(List<String> puzzle) {
        int totalLoad = 0;

        for (int i = 0; i < puzzle.size(); i++) {
            for (int j = 0; j < puzzle.get(i).length(); j++) {
                if (puzzle.get(i).charAt(j) == 'O') {
                    totalLoad += puzzle.size() - i;  // Calculate load for rounded rocks
                }
            }
        }

        return totalLoad;
    }
}

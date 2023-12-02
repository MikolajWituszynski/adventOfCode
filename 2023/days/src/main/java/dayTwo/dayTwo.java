package dayTwo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dayTwo {
    public static void main(String[] args) throws FileNotFoundException {
        //Game 1
        //{7: blue, 6: green, 8: red},
        //Game1: 7 blue, 6 green, 3 red; 3 red, 5 green, 1 blue; 1 red, 5 green, 8 blue; 3 red, 1 green, 5 blue

        File file = new File("inputDayTwo.txt");
        BufferedReader reader = null;
        try {
            int counterForText = 0;

            reader = new BufferedReader(new FileReader(file));
            String text = null;
            int counter = 0;
            while ((text = reader.readLine()) != null) {
                counter++;
                System.out.println("counter: " + counter);
                boolean isBlue = countOccurancesOfCubesByColor(text,"blue",14);
                boolean isRed = countOccurancesOfCubesByColor(text,"red",12);
                boolean isGreen = countOccurancesOfCubesByColor(text,"green",13);

                if(isBlue && isRed && isGreen) {
                    System.out.println("counter for text: " + counterForText);
                    counterForText += counter;
                    System.out.println("counter for text after sum: " + counterForText);

                }

            }

            System.out.println(counterForText);

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
        }
    }

    }

    static boolean countOccurancesOfCubesByColor(String line, String color, int limit) {
        Pattern pattern = Pattern.compile("(\\d+) " + Pattern.quote(color));
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            int count = Integer.parseInt(matcher.group(1));
            if (count > limit) {
                return false; // Found an instance exceeding the limit
            }
        }
        return true; // No instances exceeding the limit
    }

}

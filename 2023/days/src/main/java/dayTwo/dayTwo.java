package dayTwo;

import java.io.*;
import java.util.*;
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
            int powerOfCubes = 0;

            reader = new BufferedReader(new FileReader(file));
            String text = null;
            int powerOfLine = 0;
            while ((text = reader.readLine()) != null) {


                int blueValue = countOccurancesOfCubesByColor(text,"blue");
                System.out.println("highest Blue: " + blueValue);
                int redValue = countOccurancesOfCubesByColor(text,"red");
                System.out.println("highest red: " + redValue);
                int greenValue = countOccurancesOfCubesByColor(text,"green");
                System.out.println("highest green: " + greenValue);
                powerOfLine = blueValue * redValue * greenValue;
                powerOfCubes += powerOfLine;

                System.out.println("power Of Line: " + powerOfLine);
            }
            System.out.println(powerOfCubes);

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

    static int countOccurancesOfCubesByColor(String line, String color) {
        Pattern pattern = Pattern.compile("(\\d+) " + Pattern.quote(color));
        Matcher matcher = pattern.matcher(line);
        List<Integer> values = new ArrayList<>();
        while (matcher.find()) {
            int count = Integer.parseInt(matcher.group(1));
            values.add(count);
        }
        System.out.println("array: " + values);
        Collections.sort(values);
        int highestValue = values.get(values.size()-1);
        System.out.println("Highest value: " + highestValue);
        return highestValue; // No instances exceeding the limit
    }

}

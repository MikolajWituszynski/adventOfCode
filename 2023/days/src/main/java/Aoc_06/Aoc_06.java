package Aoc_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aoc_06 {

    public static void main(String[] args) {
        BufferedReader reader = null;
        List<Integer> time = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        StringBuilder timeTwo = new StringBuilder();
        StringBuilder distanceTwo = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader("inputDaySix.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (line.startsWith("Time: ")) {
                        time.add(Integer.parseInt(matcher.group()));
                        timeTwo.append(matcher.group());
                    } else if (line.startsWith("Distance: ")) {
                        distance.add(Integer.parseInt(matcher.group()));
                        distanceTwo.append(matcher.group());

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Time string: " + timeTwo);
        System.out.println("Disatnce string: " + distanceTwo);
        long totalWays = 1;
        for (int i = 0; i < time.size(); i++) {
            int ways = waysToBeatRecord(time.get(i), distance.get(i));
            totalWays *= ways;
        }

        long timeTwoInt = Long.parseLong(timeTwo.toString());
        long distaneTwoInt = Long.parseLong(distanceTwo.toString());
        //partTwo
        long totalWaysTwo = waysToBeatRecord(timeTwoInt,distaneTwoInt);
        System.out.println("Total Ways: " + totalWays);
        System.out.println("Total part Two: " + totalWaysTwo);
    }

    public static int waysToBeatRecord(long totalTime, long recordDistance) {
        int ways = 0;
        for (int i = 0; i < totalTime; i++) {
            long travelTime = totalTime - i;
           long distance = i * travelTime;
            if (distance > recordDistance) {
                ways++;
            }
        }
        return ways;
    }
}

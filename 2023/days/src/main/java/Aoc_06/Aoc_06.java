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
        try {
            reader = new BufferedReader(new FileReader("inputDaySix.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (line.startsWith("Time: ")) {
                        time.add(Integer.parseInt(matcher.group()));
                    } else if (line.startsWith("Distance: ")) {
                        distance.add(Integer.parseInt(matcher.group()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long totalWays = 1;
        for (int i = 0; i < time.size(); i++) {
            int ways = waysToBeatRecord(time.get(i), distance.get(i));
            totalWays *= ways;
        }
        System.out.println("Total Ways: " + totalWays);
    }

    public static int waysToBeatRecord(int totalTime, int recordDistance) {
        int ways = 0;
        for (int i = 0; i < totalTime; i++) {
            int travelTime = totalTime - i;
            int distance = i * travelTime;
            if (distance > recordDistance) {
                ways++;
            }
        }
        return ways;
    }
}

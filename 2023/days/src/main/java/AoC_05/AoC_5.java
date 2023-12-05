package AoC_05;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC_5 {
    public static void main(String[] args) throws FileNotFoundException {

        List<BigInteger> seeds = new ArrayList<>();
        seeds = getSeeds();
        System.out.println("Seeds: " + seeds);
        List<Map> maps = new ArrayList<>();

        maps = creationOfMap(new File("inputDayFive.txt"));

        System.out.println("Maps: " + maps);
        for(Map map : maps) {
            System.out.println("map range : " + map.getRanges());
        }
    }


    static List<Map> creationOfMap(File file) {
        List<Map> allMaps = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean processLines = false;
            String name = null;
            List<Range> rangeForMap = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (processLines) {
                        // End of current section, add map to list
                        Map currentMap = new Map(name);
                        currentMap.setRanges(rangeForMap);
                        allMaps.add(currentMap);

                        // Reset for the next section
                        processLines = false;
                        name = null;
                        rangeForMap = new ArrayList<>();
                    }
                    continue;
                }

                if (processLines) {
                    // Process lines for current map
                    System.out.println("Line: " + line);
                    Matcher matcher = pattern.matcher(line);
                    List<Long> nums = new ArrayList<>();
                    while (matcher.find()) {
                        nums.add(Long.valueOf(matcher.group()));
                    }
                    Range rangeForLine = new Range(nums.get(0), nums.get(1), nums.get(2));
                    rangeForMap.add(rangeForLine);
                }

                if (line.trim().endsWith("map:")) {
                    name = line.substring(0, line.indexOf("map:")).trim();
                    processLines = true; // Start processing new section
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return allMaps;
    }


            static List<BigInteger> getSeeds() {
            BufferedReader reader = null;
            List<BigInteger> seeds = new ArrayList<>();

            try {
                reader = new BufferedReader(new FileReader("inputDayFive.txt"));
                String line = null;
                int counter = 0;

                while ((line = reader.readLine()) != null) {
                    counter++;
                    if (counter == 1) {
                        Pattern pattern = Pattern.compile("\\d+");
                        Matcher matcher = pattern.matcher(line);
                        while (matcher.find()) {
                            seeds.add(BigInteger.valueOf(Long.parseLong(matcher.group())));
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        return seeds;
    }

    static class Range {
        public long dest;
        public long src;
        public long range;

        public Range(long dest,long src,long range) {
            this.dest = dest;
            this.src = src;
            this.range = range;
        }
    }
    static class Map {
        public String name;
        public List<Range> ranges = new ArrayList<>();

        public Map(String name) {
            this.name = name;
        }

        public void setRanges(List<Range> ranges) {
            this.ranges = ranges;
        }

        public List<Range> getRanges() {
            return ranges;
        }
    }
}

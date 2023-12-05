package AoC_03;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC_03 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("inputDayThree.txt"));
            List<Integer> validNumbers = new ArrayList<>();
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            int lineCount = lines.size();
            System.out.println("lines: " + lines);
            int sumOfValidNumbers = 0;
            int sumOfGearRatios = 0;
            for (int i = 0; i < lineCount; i++) {
                String currentLine = lines.get(i);
                String previousLine = i > 0 ? lines.get(i - 1) : null;
                String nextLine = i < lineCount - 1 ? lines.get(i + 1) : null;

                System.out.println("current Line: " + currentLine);

                Matcher matcher = Pattern.compile("\\d+").matcher(currentLine);
                while (matcher.find()) {
                    if (isValidPartNumber(matcher, currentLine, previousLine, nextLine)) {
                        validNumbers.add(Integer.parseInt(matcher.group()));
                        sumOfValidNumbers += Integer.parseInt(matcher.group());
                    }
                }

                sumOfGearRatios +=  calculateGearRatios(currentLine, previousLine, nextLine);

            }

            System.out.println("Total sum of gear ratios: " + sumOfGearRatios);
            System.out.println("sum: " + sumOfValidNumbers);
            System.out.println("valid numbers: " + validNumbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static boolean isValidPartNumber(Matcher matcher, String crLine, String prLine, String nxtLine) {
        int sINum = matcher.start();
        int eINum = matcher.end() - 1; // End index should be inclusive

        int begin = Math.max(0, sINum - 1);
        int end = Math.min(eINum + 1, crLine.length() - 1);
        for (int i = begin; i <= end; i++) {
            if (isSymbol(crLine.charAt(i))) {
                return true;
            }
            if (prLine != null && i < prLine.length() && isSymbol(prLine.charAt(i))) {
                return true;
            }
            if (nxtLine != null && i < nxtLine.length() && isSymbol(nxtLine.charAt(i))) {
                return true;
            }
        }
        if (prLine != null && sINum < prLine.length() && isSymbol(prLine.charAt(sINum))) {
            return true;
        }
        if (nxtLine != null && sINum < nxtLine.length() && isSymbol(nxtLine.charAt(sINum))) {
            return true;
        }
        return false;
    }

    static private boolean isSymbol(char c) {
        return !Character.isDigit(c) && c != '.';
    }

    static int calculateGearRatios(String currentLine, String previousLine, String nextLine) {
        int gearRatioSum = 0;
        for (int j = 0; j < currentLine.length(); j++) {
            if (currentLine.charAt(j) == '*') {
                List<Integer> adjacentNumbers = new ArrayList<>();

                // Check horizontally, vertically, and diagonally adjacent positions
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        if (dx == 0 && dy == 0) continue; // Skip the gear itself

                        int checkY = j + dy;
                        int checkX = j + dx;

                        String lineToCheck = dy == 0 ? currentLine : (dy == -1 ? previousLine : nextLine);
                        if (lineToCheck != null && checkX >= 0 && checkX < lineToCheck.length()) {
                            char charAtPos = lineToCheck.charAt(checkX);
                            if (Character.isDigit(charAtPos)) {
                                adjacentNumbers.add(Character.getNumericValue(charAtPos));
                            }
                        }
                    }
                }

                // Calculate gear ratio if exactly two adjacent numbers are found
                if (adjacentNumbers.size() == 2) {
                    gearRatioSum += adjacentNumbers.get(0) * adjacentNumbers.get(1);
                }
            }
        }
        return gearRatioSum;
    }


    static List<Integer> findNumbersAt(Pattern pattern, String line, int index) {
        List<Integer> numbers = new ArrayList<>();
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.start() <= index && matcher.end() - 1 >= index) {
                numbers.add(Integer.parseInt(matcher.group()));
            }
        }
        return numbers;
    }
}

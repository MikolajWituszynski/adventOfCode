package dayThree;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class dayThree {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("inputDayThree.txt"));
            String line1 = null;
            List<Integer> validNumbers = new ArrayList<>();

            List<String> lines = new ArrayList<>();
            while ((line1 = reader.readLine()) != null) {
                lines.add(line1);
            }
            int lineCount = lines.size();
            System.out.println("lines: " + lines);
            String previousLine = null;
            String currentLine = null;
            String nextLine = null;
            int sumOfValidNumbers = 0;
            for (int i = 0; i < lineCount; i++) {
                var line = lines.get(i);
                if (i > 0) {
                    previousLine = lines.get(i - 1);
                }
                if (i < lineCount - 1) {
                    nextLine = lines.get(i + 1);
                }
                currentLine = line;
                System.out.println("current Line: " + currentLine);
                Pattern numberPattern = Pattern.compile("\\d+");

                Matcher matcher = numberPattern.matcher(currentLine);
                while (matcher.find()) {
                if(isValidPartNumber(matcher,currentLine,previousLine,nextLine)) {
                    validNumbers.add(Integer.parseInt(matcher.group()));
                    sumOfValidNumbers += Integer.parseInt(matcher.group());
                }}
            }

            System.out.println("sum: " + sumOfValidNumbers);
            System.out.println("valid numbers: " + validNumbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static boolean isValidPartNumber(Matcher matcher, String crLine, String prLine, String nxtLine) {
        int sINum = matcher.start();
        int eINum = matcher.end() - 1; // End index should be inclusive

        // Check around the number in the current line
        int begin = Math.max(0, sINum - 1);
        int end = Math.min(eINum + 1, crLine.length() - 1);
        for (int i = begin; i <= end; i++) {
            if (isSymbol(crLine.charAt(i))) {
                return true;
            }
            // Check diagonally in previous and next lines
            if (prLine != null && i < prLine.length() && isSymbol(prLine.charAt(i))) {
                return true;
            }
            if (nxtLine != null && i < nxtLine.length() && isSymbol(nxtLine.charAt(i))) {
                return true;
            }
        }
        // Check directly above and below the number
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
}

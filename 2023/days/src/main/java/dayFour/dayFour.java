package dayFour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dayFour {
    public static void main(String[] args) {
        BufferedReader reader = null;
        int totalPoints = 0;
        try {
            reader = new BufferedReader(new FileReader("inputDayFour.txt"));
            String line = null;
            String lineOne = null;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                counter++;
                if (counter == 1) {
                    lineOne = line;
                }
                System.out.println("Line: " + line);
                int winDig = retrieveWinningNumbers(line);
                totalPoints += winDig;

            }
            System.out.println("total Points: " + totalPoints);


        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    static int retrieveWinningNumbers(String line) {
        List<Integer> winingDigits = new ArrayList<>();
        List<Integer> acquiredDigits = new ArrayList<>();
        System.out.println("Start");
        Pattern pattern = Pattern.compile("\\d{1,2}");
        System.out.println("sub string: " + (line.substring(line.lastIndexOf(":"))));
        Matcher matcher = pattern.matcher(line.substring(line.lastIndexOf(":")));
        int counter = 0;
            while(matcher.find()) {
                counter++;
                if(counter < 11) {
                    winingDigits.add(Integer.valueOf(matcher.group()));
                } if (counter >= 11) {
                    acquiredDigits.add(Integer.valueOf(matcher.group()));
                }
            }
        System.out.println("winning digits: " + winingDigits);
        System.out.println("acquired digits: " + acquiredDigits);
        int numOfWins = 0;
        for (Integer acquiredDigit : acquiredDigits) {
            for (Integer winingDigit : winingDigits) {
                if (Objects.equals(acquiredDigit, winingDigit)) {
                    numOfWins += 1;
                }
            }
        }
        System.out.println("num of wins: " + numOfWins);
        if(numOfWins == 1) {
            return 1;
        } else {
            System.out.println("points in line: " + numOfWins*2);

            return numOfWins*2;
        }
    }
}

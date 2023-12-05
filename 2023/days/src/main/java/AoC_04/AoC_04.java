package AoC_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC_04 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        int totalPoints = 0;
        int numOfCard = 0;

        try {
            reader = new BufferedReader(new FileReader("inputDayFour.txt"));
            String line = null;
            String lineOne = null;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                numOfCard++;
                counter++;
                if (counter == 1) {
                    lineOne = line;
                }
                System.out.println("Line: " + line);
                int winDig = retrieveWonCards(line);
                totalPoints += winDig;

            }
            System.out.println("total Points: " + totalPoints);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    static int retrieveWonCards(String line) {
        List<Integer> winingDigits = new ArrayList<>();
        List<Integer> acquiredDigits = new ArrayList<>();
        System.out.println("Start");
        Pattern pattern = Pattern.compile("\\d{1,2}");
        System.out.println("sub string: " + (line.substring(line.lastIndexOf(":"))));
        Matcher matcher = pattern.matcher(line.substring(line.lastIndexOf(":")));
        int counter = 0;
        while (matcher.find()) {
            counter++;
            if (counter < 11) {
                winingDigits.add(Integer.valueOf(matcher.group()));
            }
            if (counter >= 11) {
                acquiredDigits.add(Integer.valueOf(matcher.group()));
            }
        }
        System.out.println("winning digits: " + winingDigits);
        System.out.println("acquired digits: " + acquiredDigits);
        int numOfWins = winingDigits.size();
        System.out.println("num00: " + numOfWins);

        return numOfWins;
    }

    static List<Integer> retrieveWonCardsList(String line) {
        List<Integer> winingDigits = new ArrayList<>();
        List<Integer> acquiredDigits = new ArrayList<>();
        System.out.println("Start");
        Pattern pattern = Pattern.compile("\\d{1,2}");
        System.out.println("sub string: " + (line.substring(line.lastIndexOf(":"))));
        Matcher matcher = pattern.matcher(line.substring(line.lastIndexOf(":")));
        int counter = 0;
        while (matcher.find()) {
            counter++;
            if (counter < 11) {
                winingDigits.add(Integer.valueOf(matcher.group()));
            }
            if (counter >= 11) {
                acquiredDigits.add(Integer.valueOf(matcher.group()));
            }
        }
        System.out.println("winning digits: " + winingDigits);
        System.out.println("acquired digits: " + acquiredDigits);
        int numOfWins = winingDigits.size();
        System.out.println("num00: " + numOfWins);

        return winingDigits;
    }


    }



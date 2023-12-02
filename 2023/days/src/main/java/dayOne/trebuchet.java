package dayOne;

import java.io.*;
import java.util.*;

public class trebuchet {
    public static void main(String[] args) {
        //read each line
        //in each line check for first and last digit
        //
        //sum everything


        List<Integer> listOfDigits = new ArrayList<Integer>();
        File file = new File("inputDayOne.txt");
        BufferedReader reader = null;
        HashMap<String, String> spelledDigits = new HashMap<>() {{
            put("one", "o1e");
            put("two", "t2o");
            put("three", "t3e");
            put("four", "f4r");
            put("five", "f5e");
            put("six", "s6x");
            put("seven", "s7n");
            put("eight", "e8t");
            put("nine", "n9e");
        }};

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            String allDigToStr =null;
            int sum = 0;
            while ((text = reader.readLine()) != null) {
                String newText = text;
                StringBuilder allDigits = new StringBuilder();
               List<String> listOfDig = new ArrayList<>();
                for (Map.Entry<String, String> entry : spelledDigits.entrySet()) {
                    newText = newText.replaceAll(entry.getKey(),entry.getValue());
                }
                System.out.println("text: " + newText);
                char[] line = newText.toCharArray();
                StringBuilder sb = new StringBuilder();
                Map<Integer, Character> digitsInLine = new LinkedHashMap<>();
                Integer counter = 0;
                for(char c : line)
                {
                    if(Character.isDigit(c)){
                        counter++;
                      digitsInLine.put(counter,c);

                    }
                }
                Map.Entry<Integer,Character> firstEntry = null;
                Map.Entry<Integer,Character> lastEntry = null;
                firstEntry = digitsInLine.entrySet().stream().findFirst().get();
                lastEntry = digitsInLine.entrySet().stream().reduce((first,second) -> second).get();

                Character first = firstEntry.getValue();
                Character last = lastEntry.getValue();

                sb.append(first);
                System.out.println("first: " + first);
                sb.append(last);
                System.out.println("last: " + last);

                Integer digitFromLine = new Integer(sb.toString());

                sum += digitFromLine;




            }
            System.out.println("SUM: " + sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
}

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
        File file = new File("input.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            Integer sum = 0;
            while ((text = reader.readLine()) != null) {
                char[] line = text.toCharArray();
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
                sb.append(last);

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

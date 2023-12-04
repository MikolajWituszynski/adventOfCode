package dayFour;

import java.io.BufferedReader;
import java.io.FileReader;

public class dayFour {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("inputDayFour.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

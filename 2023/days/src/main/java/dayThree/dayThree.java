package dayThree;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// check for symbols and digits in line and at the same time
// first line check for occurances, then second line check if any symbol has index 1 bigger or one smaller than first or last index of digits from first line
//["dog"]
//["cat"]
//Symbols map
//{'*',2}
//Digits map
//{'1',5}
// jesli klucz symbols ma wartosc

//.........398.............551.....................452..................712.996.................646.40...1.....875..958.553...................
//...................................661..-844......*.../781...835..#163....*.......698.239.........*.....*.............*............*57......

public class dayThree {
    public static void main(String[] args) throws FileNotFoundException {
    readLinesFromInput(new File("inputDayThree.txt"));
    }

   static String readLinesFromInput(File file) throws FileNotFoundException {

        BufferedReader reader = null;
        try {
            int powerOfCubes = 0;
            reader = new BufferedReader(new FileReader(file));
            String line1 = null;
            String line2 = null;
            int powerOfLine = 0;
            int counter = 0;
            Queue<String> queue = new LinkedList<>();
            String tempLine = null;
            List<String> lines = new ArrayList<>();

            while ((line1 = reader.readLine()) != null) {
                lines.add(line1);
            }

            System.out.println("lines: " + lines);

            for(int i = 0; i<lines.size(); i++) {
                String previousLine = null;
                String currentLine = null;
                String nextLine = null;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    return "test";
    }




}

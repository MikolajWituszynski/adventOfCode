package AoC_08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//jesli w stringbuilder mamy L to wtedymamy mape
// {AAA, [asea,aasdas]}
//mapa <String, List<String>
//if L then map.getKey().get(0)
// for(Values in Map)
//if  map contain asdasd

public class AoC_08 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        StringBuilder instruction = new StringBuilder();
        HashMap<String, ArrayList<String>> coordinates = new HashMap<>();

        List<String> cords = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("inputDayEight.txt"));
            String line;

            int counter = 0;
            while ((line = reader.readLine()) != null) {
                counter++;
              if(counter == 1) {
                instruction.append(line);
              } else {

                  String[] parts = line.split("=");

                  for(String part: parts) {
                      System.out.println("Part: " + part);
                  }
                  if(parts.length >= 2) {
                      String key = parts[0].trim();
                      System.out.println(key);
                      String values = parts[1].trim();

                      if(key.matches("[a-zA-Z]{3}")) {
                          Pattern pattern = Pattern.compile("[a-zA-Z]{3}");
                          Matcher matcher = pattern.matcher(values);

                          while(matcher.find()) {
                              String match = matcher.group(0);
                              coordinates.computeIfAbsent(key, k -> new ArrayList<>()).add(match);
                          }
                      }
                  }


              }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Cords: " + coordinates);

        System.out.println("instruction: " + instruction);
    }




}

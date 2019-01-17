import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Day2 {

    public static void main(String[] args) {

      String fileName = "resources/day2_01_input.txt";
      List<String> input = new ArrayList<>();

      try{
        Stream<String> lines = Files.lines(Paths.get(fileName));
        lines.forEach(input::add);
        lines.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
//      System.out.println("input: " + input.toString());
      System.out.println("Part1 answer: " + part1FindCheckSum(input));
      System.out.println("Part2 answer: " + part2(input));
    }

    private static int part1FindCheckSum(List<String> inputList) {
      int countFor2 = 0;
      int countFor3 = 0;

      for (String str: inputList) {
        Map<Character, Integer> charCount = new HashMap<>();
        str.chars().mapToObj(c -> (char) c).forEach(c -> {
          if (!charCount.containsKey(c)) {
            charCount.put(c, 1);
          } else {
            int currCount = charCount.get(c);
            charCount.put(c, currCount + 1);
          }
        });

        boolean exsist2Before = false;
        boolean exsist3Before = false;
        //Loop through the map https://javatutorial.net/java-iterate-hashmap-example
        for (Map.Entry<Character, Integer> entry: charCount.entrySet()) {
          if (entry.getValue() == 2 && !exsist2Before) {
            exsist2Before = true;
            countFor2++;
          }
          if (entry.getValue() == 3 && !exsist3Before) {
            exsist3Before = true;
            countFor3++;
          }
        }

      }
      return countFor2 * countFor3;
    }

    private static String part2(List<String> inputList){
      StringBuilder matchingStringBuilder = new StringBuilder();

      for (String str: inputList) {
        for (String str2: inputList){
          for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str2.charAt(i)) {
              matchingStringBuilder.append(str.charAt(i));
            }
          }
          if (matchingStringBuilder.length() == str.length() - 1){
            return matchingStringBuilder.toString();
          }  else {
            matchingStringBuilder.setLength(0);
          }
        }
      }
      return null;
    }
}

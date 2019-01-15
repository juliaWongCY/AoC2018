import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day1 {

    public static void main(String[] args) {
        //https://examples.javacodegeeks.com/core-java/java-8-read-file-line-line-example/

        String fileName = "resources/day1_01_input.txt";
        List<Integer> input = new ArrayList<>();

        try  {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            lines.forEach(e -> input.add(Integer.parseInt(e)));
            lines.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Part 1 sum: " + part1(input));
        System.out.println("Part 2 result: " + part2(input));
    }

    private static int part1(List<Integer> inputList) {
        return inputList.stream().reduce(0, (a, b) -> a + b);
    }

    //To get the first frequency that duplicates
    private static int part2(List<Integer> inputList) {
        List<Integer> tmpSumList = new ArrayList<>();
        int result = 0;

        while (true) {
            for (int i: inputList) {
                if (tmpSumList.contains(result)) {
                    return result;
                }
                tmpSumList.add(result);
                result += i;
            }
        }
    }
}

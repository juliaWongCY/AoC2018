import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class day1 {

    public static void main(String[] args) {
        //https://examples.javacodegeeks.com/core-java/java-8-read-file-line-line-example/

        String fileName = "resources/day1_01_input.txt";
        List<Integer> input = new ArrayList<>();

        try  {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            lines.forEach(e -> {
                input.add(Integer.parseInt(e));
//                System.out.println(e);
            });
            lines.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        int sum = input.stream().reduce(0, (a, b) -> a + b);

        System.out.println("input size: " + input.size());
        System.out.println("input sum: " + sum);
    }
}

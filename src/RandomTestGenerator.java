import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class RandomTestGenerator {

    public static final int MAX_BOUND = 10;

    public static void generateTests(int numTests, int arraySize, String filename) throws IOException {
        Random rand = new Random();
        try (FileWriter fw = new FileWriter(filename)) {
            System.out.println("Random: Generating " + numTests + " tests in " + filename + "...");
            fw.write("Generate Random Number Tests\n");

            int key = rand.nextInt(MAX_BOUND);
            fw.write(key + "\n");
            for (int i = 0; i < numTests; i++) {
                int[] array = new int[arraySize];
                for (int j = 0; j < arraySize; j++) {
                    array[j] = rand.nextInt(MAX_BOUND);
                }


                for(int num : array) {
                    fw.write(num + " ");
                }
                fw.write("\n"); // Ensure each test case is on a new line

            }
            fw.write("\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

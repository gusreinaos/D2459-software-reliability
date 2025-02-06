import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class PairWiseTestGenerator {

    public static final int MAX_BOUND = 100;

    public static void generateTests(int numTests, int arraySize, String fileName) throws IOException {
        Random rand = new Random();

        try (FileWriter fw = new FileWriter(fileName)) {
            for (int test = 0; test < numTests; test++) {
                int[] array = new int[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    array[i] = rand.nextInt(MAX_BOUND);
                }

                // Generate 0-pairs
                fw.write("0-pairs\n");
                for (int i = 0; i < arraySize; i++) {
                    fw.write(array[i] + " ");
                }
                fw.write("\n\n");

                // Generate 1-pairs
                fw.write("1-pairs\n");
                for (int i = 0; i < arraySize; i++) {
                    int[] tempArray = Arrays.copyOf(array, arraySize);
                    tempArray[i] = rand.nextInt(MAX_BOUND);
                    for (int j = 0; j < arraySize; j++) {
                        fw.write(tempArray[j] + " ");
                    }
                    fw.write("\n");
                }
                fw.write("\n");

                // Generate 2-pairs
                fw.write("2-pairs\n");
                for (int i = 0; i < arraySize - 1; i++) {
                    for (int j = i + 1; j < arraySize; j++) {
                        int[] tempArray = Arrays.copyOf(array, arraySize);
                        tempArray[i] = rand.nextInt(MAX_BOUND);
                        tempArray[j] = rand.nextInt(MAX_BOUND);
                        for (int k = 0; k < arraySize; k++) {
                            fw.write(tempArray[k] + " ");
                        }
                        fw.write("\n");
                    }
                }
                fw.write("\n");
            }
        }
    }
}

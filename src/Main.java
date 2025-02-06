import Original.MembershipQuery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomTestGenerator.generateTests(2, 5, "Tests.txt");
        PairWiseTestGenerator.generateTests(1, 5, "Tests.txt");

        FileReader fr = new FileReader("Tests.txt");
        BufferedReader br = new BufferedReader(fr);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();

        processLines(lines);
    }

    public static void processLines(List<String> lines) {
        Integer key = null;
        boolean processingValues = false;

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            // Check for "-pairs" in the current line
            if ((line.contains("Generate Random Number Tests") || line.contains("-pairs")) && i + 1 < lines.size()) {
                try {
                    key = Integer.parseInt(lines.get(i + 1).trim()); // Extract key from the next line
                    processingValues = true;
                    i++; // Skip the next line since we just read it as the key
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing key: " + lines.get(i + 1));
                    key = null;
                    processingValues = false;
                }
            }
            // If processing values, and we encounter a non-empty line, process it
            else if (processingValues && !line.isEmpty()) {
                try {
                    int[] test = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    boolean result = Original.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                    System.out.println("isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + result);

                    // run each mutant
                    int[] mutantCheck = new int[6];
                    try{
                        boolean mutant1Result = Mutations.Mutation1.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                        mutantCheck[0]++;
                        boolean mutant2Result = Mutations.Mutation2.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                        mutantCheck[1]++;
                        boolean mutant3Result = Mutations.Mutation3.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                        mutantCheck[2]++;
                        boolean mutant4Result = Mutations.Mutation4.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                        mutantCheck[3]++;
                        boolean mutant5Result = Mutations.Mutation5.MembershipQueryUnsortedMutation1.isMemberOfUnsorted(test, key);
                        mutantCheck[4]++;
                        boolean mutant6Result = Mutations.Mutation6.MembershipQueryUnsortedMutation2.isMemberOfUnsorted(test, key);
                        mutantCheck[5]++;

                        System.out.println("Test: " + line + " resulted in " + Arrays.toString(mutantCheck));

//                        System.out.println("Mutant1: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant1Result);
//                        System.out.println("Mutant2: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant2Result);
//                        System.out.println("Mutant3: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant3Result);
//                        System.out.println("Mutant4: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant4Result);
//                        System.out.println("Mutant5: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant5Result);
//                        System.out.println("Mutant6: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant6Result);
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage() + " at line: " + lines.get(i) + " at " + e.fillInStackTrace());
                        throw new RuntimeException("Error parsing test values: " + line);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing test values: " + line);
                    throw new RuntimeException("Error parsing test values: " + line);
                }
            }
            // If an empty line is encountered, reset the key
            else if (line.isEmpty()) {
                key = null;
                processingValues = false;
            }
        }
    }
}
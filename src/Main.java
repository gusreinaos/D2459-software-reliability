import Original.MembershipQuery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
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

            // execute original function
            System.out.println("Running original\n");
            processLines(lines, 0);

            int mutantVal = 1;
            // check all mutants
            for(int i = 0; i < 6; i++){
                System.out.println("--------------------  Running mutant " + mutantVal + "  --------------------\n");
                processLines(lines, mutantVal);
                mutantVal++;
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void processLines(List<String> lines, int mutantVal) throws Exception {
        Integer key = null;
        boolean processingValues = false;
        int testPassed = 0;

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

                    try{
                        //check which mutant function we are on
                        switch(mutantVal){
                            case 1:
                                boolean mutant1Result = Mutations.Mutation1.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                                System.out.println("Mutant1: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant1Result);
                                testPassed++;
                                break;
                            case 2:
                                boolean mutant2Result = Mutations.Mutation2.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                                System.out.println("Mutant2: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant2Result);
                                testPassed++;
                                break;
                            case 3:
                                boolean mutant3Result = Mutations.Mutation3.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                                System.out.println("Mutant3: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant3Result);
                                testPassed++;
                                break;
                            case 4:
                                boolean mutant4Result = Mutations.Mutation4.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                                System.out.println("Mutant4: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant4Result);
                                testPassed++;
                                break;
                            case 5:
                                boolean mutant5Result = Mutations.Mutation5.MembershipQueryUnsortedMutation1.isMemberOfUnsorted(test, key);
                                System.out.println("Mutant5: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant5Result);
                                testPassed++;
                                break;
                            case 6:
                                boolean mutant6Result = Mutations.Mutation6.MembershipQueryUnsortedMutation2.isMemberOfUnsorted(test, key);
                                System.out.println("Mutant6: isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + mutant6Result);
                                testPassed++;
                                break;
                            default:
                                boolean result = Original.MembershipQueryUnsorted.isMemberOfUnsorted(test, key);
                                System.out.println("isMember(" + Arrays.toString(test) + ", " + key + ") returned: " + result);
                                testPassed++;
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Error parsing test: " + lines.get(i) + " with error " + e.getMessage());
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Error parsing test values: " + line);
                }
            }
            // If an empty line is encountered, reset the key
            else if (line.isEmpty()) {
                key = null;
                processingValues = false;
            }
        }

        System.out.println("\n------------------------------------------");
        System.out.println("Tests passed (no crashes): " + testPassed + "\n");
    }
}
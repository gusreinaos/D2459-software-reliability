import java.io.IOException;

public class TestRunner {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello, World!");
        RandomTestGenerator.generateTests(2, 5, "Tests.txt");

//        Original.MembershipQuery.isMember(..) for key
    }
}
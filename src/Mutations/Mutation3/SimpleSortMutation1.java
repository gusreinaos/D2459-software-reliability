package Mutations.Mutation3;

public class SimpleSortMutation1 {
    public static void sort(int[] A) {
        for (int i = 0; i < A.length; i++) { // CHANGED: not taking one away in the length
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
}

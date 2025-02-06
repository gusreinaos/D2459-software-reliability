package Mutations.Mutation4;

public class SimpleSortMutation2 {
    public static void sort(int[] A) throws Exception {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] < A[j + 1]) { // CHANGED: comparison, now it sorts in descending order
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
}

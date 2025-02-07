package Mutations.Mutation3;

public class SimpleSortMutation1 {
    public static void sort(int[] A) throws Exception{
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] < A[j + 1]) { // CHANGED: descending orer
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
}

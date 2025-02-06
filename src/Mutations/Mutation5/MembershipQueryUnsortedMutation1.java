package Mutations.Mutation5;

public class MembershipQueryUnsortedMutation1 {
    public static boolean isMemberOfUnsorted(int[] A, int key) {
        // CHANGED: Not sorting
        return MembershipQuery.isMember(A, key);
    }
}

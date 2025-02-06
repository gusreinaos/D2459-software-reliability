package Mutations.Mutation6;

public class MembershipQueryUnsortedMutation2 {
    public static boolean isMemberOfUnsorted(int[] A, int key) throws Exception {
        SimpleSort.sort(A);
        // CHANGED: Ignore result of is member, so it always return false
        MembershipQuery.isMember(A, key);
        return false;
    }
}

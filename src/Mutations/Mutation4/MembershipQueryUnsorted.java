package Mutations.Mutation4;

public class MembershipQueryUnsorted {
    public static boolean isMemberOfUnsorted(int[] A, int key) throws Exception {
        // pre sort array before searching
        SimpleSortMutation2.sort(A);
        // then do binary search on sorted array
        return MembershipQuery.isMember(A, key);
    }
}


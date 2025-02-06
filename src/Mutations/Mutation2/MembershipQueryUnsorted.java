package Mutations.Mutation2;

public class MembershipQueryUnsorted {
    public static boolean isMemberOfUnsorted(int[] A, int key) throws Exception {
        // pre sort array before searching
        SimpleSort.sort(A);
        // then do binary search on sorted array
        return MembershipQueryMutation2.isMember(A, key);
    }
}


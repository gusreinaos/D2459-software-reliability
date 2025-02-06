package Mutations.Mutation1;

public class MembershipQueryUnsorted {
    public static boolean isMemberOfUnsorted(int[] A, int key) throws ArrayIndexOutOfBoundsException {
        // pre sort array before searching
        SimpleSort.sort(A);
        // then do binary search on sorted array
        return MembershipQueryMutation1.isMember(A, key);
    }
}


package Original;

public class MembershipQueryUnsorted {
    public static boolean isMemberOfUnsorted(int[] A, int key) {
        // pre sort array before searching
        SimpleSort.sort(A);
        // then do binary search on sorted array
        return MembershipQuery.isMember(A, key);
    }
}


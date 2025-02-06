package Original;

public class MembershipQuery {
    public static boolean isMember(int[] A, int key) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(A[mid] == key) {
                return true;
            }
            else if(A[mid] < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}

public class TestOracle {
    public static boolean checkSortPrecondition(int[] array) {
        return array.length > 1;
    }

    public static boolean checkSortPostcondition(int[] originalArray, int[] sortedArray) {
        if (originalArray.length != sortedArray.length) return false;

        for (int i = 0; i < originalArray.length; i++) {
            if(sortedArray[i] >= sortedArray[i+1]) return false;
        }
        return true;
    }

    public static boolean checkSearchPrecondition(int[] array, Integer key) {
        return array != null && array.length > 1 && key != null;
    }

    public static boolean checkSearchPostcondition(int[] array, Integer key) {
        boolean foundKey = false;
        boolean foundNonKey = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                foundKey = true;
            } else {
                foundNonKey = true;
            }
            if (foundKey && foundNonKey) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkMembershipPreAndPostcondition(boolean isFound) {
        return isFound;
    }

    public static boolean checkBinarySearchPrecondition(int[] array) {
        if (array == null || array.length <= 1) return false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > array[i+1]) return false;
        }
        return true;
    }

    public static boolean checkBinarySearchPostcondition(int[] array, int key) {
        return checkSearchPostcondition(array, key);
    }


}

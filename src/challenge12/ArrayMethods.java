package challenge12;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayMethods {

    // sort array in descending order
    public static int[] sortDescending(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);
        // reverse to get descending
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }
        return result;
    }

    // remove all duplicate values, keep first occurrence order
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (int n : arr) seen.add(n);
        int[] result = new int[seen.size()];
        int i = 0;
        for (int n : seen) result[i++] = n;
        return result;
    }

    // find elements that exist in both arrays
    public static int[] commonElements(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int n : a) setA.add(n);

        List<Integer> common = new ArrayList<>();
        Set<Integer> added = new HashSet<>();
        for (int n : b) {
            if (setA.contains(n) && added.add(n)) {
                common.add(n);
            }
        }

        int[] result = new int[common.size()];
        for (int i = 0; i < common.size(); i++) result[i] = common.get(i);
        return result;
    }

    // find two elements whose sum is closest to zero
    public static int[] closestSumToZero(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        int left = 0;
        int right = sorted.length - 1;
        int minSum = Integer.MAX_VALUE;
        int a = sorted[0], b = sorted[sorted.length - 1];

        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                a = sorted[left];
                b = sorted[right];
            }
            if (sum < 0) left++;
            else right--;
        }
        return new int[]{a, b};
    }

    // find the longest consecutive sequence in an unsorted array
    public static int[] longestConsecutiveSequence(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : arr) numSet.add(n);

        int bestStart = arr[0];
        int bestLen = 0;

        for (int n : arr) {
            if (!numSet.contains(n - 1)) { // n is the start of a sequence
                int current = n;
                int len = 1;
                while (numSet.contains(current + 1)) {
                    current++;
                    len++;
                }
                if (len > bestLen) {
                    bestLen = len;
                    bestStart = n;
                }
            }
        }

        int[] result = new int[bestLen];
        for (int i = 0; i < bestLen; i++) result[i] = bestStart + i;
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 1, 4, 2, 3, 5, 1};
        System.out.println("Original:    " + Arrays.toString(arr));
        System.out.println("Descending:  " + Arrays.toString(sortDescending(arr)));
        System.out.println("No dups:     " + Arrays.toString(removeDuplicates(arr)));

        int[] arr2 = {3, 5, 7, 9};
        System.out.println("Common with " + Arrays.toString(arr2) + ": " + Arrays.toString(commonElements(arr, arr2)));

        int[] mixed = {-5, 2, -3, 4, 1, -1};
        System.out.println("\nClosest to zero pair in " + Arrays.toString(mixed) + ": " + Arrays.toString(closestSumToZero(mixed)));

        int[] unsorted = {49, 1, 3, 200, 2, 4, 70, 5};
        System.out.println("\nLongest consecutive in " + Arrays.toString(unsorted) + ": " + Arrays.toString(longestConsecutiveSequence(unsorted)));
    }
}

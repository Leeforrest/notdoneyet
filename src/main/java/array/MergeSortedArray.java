package array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * author : Forrest
 * date : 2017/7/5.
 * topic from:https://leetcode.com/problems/merge-sorted-array/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/merge_sorted_array.html
 */
public class MergeSortedArray{

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int j = m - 1;
        int k = n - 1;

        while(i >= 0) {
            if(j >= 0 && k >= 0) {
                if(nums1[j] > nums2[k]) {
                    nums1[i] = nums1[j];
                    j--;
                } else {
                    nums1[i] = nums2[k];
                    k--;
                }
            } else if(j >= 0) {
                nums1[i] = nums1[j];
                j--;
            } else if(k >= 0) {
                nums1[i] = nums2[k];
                k--;
            }
            i--;
        }

    }

    public static void main(String[] args) {
        int[]a = {1, 0};
        int[]b = {2};
        new MergeSortedArray().merge(a, 1, b, 1);
    }

}

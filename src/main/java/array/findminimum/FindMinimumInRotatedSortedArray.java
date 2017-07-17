package array.findminimum;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 一个有序数组，但是不知怎地被旋转了，即0,1,2,3,4,5,6,7可能变成4,5,6,7,0,1,2之类的，找出最小值
 * author : Forrest
 * date : 2017/7/12.
 * topic from: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/find_minimum_in_rotated_sorted_array.html
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * 排序算法众多，但是确实二分查找法对本题是比较适合
     * 1）旋转这个有序数组的话，大家可以把他想象成坦克的链条，也可能不太形象，
     * 2）首先这个数组是有序的如果以(startIndex+endIndex)/2(向下取整)为分割点将数组分为左右两部分，右半部分所有值肯定要比左半部分的值都大
     * 3）如果按照方向2->1->0->7->6这种转法，在7转过分割点之前左半部分始终是连续的，即Array[0]<Array[分割点Index]始终成立，那么最小值在右半部分，当7转过
     *      分割点后，左半部分不再连续，右半部分变成连续的Array[分割点Index]<Array[endIndex]始终成立
     * 时，7应该正好在数组
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        //如果数组是完全有序的话，即并没有旋转要单独处理
        if(nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        int end = nums.length-1;
        int start = 0;
        while(start < end-1) {
            int middle = (start + end) / 2;
            if (nums[start] < nums[middle]) {
                start = middle;

            } else {//条件里说了数组里没有重复的数据
                end = middle;
            }
        }
        return Math.min(nums[start], nums[end]);

    }

    public static void main(String[] args) {
        int[]input = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(input));
    }
}

package array.findminimum;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 * 一个有序数组，但是不知怎地被旋转了，即0,1,2,3,4,5,6,7可能变成4,5,6,7,0,1,2之类的，找出最小值，唯一要注意的是这道题里说可能数组中有重复的数据
 * author : Forrest
 * date : 2017/7/12.
 * topic from: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/find_minimum_in_rotated_sorted_array.html
 */
public class FindMinimumInRotatedSortedArrayII {
        /**
         * 这里要考虑的就是重复数据的问题
         * 而上一题Array[start]<Array[middle]最小值在右，Array[start]>Array[middle]最小值在左
         * 只是没有考虑Array[start]==Array[middle]这种情况
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

                int end = nums.length-1;
                int start = 0;
                while(start < end-1) {
                        //如果数组是完全有序的话，即并没有旋转要单独处理
                        if(nums[start] < nums[end]) {
                                return nums[start];
                        }
                        int middle = (start + end) / 2;
                        if (nums[start] < nums[middle]) {
                                start = middle;

                        } else if(nums[start] > nums[middle]) {//条件里说了数组里没有重复的数据
                                end = middle;
                        } else {
                                start ++;
                        }
                }
                return Math.min(nums[start], nums[end]);
        }
}

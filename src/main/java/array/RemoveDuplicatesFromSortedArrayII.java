package array;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * 从排好序的数组中删除重复次数大于2的元素，并且返回数组的长度，{@link RemoveElement}
 * author: Forrest
 * date: 2017/7/4
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int finalLen=0;
        int repeat = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[finalLen] == nums[i]) {
                repeat++;
                if(repeat < 2) {
                    nums[++finalLen] = nums[i];
                }
            } else {
                repeat = 0;
                nums[++finalLen] = nums[i];
            }
        }
        return finalLen+1;
    }

    public static void main(String[] args) {
        int[]array = {1, 1, 1, 2};
        int len = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(array);
        System.out.println(len);
    }
}

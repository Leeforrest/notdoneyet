package array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 给定数组，并且给定一个目标值，从数组中找两个元素，这两个元素的和=目标值，返回这两个元素下标
 * 尝试怎么o(n)的时间复杂度实现
 * author : Forrest
 * date : 2017/7/5.
 * topic from:https://leetcode.com/problems/two-sum/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/sum.html 这里原题和我参考的稍有不同，因为没有限制坐标小的在前
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueIndexMap.put(nums[i], i);
        }
        int[]result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            Integer remainIndex = valueIndexMap.get(remain);
            if (remainIndex != null && remainIndex != i) {
                result[0] = i;
                result[1] = valueIndexMap.get(remain);
                return result;
            }
        }
        return result;
    }
}

package array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本人完成题目顺序：TwoSum->ThreeSum->ThreeSumClosest->FourSum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * 这道题的需求跟3sum一样，只是3改成了4
 * author : Forrest
 * date : 2017/7/11.
 * topic from: https://leetcode.com/problems/4sum/
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/sum.html
 */
public class FourSum {
    /**
     * 看来我是有点懂了这个问题，可以自己写了
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(2000);
        if(nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            int j = i+1;
            while(j < nums.length - 2) {
                int k = j+1;
                int m = nums.length - 1;
                while(k < m) {
                    List<Integer> list = new ArrayList<>(4);
                    int plusResult = nums[i] + nums[j] + nums[k] + nums[m];
                    if(plusResult == target) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        result.add(list);
                        while(m > k && nums[m] == nums[m-1]) {
                            m--;
                        }
                        while(m > k && nums[k] == nums[k+1]) {
                            k++;
                        }
                        k++;
                        m--;
                    } else if(plusResult > target) {
                        m--;
                    } else {
                        k++;
                    }
                }
                while(nums[j+1] == nums[j] && j<nums.length - 2) {
                    j++;
                }
                j++;
            }
            while(i<nums.length-3 && nums[i]==nums[i+1]){
                i++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 0, -1, 0, -2, 2};
        int[]input2 = {-4, 0, 0, 1, 1, 5, 5, 5};
        System.out.println(new FourSum().fourSum(input1, 0));
    }
}

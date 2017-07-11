package array.sum;

import java.util.Arrays;

/**
 * ���������Ŀ˳��TwoSum->ThreeSum->ThreeSumClosest->FourSum
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * ���������һ��Ŀ��ֵA����������������Ҫ����������֮��B��Aֵ��ӽ��������B
 * author : Forrest
 * date : 2017/7/11.
 * topic from: https://leetcode.com/problems/3sum-closest/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/sum.html
 */
public class ThreeSumClosest {
    /**
     * ����ThreeSum�ľ��飬�����ͼ򵥶���
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        if (nums.length <= 2) {
            return result;
        }
        int subtractionValue = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j<k) {
                int tempResult = nums[i] + nums[j] + nums[k];
                int tempSubtractionValue = Integer.MAX_VALUE;
                if(tempResult > target) {
                    tempSubtractionValue = tempResult - target;
                    if(tempSubtractionValue < subtractionValue) {
                        subtractionValue = tempSubtractionValue;
                        result = tempResult;
                    }
                    k--;
                } else if(tempResult < target){
                    tempSubtractionValue = target - tempResult;
                    if(tempSubtractionValue < subtractionValue) {
                        subtractionValue = tempSubtractionValue;
                        result = tempResult;
                    }
                    j++;
                } else {
                    return tempResult;
                }
            }

        }
        return result;
    }
}

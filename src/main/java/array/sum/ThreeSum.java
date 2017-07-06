package array.sum;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 给定数组，找出所有三个数之和为0的组合
 * 这里非常得意的加上了自己的递归实现，然而当输入数组很长时，递归的效率实在低得惨不忍睹，最后还是附上了前辈的实现
 * author : Forrest
 * date : 2017/7/6.
 * topic from: https://leetcode.com/problems/3sum/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/sum.html
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        //这里HashMap的key是List<>.toString()获得，主要用来判断重复的组合比如[-1,0,1],[1,0,-1]这种是重复的，如果我们给他们排序后再toString，将会得到同样的key
        Map<String, List<Integer>> finalResult = new HashMap<>();
        int[]tempResult = new int[3];
        findResult(nums, 0, 3, tempResult, finalResult);
        return new ArrayList<>(finalResult.values());
    }

    /**
     * 非常遗憾我的递归实现在leetcode上提交并没有通过，因为当输入116长度的数组时，计算超时了
     */
    public void findResult(int[]input, int inputStartPos, int resultLen, int[]tempResult, Map<String, List<Integer>> finalResult ) {
        final int finalResultLength = 3;
        if (resultLen == 0) {
            List<Integer>list = new ArrayList<>();
            int sum = 0;
            for (int i : tempResult) {
                list.add(i);
                sum += i;
            }
            if(sum == 0) {
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                });
                finalResult.put(list.toString(), list);
            }
            return;
        }
        for (int i = inputStartPos; i < input.length; i++) {
            tempResult[finalResultLength - resultLen] = input[i];
            findResult(input, i + 1, resultLen - 1, tempResult, finalResult);
        }
    }

    /**
     * 这个前辈的方法，效率比我的递归高出了几十倍，但是理解起来实在有点难度
     */
    public List<List<Integer>>threeSum(List<Integer>nums) {
        List<List<Integer>>result = new ArrayList<>();
        if(nums.size() <= 2){
            return result;
        }
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < nums.size()-2; i++) {
           int j= i+1; 
            int k = nums.size() - 1;
            while(j < k) {
                List<Integer> list = new ArrayList<>();
                if(nums.get(i) + nums.get(j) + nums.get(k) == 0) {
                    list.add(nums.get(i));
                    list.add(nums.get(j));
                    list.add(nums.get(k));
                    result.add(list);
                    ++j;--k;
                    while(j<k && nums.get(j-1) == nums.get(j)) {
                        ++j;
                    }
                    while(j <k && nums.get(k) == nums.get(k+1)) {
                        --k;
                    }
                } else if(nums.get(i) + nums.get(j) + nums.get(k) < 0){
                    ++j;
                } else {
                    --k;
                }
                
            }
            while (i < nums.size()-1 && nums.get(i) == nums.get(i + 1)) {
                ++i;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int[]input1 = {-1, 0, 1, 2, -1, -4};
        int[]input2 = {4,-9,-13,-9,0,-12,12,-14,12,1,3,5,5,8,2,-2,8,1,2,-6,-6,1,6,-15,-2,7,-11,3,-2,1,11,10,8,14,8,-15,9,5,-14,6,14,-3,-12,4,-10,5,-12,13,14,-3,-15,-7,5,-2,-15,10,-10,11,-2,-5,-2,-5,-10,13,-14,14,13,2,4,7,-6,3,11,-3,-15,-14,10,10,6,1,-8,-2,1,12,11,1,7,8,-10,13,-11,3,-15,-6,-7,8,-7,13,-5,5,-3,4,-15,-7,9,-15,-14,-4,2,0,4,9,13,-10,-2,10};
        System.out.println(new ThreeSum().threeSum(input2));
        System.out.println("我的方法耗时:" + (System.currentTimeMillis() - begin));

        List<Integer> listInput = Arrays.asList(ArrayUtils.toObject(input2));
        begin = System.currentTimeMillis();
        System.out.println(new ThreeSum().threeSum(listInput));
        System.out.println("前辈的方法耗时：" + (System.currentTimeMillis() - begin));
        
    }
}

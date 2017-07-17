package array.findminimum;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * һ���������飬���ǲ�֪���ر���ת�ˣ���0,1,2,3,4,5,6,7���ܱ��4,5,6,7,0,1,2֮��ģ��ҳ���Сֵ
 * author : Forrest
 * date : 2017/7/12.
 * topic from: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/find_minimum_in_rotated_sorted_array.html
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * �����㷨�ڶ࣬����ȷʵ���ֲ��ҷ��Ա����ǱȽ��ʺ�
     * 1����ת�����������Ļ�����ҿ��԰��������̹�˵�������Ҳ���ܲ�̫����
     * 2�������������������������(startIndex+endIndex)/2(����ȡ��)Ϊ�ָ�㽫�����Ϊ���������֣��Ұ벿������ֵ�϶�Ҫ����벿�ֵ�ֵ����
     * 3��������շ���2->1->0->7->6����ת������7ת���ָ��֮ǰ��벿��ʼ���������ģ���Array[0]<Array[�ָ��Index]ʼ�ճ�������ô��Сֵ���Ұ벿�֣���7ת��
     *      �ָ�����벿�ֲ����������Ұ벿�ֱ��������Array[�ָ��Index]<Array[endIndex]ʼ�ճ���
     * ʱ��7Ӧ������������
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
        //�����������ȫ����Ļ�������û����תҪ��������
        if(nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        int end = nums.length-1;
        int start = 0;
        while(start < end-1) {
            int middle = (start + end) / 2;
            if (nums[start] < nums[middle]) {
                start = middle;

            } else {//������˵��������û���ظ�������
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

package array.findminimum;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 * һ���������飬���ǲ�֪���ر���ת�ˣ���0,1,2,3,4,5,6,7���ܱ��4,5,6,7,0,1,2֮��ģ��ҳ���Сֵ��ΨһҪע������������˵�������������ظ�������
 * author : Forrest
 * date : 2017/7/12.
 * topic from: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/find_minimum_in_rotated_sorted_array.html
 */
public class FindMinimumInRotatedSortedArrayII {
        /**
         * ����Ҫ���ǵľ����ظ����ݵ�����
         * ����һ��Array[start]<Array[middle]��Сֵ���ң�Array[start]>Array[middle]��Сֵ����
         * ֻ��û�п���Array[start]==Array[middle]�������
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
                        //�����������ȫ����Ļ�������û����תҪ��������
                        if(nums[start] < nums[end]) {
                                return nums[start];
                        }
                        int middle = (start + end) / 2;
                        if (nums[start] < nums[middle]) {
                                start = middle;

                        } else if(nums[start] > nums[middle]) {//������˵��������û���ظ�������
                                end = middle;
                        } else {
                                start ++;
                        }
                }
                return Math.min(nums[start], nums[end]);
        }
}

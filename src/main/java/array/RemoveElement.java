package array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 给定数组，给定一个值，删除数组中与给定值相等的元素，并且返回数组长度，不能创建新的数组，最终数组变成什么样你也不用关心
 * 就是说这里的需求就是要计算去掉数组中指定的元素后数组的长度是多少...
 * author : Forrest
 * date : 2017/7/4.
 * topic from: https://leetcode.com/problems/remove-element/#/description
 * ref: https://siddontang.gitbooks.io/leetcode-solution/content/array/remove_element.html
 */
public class RemoveElement {

    public int solution(int[]array, int input) {
        int finalLen = 0;
        for(int i=0 ; i<array.length ; i++) {
            if (array[i] == input) {
                continue;
            }
            array[finalLen] = array[i];
            finalLen++;
        }
        return finalLen;
    }

    public static void main(String[] args) {
        int[]array = {3, 2, 2, 3};
        System.out.println(new RemoveElement().solution(array, 3));
    }
}

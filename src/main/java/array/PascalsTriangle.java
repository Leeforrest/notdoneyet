package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *        [1],
 *      [1,1],
 *    [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * ��˹�����ǣ�
 *      ��m����m��Ԫ��
 *      ÿ���һ�������һ��Ԫ����1
 *      ��m(m>2)���n(n���ǵ�һ��Ҳ�������һ��)��Ԫ�أ�v[m][n]=v[m-1][n-1] + v[m-1][n]
 * author : Forrest
 * date : 2017/7/5.
 * topic from ��<a>https://leetcode.com/problems/pascals-triangle/#/description</a>
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/pascals_triangle.html
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer>list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    list.add(1);
                    continue;
                }
                if(i > 1) {
                    List<Integer> preRow = result.get(i-1);
                    list.add(preRow.get(j-1) + preRow.get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}

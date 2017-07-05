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
 * 帕斯卡三角：
 *      第m层有m个元素
 *      每层第一个和最后一个元素是1
 *      第m(m>2)层第n(n不是第一个也不是最后一个)个元素，v[m][n]=v[m-1][n-1] + v[m-1][n]
 * author : Forrest
 * date : 2017/7/5.
 * topic from ：<a>https://leetcode.com/problems/pascals-triangle/#/description</a>
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

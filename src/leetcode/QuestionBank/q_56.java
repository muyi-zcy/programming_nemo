package leetcode.QuestionBank;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName q_56.java
 * @Description
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @createTime 2020年01月14日 16:51:00
 */
public class q_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null||intervals.length == 0) {
            return new int[0][];
        }

        //对数组进行排序
        Arrays.sort(intervals, (l, r) -> l[0] - r[0]);

        List<int[]> list=new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty() || list.get(list.size()-1)[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                list.get(list.size()-1)[1] = list.get(list.size()-1)[1]>intervals[i][1]?list.get(list.size()-1)[1]:intervals[i][1];
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3}, {2,6}, {8,10},{15,18}};
        q_56 q=new q_56();
        Console.log(q.merge(nums));
    }
}

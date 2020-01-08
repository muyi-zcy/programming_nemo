package leetcode.weeklyContent;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName q_1310.java
 * @Description
 * 1310. 子数组异或查询 显示英文描述
 * 用户通过次数719
 * 用户尝试次数903
 * 通过次数733
 * 提交次数1344
 * 题目难度Medium
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 * 示例 1：
 *
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * 示例 2：
 *
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 * @createTime 2020年01月08日 15:19:00
 */
public class q_1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] re=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];

            int[] cut= Arrays.copyOfRange(arr,l,r+1);
            int val=cut[0];
            for(int j=1;j<cut.length;j++){
                val=val^cut[j];
            }
            re[i]=val;
        }
        return re;
    }

    public static void main(String[] args) {
        q_1310 q=new q_1310();
        int[] arr =new int[]{4,8,2,10};
        int[][] queries =new int[][]{{2,3},{1,3},{0,0},{0,3}};
        Console.log(q.xorQueries(arr,queries));
    }
}

package leetcode.explore.PrimaryAlgorithm.Array;

import cn.hutool.core.lang.Console;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName array_2.java
 * @Description
 * 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 首先找到买入和卖出的时间规律：当找到一个递归的最小值是买入，找到递归的最大值时卖出
 *
 * @createTime 2020年01月12日 01:48:00
 */
public class array_2 {
    public int maxProfit(int[] prices) {
        int s=0;
        int in=-1;
        int out=0;
        for(int i=0;i<prices.length;i++){
            if(in==-1){
                //准备买入
                in=getInDay(i,prices);
                i=in;
            }else{
                //准备卖出
                out=getOutDay(i,prices);
                s+=prices[out]-prices[in];
                i=out;
                in=-1;
            }
        }
        return s;
    }

    public int getInDay(int i,int[] prices){
        if(i<prices.length-1&&prices[i]>prices[i+1]){
            return getInDay(i+1,prices);
        }else{
            return i;
        }
    }

    public int getOutDay(int i,int[] prices){
        if(i<prices.length-1&&prices[i]<prices[i+1]){
            return getOutDay(i+1,prices);
        }else{
            return i;
        }
    }

    public static void main(String[] args) {
//        int[] nums=new int[]{7,6,4,3,1};
//        int[] nums=new int[]{1,2}; //预期：1
        int[] nums=new int[]{7,1,5,3,6,4};
        array_2 a2=new array_2();
        Console.log(a2.maxProfit(nums));
    }
}

package leetcode.QuestionBank;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ArrayUtil;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName q_1.java
 * @Description
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @createTime 2020年01月08日 00:43:00
 */
public class q_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] re=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    re[0]=i;
                    re[1]=j;
                    break;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        q_1 q1 = new q_1();
        Console.log(q1.twoSum(new int[]{3,3},6));
    }
}

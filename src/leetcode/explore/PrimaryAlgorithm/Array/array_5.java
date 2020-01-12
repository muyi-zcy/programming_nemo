package leetcode.explore.PrimaryAlgorithm.Array;

import cn.hutool.core.lang.Console;

import java.util.Arrays;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName array_5.java
 * @Description
 *
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @createTime 2020年01月12日 19:28:00
 */
public class array_5 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                i++;
            }else{
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        array_5 a5=new array_5();
//        int[] nums=new int[]{4,1,2,1,2};
        int[] nums=new int[]{2,1,1};
        Console.log(a5.singleNumber(nums));
    }
}

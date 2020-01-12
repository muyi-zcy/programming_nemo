package leetcode.explore.PrimaryAlgorithm.Array;

import cn.hutool.core.lang.Console;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName array_4.java
 * @Description
 *
 * 存在重复
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @createTime 2020年01月12日 19:02:00
 */
public class array_4 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null){
                return true;
            }
            map.put(nums[i],nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        array_4 a4=new array_4();
//        int[] nums=new int[]{1,1,1,3,3,4,3,2,4,2};
//        int[] nums=new int[]{1,2,3,4};
        int[] nums=new int[]{};

        Console.log(a4.containsDuplicate(nums));
    }
}

package leetcode.QuestionBank;

import cn.hutool.core.lang.Console;

import java.util.*;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName q_3.java
 * @Description
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @createTime 2020年01月08日 03:16:00
 */
public class q_3 {
    public int lengthOfLongestSubstring(String s) {

        char[] chars=s.toCharArray();
        List<Integer> list=new ArrayList<Integer>();
        Queue<Character> queue=new LinkedList<Character>();

        for(int i=0;i<chars.length;i++){
            int j=0;
            for(Character character:queue){
                if(character.equals(chars[i])){
                    for(int k=0;k<=j;k++){
                        queue.poll();
                    }
                    break;
                }
                j++;
            }
            queue.offer(chars[i]);
            list.add(queue.size());
        }
        int max=0;
        for(Integer integer:list){
            if(integer>max){
                max=integer;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        q_3 q_3=new q_3();
        Console.log(q_3.lengthOfLongestSubstring(""));//0
        Console.log(q_3.lengthOfLongestSubstring(" "));//1
        Console.log(q_3.lengthOfLongestSubstring("abcabcbb"));//3
        Console.log(q_3.lengthOfLongestSubstring("pwwkew"));//3
        Console.log(q_3.lengthOfLongestSubstring("dddddd"));//1
    }
}

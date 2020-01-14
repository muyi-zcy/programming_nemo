package nemo.interview;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName AbbreviationCheck.java
 * @Description
 * 缩写校验（建议时间复杂度 O(n) ）
 *
 * 给定⼀一个⾮非空字符串串 s 和⼀一个缩写 abbr，请校验它们是否匹配。
 *
 * 假设字符串串中只包含⼩小写字⺟母，缩写中只包含⼩小写字⺟母和数字。缩写中的数字
 * 表示其缩略略的字符数；连续多位数字表示⼀一个多位数。
 * 例如，字符串串 “word” 的缩写有且仅有以下这些：
 * [“word", "1ord", "w1rd","wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", “4"]。
 * 例例 1：输⼊入： s = “internationalization"， abbr = "i12iz4n"
 * 返回： true
 * 解释： abbr 中的 12 表示有⼗十⼆二个字符被缩略略了了。
 *
 * 例 2：输⼊入： s = “apple"， abbr = “a2e"
 * 返回： false
 *
 * @createTime 2020年01月14日 17:45:00
 */
public class AbbreviationCheck {

    public boolean isNumber(char c){
        return Character.isDigit(c);
    }

    boolean valid(String word, String abbr){
        char[] c_word=word.toCharArray();
        char[] c_abbr=abbr.toCharArray();

        for (int i=0,j=0;i<c_abbr.length;i++,j++){
            int count=0;
            while (isNumber(c_abbr[i])){
                count=Integer.valueOf(c_abbr[i]+"")+10*count;
                if(i>=c_abbr.length-1){
                    break;
                }else{
                    i++;
                }
            }
            j=j+count;
            if(j>=c_word.length){
                return true;
            }
            if(c_word[j]!=c_abbr[i]){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        AbbreviationCheck abbreviationCheck=new AbbreviationCheck();
        String word="word";
        String abbr="word";
        Console.log(abbreviationCheck.valid(word,abbr));
        Console.log(abbreviationCheck.valid(word,"1ord"));
        Console.log(abbreviationCheck.valid(word,"w1rd"));
        Console.log(abbreviationCheck.valid(word,"wo1d"));
        Console.log(abbreviationCheck.valid(word,"wor1"));
        Console.log(abbreviationCheck.valid(word,"2rd"));
        Console.log(abbreviationCheck.valid(word,"w2d"));
        Console.log(abbreviationCheck.valid(word,"wo2"));
        Console.log(abbreviationCheck.valid(word,"1o1d"));
        Console.log(abbreviationCheck.valid(word,"1or1"));
        Console.log(abbreviationCheck.valid(word,"w1r1"));
        Console.log(abbreviationCheck.valid(word,"1o2"));
        Console.log(abbreviationCheck.valid(word,"2r1"));
        Console.log(abbreviationCheck.valid(word,"3d"));
        Console.log(abbreviationCheck.valid(word,"w3"));
        Console.log(abbreviationCheck.valid(word,"4"));
        Console.log(abbreviationCheck.valid("internationalization","i12iz4n"));
        Console.log(abbreviationCheck.valid("apple","a2e"));
        Console.log(abbreviationCheck.valid("apple","app2"));
        Console.log(abbreviationCheck.valid("apple",""));
    }
}
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        true
//        false
//        true
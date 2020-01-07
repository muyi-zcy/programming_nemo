package pat.B;

import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1002.java
 * @Description
 * 1002 写出这个数
 * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10
 * ​100
 * ​​ 。
 *
 * 输出格式：
 * 在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
 *
 * 输入样例：
 * 1234567890987654321123456789
 *
 * 输出样例：
 * yi san wu
 * @createTime 2020年01月08日 03:32:00
 */
public class pat_1002 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum = 0 ;
        String str = sc.next();
        char[] ch = str.toCharArray();
        for (int i = 0 ; i < ch.length ; i ++) {
            sum +=  new Integer(""+ch[i]).intValue();
        }
        System.out.println(print_f(sum));
    }

    public static String print_f(int sum) {
        int k = 1;
        int m = sum;
        String str = "";
        while (m >= 10) {
            k *= 10 ;
            m /= 10;
        }
        while(k != 0) {
            str += int_to_String(sum / k)+" ";
            sum %= k;
            k /= 10;
        }
        return str.substring(0, str.length()-1);
    }

    //转换
    public static String int_to_String(int n) {
        String ss = "";
        switch (n) {
            case 0:
                ss = "ling";
                break;
            case 1:
                ss = "yi";
                break;
            case 2:
                ss = "er";
                break;
            case 3:
                ss = "san";
                break;
            case 4:
                ss = "si";
                break;
            case 5:
                ss = "wu";
                break;
            case 6:
                ss = "liu";
                break;
            case 7:
                ss = "qi";
                break;
            case 8:
                ss = "ba";
                break;
            case 9:
                ss = "jiu";
                break;
            default:
                break;
        }
        return ss;
    }
}

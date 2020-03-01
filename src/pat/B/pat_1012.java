package pat.B;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1012.java
 * @Description
 * 1012 数字分类 (20分)
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
 *
 * A
 * ​1
 * ​​  = 能被 5 整除的数字中所有偶数的和；
 * A
 * ​2
 * ​​  = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n
 * ​1
 * ​​ −n
 * ​2
 * ​​ +n
 * ​3
 * ​​ −n
 * ​4
 * ​​ ⋯；
 * A
 * ​3
 * ​​  = 被 5 除后余 2 的数字的个数；
 * A
 * ​4
 * ​​  = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
 * A
 * ​5
 * ​​  = 被 5 除后余 4 的数字中最大数字。
 * 输入格式：
 * 每个输入包含 1 个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。数字间以空格分隔。
 *
 * 输出格式：
 * 对给定的 N 个正整数，按题目要求计算 A
 * ​1
 * ​​ ~A
 * ​5
 * ​​  并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 *
 * 若其中某一类数字不存在，则在相应位置输出 N。
 *
 * 输入样例 1：
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 *
 *
 *
 * 输出样例 1：
 * 30 11 2 9.7 9
 *
 *
 *
 * 输入样例 2：
 * 8 1 2 4 5 6 7 9 16
 *
 *
 *
 * 输出样例 2：
 * N 11 2 N 9
 * @createTime 2020年03月01日 20:07:00
 */
public class pat_1012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int A1 = 0;
        List<Integer> A2List = new ArrayList<Integer>();
        int A3 = 0;
        int A4 = 0;
        int A4Count = 0;
        List<Integer> A5List = new ArrayList<Integer>();


        for (int i = 0; i < n; i++) {
            int in = scanner.nextInt();
            int remainder = in % 5;
            switch (remainder) {
                case 0:
                    if (in % 2 == 0) {
                        A1 += in;
                    }
                    break;
                case 1:
                    A2List.add(in);
                    break;
                case 2:
                    A3++;
                    break;
                case 3:
                    A4 += in;
                    A4Count++;
                    break;
                case 4:
                    A5List.add(in);
                    break;
            }
        }

        int flag = 1;
        int A2 = 0;
        for (Integer integer : A2List) {
            A2 += (flag * integer);
            flag *= -1;
        }
        String A4s="N";
        BigDecimal bigDecimal;
        if (A4Count != 0) {
            bigDecimal = new BigDecimal((float) A4 / (float) A4Count);
            A4s=""+bigDecimal.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        Collections.sort(A5List);
        System.out.print(
                (A1==0?"N":A1)+" "+
                        (A2List.size()==0?"N":A2)+" "+
                        (A3==0?"N":A3)+" "+A4s+" "+ (A5List.size()==0?"N":A5List.get(A5List.size()-1)));
    }
}

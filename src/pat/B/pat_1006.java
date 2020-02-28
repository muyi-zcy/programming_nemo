package pat.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1006.java
 * @Description
 * 1006 换个格式输出整数 (15分)
 * 让我们用字母 B 来表示“百”、字母 S 表示“十”，用 12...n 来表示不为零的个位数字 n（<10），换个格式来输出任一个不超过 3 位的正整数。例如 234 应该被输出为 BBSSS1234，因为它有 2 个“百”、3 个“十”、以及个位的 4。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，给出正整数 n（<1000）。
 *
 * 输出格式：
 * 每个测试用例的输出占一行，用规定的格式输出 n。
 *
 * 输入样例 1：
 * 234
 *
 *
 *
 * 输出样例 1：
 * BBSSS1234
 *
 *
 *
 * 输入样例 2：
 * 23
 *
 *
 *
 * 输出样例 2：
 * SS123
 * @createTime 2020年02月29日 00:40:00
 */
public class pat_1006 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.close();
        String s="";
        int size=Integer.toString(n).length();
        for(int i=0;i<size;i++){
            int k=n%10;
            for(int j=1;j<=k;j++){
                if (i == 0) {
                    s=s+j;
                }else if(i==1){
                    s="S"+s;
                }else if(i==2){
                    s="B"+s;
                }
            }

            n=n/10;
        }
        System.out.println(s);
    }
}

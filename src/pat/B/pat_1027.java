package pat.B;

import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1027.java
 * @Description
 * 1027 打印沙漏 (20分)
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
 *
 * *****
 *  ***
 *   *
 *  ***
 * *****
 *
 *
 *
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 *
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 *
 * 输入格式:
 * 输入在一行给出1个正整数N（≤1000）和一个符号，中间以空格分隔。
 *
 * 输出格式:
 * 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 *
 * 输入样例:
 * 19 *
 *
 *
 *
 * 输出样例:
 * *****
 *  ***
 *   *
 *  ***
 * *****
 * 2
 *
 *
 *
 * 作者: CHEN, Yue
 * 单位: 浙江大学
 * 时间限制: 400 ms
 * 内存限制: 64 MB
 * @createTime 2020年03月01日 23:45:00
 */
public class pat_1027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String ch = scanner.next();
        int count = 0;
        int sum = 1;
        for(int i=3;i<n;i+=2) {
            sum = sum+2*i;
            count++;
            if(sum==n) {
                break;
            }
            if(sum>n) {
                count--;
                sum=sum-2*i;
            }
        }
        for(int i=1;i<=count;i++) {
            for(int j=1;j<i;j++) {//每行多加一个空格，第一行不需要空格
                System.out.print(" ");
            }
            for(int m=0;m<=2*(count+1-i);m++) {//每行比上一行-2
                System.out.print(ch);
            }
            System.out.println();
        }
        for(int i=0;i<count;i++) {
            System.out.print(" ");
        }
        System.out.println(ch);
        for(int i=1;i<=count;i++) {
            for(int j=1;j<=count-i;j++) {//空格数减少1个
                System.out.print(" ");
            }
            for(int m=0;m<2*i+1;m++) {
                System.out.print(ch);
            }
            System.out.println();
        }
        int result = n-sum;
        System.out.println(result);
    }
}

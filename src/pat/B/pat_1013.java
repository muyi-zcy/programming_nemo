package pat.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1013.java
 * @Description
 * 1013 数素数 (20分)
 * 令 P
 * ​i
 * ​​  表示第 i 个素数。现任给两个正整数 M≤N≤10
 * ​4
 * ​​ ，请输出 P
 * ​M
 * ​​  到 P
 * ​N
 * ​​  的所有素数。
 *
 * 输入格式：
 * 输入在一行中给出 M 和 N，其间以空格分隔。
 *
 * 输出格式：
 * 输出从 P
 * ​M
 * ​​  到 P
 * ​N
 * ​​  的所有素数，每 10 个数字占 1 行，其间以空格分隔，但行末不得有多余空格。
 *
 * 输入样例：
 * 5 27
 *
 *
 *
 * 输出样例：
 * 11 13 17 19 23 29 31 37 41 43
 * 47 53 59 61 67 71 73 79 83 89
 * 97 101 103
 * @createTime 2020年03月01日 21:41:00
 */
public class pat_1013 {
    public static boolean isPrime(int a){
        if(a==1){
            return false;
        }
        if(a%2==0&&a!=2){
            return false;
        }
        for(int i=3;i<=Math.sqrt(a);i+=2){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int M=scanner.nextInt();
        int N=scanner.nextInt();
        int count=0;
        int re=0;
        int i=2;
        while(i>0){
            if(isPrime(i)){
                count++;
                if(count>=M&&count<=N){
                    System.out.print(i);
                    if(re==9){
                        re=0;
                        System.out.println();
                    }else {
                        re++;
                        if(count!=N) {
                            System.out.print(" ");
                        }
                    }
                }
                if(count==N){
                    break;
                }
            }
            if(i==2){
                i++;
            }else {
                i+=2;
            }
        }
    }
}

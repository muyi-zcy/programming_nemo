package pat.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1007.java
 * @Description
 * 1007 素数对猜想 (20分)
 * 让我们定义dn为：dn=pn+1−pn，其中pi是第i个素数。显然有d1=1，且对于n>1有dn是偶数。“素数对猜想”认为“存在无穷多对相邻且差为2的素数”。
 *
 * 现给定任意正整数N(<105)，请计算不超过N的满足猜想的素数对的个数。
 *
 * 输入格式:
 * 输入在一行给出正整数N。
 *
 * 输出格式:
 * 在一行中输出不超过N的满足猜想的素数对的个数。
 *
 * 输入样例:
 * 20
 *
 *
 *
 * 输出样例:
 * 4
 * @createTime 2020年03月01日 09:49:00
 */
public class pat_1007 {

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
        int n=scanner.nextInt();
        scanner.close();
        int count=0;
        int p=0;
        for(int i=3;i<=n;i+=2){
            if(isPrime(i)){
                if(i-p==2){
                    count++;
                }
                p=i;
            }else {
                p=0;
            }
        }
        System.out.println(count);
    }
}

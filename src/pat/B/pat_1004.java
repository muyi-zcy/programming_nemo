package pat.B;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1004.java
 * @Description
 * 1004 成绩排名 (20分)
 * 读入 n（>0）名学生的姓名、学号、成绩，分别输出成绩最高和成绩最低学生的姓名和学号。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，格式为
 *
 * 第 1 行：正整数 n
 * 第 2 行：第 1 个学生的姓名 学号 成绩
 * 第 3 行：第 2 个学生的姓名 学号 成绩
 *   ... ... ...
 * 第 n+1 行：第 n 个学生的姓名 学号 成绩
 *
 *
 *
 * 其中姓名和学号均为不超过 10 个字符的字符串，成绩为 0 到 100 之间的一个整数，这里保证在一组测试用例中没有两个学生的成绩是相同的。
 *
 * 输出格式：
 * 对每个测试用例输出 2 行，第 1 行是成绩最高学生的姓名和学号，第 2 行是成绩最低学生的姓名和学号，字符串间有 1 空格。
 *
 * 输入样例：
 * 3
 * Joe Math990112 89
 * Mike CS991301 100
 * Mary EE990830 95
 *
 *
 *
 * 输出样例：
 * Mike CS991301
 * Joe Math990112
 * @createTime 2020年02月28日 23:33:00
 */
public class pat_1004 {
    static class Stusent{
        private String name;
        private String number;
        private Integer grade;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Integer getGrade() {
            return grade;
        }

        public void setGrade(Integer grade) {
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Stusent[] stusents=new Stusent[n];
        for(int i=0;i<n;i++){
            Stusent stusent=new Stusent();
            stusent.setName(scanner.next());
            stusent.setNumber(scanner.next());
            stusent.setGrade(Integer.parseInt(scanner.next()));
            stusents[i]=stusent;
        }
        Arrays.sort(stusents, new Comparator<Stusent>() {
            @Override
            public int compare(Stusent o1, Stusent o2) {
                if (o1.grade < o2.grade) {
                    return 1;
                } else if (o1.grade > o2.grade) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(stusents[0].getName()+" "+stusents[0].getNumber());
        System.out.println(stusents[n-1].getName()+" "+stusents[n-1].getNumber());

    }
}

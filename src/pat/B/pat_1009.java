package pat.B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1009.java
 * @Description
 * 1009 说反话 (20分)
 * 给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。
 *
 * 输入格式：
 * 测试输入包含一个测试用例，在一行内给出总长度不超过 80 的字符串。字符串由若干单词和若干空格组成，其中单词是由英文字母（大小写有区分）组成的字符串，单词之间用 1 个空格分开，输入保证句子末尾没有多余的空格。
 *
 * 输出格式：
 * 每个测试用例的输出占一行，输出倒序后的句子。
 *
 * 输入样例：
 * Hello World Here I Come
 *
 *
 *
 * 输出样例：
 * Come I Here World Hello
 * @createTime 2020年03月01日 17:10:00
 */
public class pat_1009 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        List<String> list=new ArrayList<String>(Arrays.asList(s.split(" ")));
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(list.size()-1-i));
            if(i!=list.size()-1){
                System.out.print(" ");
            }
        }
    }
}

package pat.B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName pat_1010.java
 * @Description
 * 1010 一元多项式求导 (25分)
 * 设计函数求一元多项式的导数。（注：x^n（n为整数）的一阶导数为nx^n−1。）
 *
 * 输入格式:
 * 以指数递降方式输入多项式非零项系数和指数（绝对值均为不超过 1000 的整数）。数字间以空格分隔。
 *
 * 输出格式:
 * 以与输入相同的格式输出导数多项式非零项的系数和指数。数字间以空格分隔，但结尾不能有多余空格。注意“零多项式”的指数和系数都是 0，但是表示为 0 0。
 *
 * 输入样例:
 * 3 4 -5 2 6 1 -2 0
 *
 * 输出样例:
 * 12 3 -10 1 6 0
 * @createTime 2020年03月01日 17:22:00
 */
public class pat_1010 {
    static class node{
        private Long num;
        private Long index;

        public node(Long num, Long index) {
            this.num = num;
            this.index = index;
        }

        public Long getNum() {
            return num;
        }

        public void setNum(Long num) {
            this.num = num;
        }

        public Long getIndex() {
            return index;
        }

        public void setIndex(Long index) {
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        List<String> list=new ArrayList<String>(Arrays.asList(s.split("\\s+")));
        List<node> nodeList=new ArrayList<node>();
        for(int i=0;i<list.size()-1;i+=2){
            node node=new node(new Long(Integer.parseInt(list.get(i)))*new Long(Integer.parseInt(list.get(i+1))),new Long(Integer.parseInt(list.get(i+1))));
            if(node.getNum()!=0) {
                node.setIndex(node.getIndex()-1);
                nodeList.add(node);
            }
        }

        if(nodeList.size()==0){
            System.out.print("0 0");
        }
        for(int i=0;i<nodeList.size();i++){
            node node=nodeList.get(i);
            System.out.print(nodeList.get(i).getNum()+" "+nodeList.get(i).getIndex());
            if(i<nodeList.size()-1){
                System.out.print(" ");
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        boolean isHaveOutput = false;
//        while (in.hasNext()) {
//            int coef = in.nextInt();
//            int expon = in.nextInt();
//
//            if (coef * expon != 0) {
//                if (isHaveOutput) {
//                    System.out.print(" ");
//                } else {
//                    isHaveOutput = true;
//                }
//
//                System.out.print(coef * expon + " " + (expon - 1));
//            }
//        }
//        in.close();
//
//        if (!isHaveOutput) {
//            System.out.print("0 0");
//        }
//    }
}

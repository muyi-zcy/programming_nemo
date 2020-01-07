package leetcode.QuestionBank;

import cn.hutool.core.lang.Console;

import java.util.List;

/**
 * @author nemo
 * @version 1.0.0
 * @ClassName q_2.java
 * @Description
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @createTime 2020年01月08日 01:03:00
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class q_2 {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode flag=head;
        int array=0;
        while(l1!=null||l2!=null) {
            int val = array + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            array = val / 10;

            flag.next = new ListNode(val % 10);
            flag = flag.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(array!=0) {
            ListNode next = new ListNode(array);
            flag.next = next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(8);

        l1.next=l2;

        ListNode l4=new ListNode(1);

        q_2 q=new q_2();

        Console.log(q.addTwoNumbers(l1,l4));
    }
}

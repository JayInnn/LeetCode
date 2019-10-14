package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/14
 * @description:
 * @result:
 */
public class Exe02 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode last = first;

        ListNode tmp1 = l1, tmp2 = l2;
        int tmpNum = 0;
        while (tmp1 != null || tmp2 != null || tmpNum != 0){
            int val1 = tmp1 != null ? tmp1.val : 0;
            int val2 = tmp2 != null ? tmp2.val : 0;
            int sum = val1 + val2 + tmpNum;
            tmpNum = sum / 10;
            last.next = new ListNode(sum % 10);
            last = last.next;

            if (tmp1 != null) tmp1 = tmp1.next;
            if (tmp2 != null) tmp2 = tmp2.next;
        }
        return first.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(3);
        l1.next = p1; p1.next = p2;

        ListNode l2 = new ListNode(5);
        ListNode p3 = new ListNode(6);
        ListNode p4 = new ListNode(4);
        l2.next = p3; p3.next = p4;

        new Exe02().addTwoNumbers(l1,l2);
    }
}
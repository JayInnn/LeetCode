package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/26
 * @description:
 * @result:
 */
public class Exe24_SwapPairs {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null){
            ListNode next1 = tmp.next;
            tmp.next = next1.next;
            next1.next = tmp.next.next;
            tmp.next.next = next1;

            tmp = tmp.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs_recursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs_recursive(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args){

    }
}

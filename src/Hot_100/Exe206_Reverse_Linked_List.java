package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-04-27
 */
public class Exe206_Reverse_Linked_List {
     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
     }

    public ListNode reverseList(ListNode head) {
         ListNode result = new ListNode(-1);
        while (head != null){
            ListNode tmp = head;
            head = head.next;
            tmp.next = result.next;
            result.next = tmp;
        }
         return result.next;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println();
    }
}

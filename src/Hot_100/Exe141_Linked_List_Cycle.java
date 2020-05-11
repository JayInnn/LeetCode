package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-11
 */
public class Exe141_Linked_List_Cycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null){
            first = first.next;
            second = second.next.next;
            if (first == second){
                return true;
            }
        }
        return false;
    }


}

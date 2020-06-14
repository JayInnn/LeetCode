package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-06-14
 */
public class Exe142_Linked_List_Cycle_II {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast){
            slow = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }
}

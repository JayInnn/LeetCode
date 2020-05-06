package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-06
 */
public class Exe160_Intersection_of_Two_Linked_Lists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
            if (tempA == null && tempB == null) {
                return null;
            }
            if (tempA == null){
                tempA = headB;
            }
            if (tempB == null){
                tempB = headA;
            }
        }
        return tempA;
    }

    public static void main(String[] args){
//        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
        b.next = c;

        System.out.println(new Exe160_Intersection_of_Two_Linked_Lists().getIntersectionNode(b, c));
    }
}

package Hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YCKJ2794
 * @since : 2020-05-11
 */
public class Exe234_Palindrome_Linked_List {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null){
            list.add(tmp.val);
            tmp = tmp.next;
        }
        for (int i = 0; i < list.size() / 2; i++){
            int first = list.get(list.size() - i - 1);
            int last = list.get(i);
            if (first != last){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
//        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = e;

        System.out.println(new Exe234_Palindrome_Linked_List().isPalindrome(a));
    }
}

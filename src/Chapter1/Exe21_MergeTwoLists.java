package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/25
 * @description:
 * @result:
 */
public class Exe21_MergeTwoLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode p = l1, q = l2, tmp = ans;
        while (p != null && q != null){
            if (p.val < q.val){
                tmp.next = p;
//                tmp.next = new ListNode(p.val);
                p = p.next;
            } else{
                tmp.next = q;
//                tmp.next = new ListNode(q.val);
                q = q.next;
            }
            tmp = tmp.next;
        }
        if (p != null)
            tmp.next = p;
        if (q != null)
            tmp.next = q;
        return ans.next;
    }

    public static void main(String[] args){

    }
}

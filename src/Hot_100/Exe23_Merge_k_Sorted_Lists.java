package Hot_100;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/18
 * @description:
 * @result:
 */
public class Exe23_Merge_k_Sorted_Lists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode ans = lists[0];
        for (int i = 1; i < lists.length; i++){
            ListNode tmp = lists[i];
            if(tmp != null){
                ans = mergeTwoList(ans, tmp);
            }
        }
        return ans;
    }

    private ListNode mergeTwoList(ListNode first, ListNode second){
        ListNode p = first;
        ListNode q = second;
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans;
        while (p != null && q != null){
            if (p.val < q.val){
                tmp.next = p;
                p = p.next;
            }else {
                tmp.next = q;
                q = q.next;
            }
            tmp = tmp.next;
        }
        tmp.next = p == null ? q : p;
        return ans.next;
    }

}

package code_2021_0104;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val,ListNode next){this.val = val;this.next = next;}
}
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        int count = 0;
        while(l1 != null && l2 != null){
            int num = (l1.val + l2.val + count)%10;
            count = (l1.val + l2.val + count)/10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int num = (l1.val + count)%10;
            count = (l1.val + count)/10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int num = (l2.val + count)%10;
            count = (l2.val + count)/10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l2 = l2.next;
        }
        if(count != 0){
            cur.next = new ListNode(count);
        }
        return node.next;
    }
}

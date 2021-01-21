package code_2021_0119;
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Plus {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,9,4,8};
        int[] arr2 = new int[]{9,5,7,3};
        ListNode aHead = new ListNode(-1);
        ListNode cur = aHead;
        for(int n : arr1){
            ListNode node = new ListNode(n);
            cur.next = node;
            cur = cur.next;
        }
        ListNode bHead = new ListNode(-1);
        cur = bHead;
        for(int n : arr2){
            ListNode node = new ListNode(n);
            cur.next = node;
            cur = cur.next;
        }
        cur = plusAB(aHead.next,bHead.next);
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static ListNode plusAB(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int count = 0;
        int val = 0;
        while(a != null && b != null){
            val = (a.val + b.val + count)%10;
            count = (a.val + b.val + count)/10;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
            a = a.next;
            b = b.next;
        }
        while(a != null){
            val = (a.val + count)%10;
            count = (a.val + count)/10;
            if(count == 0){
                cur.next = a;
            }else{
                ListNode node = new ListNode(val);
                cur.next = node;
                cur = cur.next;
            }
            a = a.next;
        }
        while(b != null){
            val = (b.val + count)%10;
            count = (b.val + count)/10;
            if(count == 0){
                cur.next = b;
            }else{
                ListNode node = new ListNode(val);
                cur.next = node;
                cur = cur.next;
            }
            b = b.next;
        }
        if(count != 0){
            ListNode node = new ListNode(count);
            cur.next = node;
        }
        return head.next;
    }
}
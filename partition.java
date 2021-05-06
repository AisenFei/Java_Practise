package ListNode;
//牛客链表分割
public class partition {
    /**
     * 链表的最后一个结点一定要置为null，断开原来的指向关系
     */
    public ListNode solution(ListNode pHead, int x) {
        ListNode cur = pHead;
        ListNode fakeHead1 = new ListNode(-1);
        ListNode fakeHead2 = new ListNode(-1);
        ListNode p1 = fakeHead1;
        ListNode p2 = fakeHead2;
        while(cur != null){
            if(cur.val < x ){
                p1.next = cur;
                p1 = p1.next;
                cur = cur.next;
            }else{
                p2.next = cur;
                p2 = p2.next;
                cur = cur.next;
            }
        }
        p1.next = fakeHead2.next;
        //比x大的链表的结点，一定要更改最后一个的指向关系，将它置为null
        //很有可能它的next会指向其他地方，导致链表是一个环状结构
        p2.next = null;
        return fakeHead1.next;

    }
}

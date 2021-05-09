package Node;

//18. 删除链表的节点
public class deleteNode {

    /**
     * 通过构造傀儡头结点的方式
     * 如果头节点是要删除的结点，那么构造一个傀儡节点就可以做到
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        prev.next = head;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            if(cur.val == val ){
                prev.next = next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return fakeHead.next;
    }
}

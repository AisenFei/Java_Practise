package Node;

//22. 链表中倒数第k个节点
public class getKthFromEnd {
    /**
     * 重写整理解法一的思路，对解法一进行优化
     * @param head
     * @param k
     * @return
     */
    public ListNode solution2(ListNode head, int k) {
        //定义两个引用
        ListNode low = head;
        ListNode fast = head;
        int count = k-1;
        //一个走一步 另一个走k-1步
        //需要对k进行一个判断
        //没有处理倒数第一个
        while(count > 0){
            fast = fast.next;
            //由于fast是跳着走的，所以很可能在走的时候，出现null
            if(fast == null) return low;
            count--;
        }
        //之后应该是一人一步走
        //当fast走到最后一个的时候，此时的low就可以返回
        while (fast.next != null){
            fast = fast.next;
            low = low.next;
        }
        return low;
    }

    public ListNode solution1(ListNode head, int k) {
        //定义两个引用
        ListNode low = head;
        ListNode fast = head;
        int count = k-1;
        //一个走一步 另一个走k-1步
        //需要对k进行一个判断
        //没有处理最后一个元素就是倒数第一个
        //由于fast是跳着走的，所以很可能在走的时候，出现null
        while(count > 0){
            fast = fast.next;
            if(fast == null) return low;
            count--;
        }
        //之后应该是一人一步走
        while(low != null && fast != null){
            fast = fast.next;
            if(fast == null) return low;
            low = low.next;
        }
        return low;
    }
}

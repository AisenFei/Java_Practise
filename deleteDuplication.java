package ListNode;

//82. 删除排序链表中的重复元素II
//删除链表中的重复结点
//1233445
//125
public class deleteDuplication {

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead; //prev永远指向保留链表的最后一个结点
        ListNode cur = head; //表示当前遍历的链表结点
        while(cur != null){
            if(cur.next == null){ // 表示只有一个元素 或者是最后一个元素是不重复的
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }else if(cur.next != null && cur.val != cur.next.val ){
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }else{
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //需要多跳出一个
                cur =cur.next;
            }
        }
        prev.next = null;
        return fakeHead.next;
    }

    /**
     * 一个调试无数次的代码
     * 抛出了很多的空指针异常
     * 最终终于调试好了
     *
    */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        ListNode  low = head;
        ListNode fast = head;
        if(head == null) return head;
        while(fast != null && fast.next != null){
            fast = low.next;
            if(low.val != fast.val){
                cur.next = low;
                cur = low;
                low = fast;
            }else{
                while(fast != null && low.val == fast.val ){
                    fast = fast.next;
                }
                //找到了不相等的那一个元素
                low = fast;
            }
        }
        if(low != null && low.next == null){
            cur.next = low;
            cur = low;
        }
        //一定要记得置为空
        cur.next = null;
        return fakeHead.next;
    }

    /**
     * 正确解法
     */
    public ListNode solution2(ListNode pHead){
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;

        ListNode cur = pHead;
        while (cur != null ){
            if(cur.next != null && cur.val == cur.next.val){
                //把所有相同的都走完
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //跳出的时候说明当前的cur找到了不相等的结点，但是此时的cur是一个重复结点，需要跳过,这样就跳过了所有重复的结点
                cur = cur.next;
            }else {//这里的else 不仅处理了值不想的情况还处理了 cur.next == null 也就是cur走到最后一个情况
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        //这里一定要置为null
        prev.next = null;
        return fakeHead.next;
    }

    /**
     * 这是一个错误的解法
     * 你处理了值相等的，但是没有处理cur.next == null 的情况
     * 如果是最后一个 也是需要串起来的
     */
    public ListNode solution(ListNode pHead){
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        ListNode cur = pHead;
        while (cur != null ){
            //没有考虑cur不空 但是cur next是空的时候怎么办
            //所以写这个if else的时候还是很看顺序的！
            if(cur.next!= null && cur.val != cur.next.val){
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }else {//cur.val == cur.next.val
                //在进到这个循环的时候，还不能把当找到不相等的时候直接穿上去
                //因为出现多个一样的数字，所以需要一直找，找到第一个不一样的
                while (cur != null && cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //跳出的时候说明当前的cur找到了不相等的结点，但是此时的cur是一个重复结点，需要跳过,这样就跳过了所有重复的结点
                cur = cur.next;
            }
        }
        prev.next = null;
        return fakeHead.next;
    }



    /**
     * 这个只是做到了删除重复的，但是没有把本身的也删除
     */
    public ListNode solution1(ListNode pHead){
        ListNode fakeHead = new ListNode(-1);
        ListNode low = fakeHead;
        ListNode fast = pHead;
        ListNode cur = fakeHead;//新链表的当前结点
        while(fast != null){
            if(low.val != fast.val){
                low = fast;
                cur.next = low;
                cur = cur.next;
                fast = fast.next;
            }else{//说明值是相等的
                fast = fast.next;
            }
        }
        return fakeHead.next;
    }
}

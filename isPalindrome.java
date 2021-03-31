package ListNode;

//234. 回文链表
public class isPalindrome {
    /**
     * 解法一：利用快慢指针，一个走一步，一个走两步找到链表的中间
     * 然后反转后半部分之后和前半部分比较
     *
     * 为什么一定要反转后半部分？去和前半部分比较
     * 答：事实上如果是链表的长度是偶数个，反转后半部分和前半部分没有什么差别，因为是完全一样的
     *     但是，123 21
     *     如果是长度是奇数，那么中间的那个被划分到了左半部分123，如果把前半部分反转，321
     *     而后半部分是 21 就不好判断，
     *     但是返回反转后面的 变成12 就很方便判断
     *     同时比较是否相同的时候，所以写p2就可以
     *
     * 快慢指针走完以后不管奇数还是偶数，最后指向的位置一定是最中间的！
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //考虑特殊情况
        if(head == null) return true;
        ListNode low = findHalf(head);
        //循环结束的时候的low就是需要开始反转的low 记录下这个位置
        ListNode p2 = reverseList(low.next);//p2 是原链表的最后一个结点
        //判断是否是回文结构
        ListNode p1 = head;
        while (p2 != null) { //为什么不写p1
            if(p2.val != p1.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //少一步还原链表，为了不破换链表的原有结构把链表还原回去
        reverseList(low.next);
        return true;

    }

    private ListNode findHalf(ListNode head) {
        ListNode low = head;
        ListNode fast = head;

        //为什么两个都要写 判断条件里面用到了fast.next 所以必须确保fast不为null
        //奇数个时候走到尾 fast.next == null 偶数个 fast.next.next == null
        while (fast.next != null && fast.next.next != null){  //确保走两步以后不会空
            fast = fast.next.next;
            low = low.next;
        }
        return low;


        //构造傀儡结点找到链表的一半位置
        //完全不需要啊
//        ListNode fakeHead = new ListNode(-1);//只是
//        ListNode low = fakeHead;
//        fakeHead.next = head;
//        ListNode fast = head;
//        while(fast!= null && fast.next != null){
//            fast = fast.next.next;
//            low = low.next;
//        }
//        return low;

    }

    public ListNode reverseList (ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode curNext = null;
        while(cur != null){
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }
    /**
     *
     * 解法二：可以使用栈的方式来实现比较，做法比较简单，就不写代码了！
     * error!
     * 遍历一遍链表，然后将值放到字符串里面，利用字符的reverse比较
     * 你这样做的前提是每一个的val都是个位数
     * 如果是负数，或者是一个多位数字
     * 你当作字符串反转，那当然会出现问题
     * -123 -123
     * 321- 321-
     *
     * 你的预想是把每一个val当作一个整体放进去，但是字符串的反转并没有做到
     * @param head
     * @return
     */
    public boolean ErrorSolution(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while(cur != null){
            sb.append(cur.val);
            cur = cur.next;
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        return sb.toString().equals(reverse.toString());

    }
}

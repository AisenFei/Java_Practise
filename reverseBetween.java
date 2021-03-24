package ListNode;

//92. 反转链表 II
public class reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode pre = fakeHead; //定义一个前驱结点
        ListNode point = fakeHead.next;//用来定位第一个需要翻转的结点 也就是left

        if(head == null){
            return null;
        }

        //不断移动让point指向left
        for(int i = 0; i< left-1;i++){
            pre = point;
            point = point.next;
        }
        //point 已经指向了left
        //把point之后的到left位置的所有元素全部头插入到left之前
        //一共需要的操作次数
        //头插入的方法插入结点
        for(int i = 0;i < right-left;i++){
            ListNode reverse = point.next;//怎么保证不为null？是循环机制
            point.next = reverse.next;
            reverse.next = pre.next;
            pre.next = reverse;
        }

        return fakeHead.next;
    }

}

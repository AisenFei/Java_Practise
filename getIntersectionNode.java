package Node;

import java.util.HashSet;
import java.util.Set;

//52. 两个链表的第一个公共节点
public class getIntersectionNode {
    /**
     * 通过一个set的解法来做
     * 把一个连边全部放到set里面去，然后遍历另一个链表
     * 如果set里面有，就返回当前遍历到的结点，如果没有，就返回null
     * 这个做法比较好想到，但是时间和空间复杂度都太高
     * 空间复杂度o（n） 时间复杂度o（m+n)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode solution2(ListNode headA, ListNode headB) {
        //遍历链表A然后全部放到set里面去
        ListNode curA = headA;
        ListNode curB = headB;
        Set<ListNode> set = new HashSet<>();
        while (curA != null){
            set.add(curA);
            curA = curA.next;
        }
        //然后遍历链表b，看看set里面是否有，有就返回，没有就返回null
        while (curB != null){
            if(set.contains(curB) ) return curB;
            curB = curB.next;
        }
        //最后没有找到 返回null
        return null;

    }

    /**
     * 解法思路原理：
    * 第一个人走了L1+C步后，回到第二个人起点走L2步；
    * 第2个人走了L2+C步后，回到第一个人起点走L1步。
    * 当两个人走的步数都为L1+L2+C时就两个相遇
     * 空间复杂度为o（1），时间复杂度也不过是o（m+n)
     */


    //如果两个链表相交，这样的做法其实会让两个指针都各自轮空一次都指向null
    //而不是像下面的解法使用的是cur.next == null 来判断，这样就不容易出现太多的条件没有考虑到
    //出现空指针异常的情况了。
    public ListNode solution(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB){
            if(curA == null) {
                curA = headB;
            }else {
                curA = curA.next;
            }
            if(curB == null){
                curB = headA;
            }else {
                curB = curB.next;
            }
        }
        //要不是空，要不就是相交的结点
        return curA;
    }

    /**
     * 如果没有相交，该如何结束循环？？
     * 如果没有相交，那么两个指针各走一遍的时候，最后指向的都属null，直接返回就可以了
     *
     * 下面的解法是失败的，没写出来
     */
    //而且这个设计思路其实存在的问题就是一定会分别把两个链表从头到尾走一遍
    public ListNode errorSolution(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB){ //这里跳出循环一个是因为不相交，还有一个是因为找到了公共结点
            if(curA.next != null && curB.next != null){
                curA = curA.next;
                curB = curB.next;
            }else if(curA.next == null && curB.next !=null){
                curA = headB;
                curB = curB.next;//但是这里又会出现为题，有可能本身b就是一个空的链表，就会空指针异常
            }else if(curB.next == null && curA.next != null){
               curB = headA;
               curA = curA.next;
            }else {
                return  null;
            }
            //这个逻辑判断写的有问题，两个都指向最后一个的时候，紧着这下一次循环不相等
            //然后发现指向的下一个都是null 然后死循环了

        }
        return curA;
        //return curB;

    }
}

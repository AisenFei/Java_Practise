package map;


import java.util.Map;
import java.util.TreeMap;

public class copyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node solution1(Node head) {
        if(head == null){
            return null;
        }

        //第一步：
        //1.循环遍历老链表的每一个结点，复制新的结点
        //2.把新结点插入到老节点的后面
        //由于把新结点插入到老节点的后面，所以遍历老节点 cur = cur.next?还对吗? 不对
        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            Node node = new Node(cur.val);
            //把new node 插入到cur 的后边
            //更改两个指向关系
            node.next = next;
            cur.next = node;
            cur = next;
        }


        //第二步：
        cur = head;
        //老新映射的关系 -- 复制random
        while (cur != null){
            Node newCur = cur.next;
            if( cur.random != null) {
                newCur.random = cur.random.next;
            } //本来是空就不用处理了

            cur = newCur.next;
            //  newCur = cur.next;  // 这里会出问题空指针 连续处理多个next的时候一定靠考虑清楚！！!
        }

        //在把老-新这样的链表结构拆开
        cur = head;
        Node newHead= head.next; //走这个的时候要考虑head 一定不为空吗？
        while (cur != null){
            Node newCur = cur.next;
            //拆结构处理
            cur.next = newCur.next;  //在这里面newCur 肯定不可能是null 因为cur 和 newCur是成队出现的
            //但是 newCur.next 可能为空，所以当你下面进行操作的时候，还是需要再次判断
            if(newCur.next != null){
                newCur.next = newCur.next.next;
            }//如果它原来为空就不用进行处理了。因为只有一种可能就是newCur 已经是最后一个了

            //然后往后走
            cur = cur.next;
        }
        return newHead;
    }


    public Node copyRandomList(Node head) {

        //遇到的问题是根据老链表找到新链表

        //老新映射--传入comparator对象
        //因为TreeMap的本质是一个搜索树，一定有比较能力
        //不然无法构建
        //hashCode() 如果不是同一个对象的情况下，默认的hashcode（）返回的是一个不同的值
        Map<Node ,Node> map = new TreeMap<>((o1, o2)->{
            //因为测试用例的3 导致 put都是一样的
            //但我人为不一样啊 -- 因为蛮难找value比较，
            //所以就是会出现这样的情况
            return o1.hashCode() - o2.hashCode();
            //  return o1.val - o2.val;
            //因为我并不进行真的排序，所以怎么排序的我不关心
            //只看它的映射关系
        });
        //因为map进行push操作需要有大小比较的能力
        Node cur = head;
        Node newHead = new Node(-1);
        Node pre = newHead;
        while(cur != null){
            Node node = new Node(cur.val);
            pre.next = node;
            pre = node;
            // 保存新老结点之间的关系
            map.put(cur,node);

            cur = cur.next;
        }
        //处理random 的关系
        cur = head;
        pre = newHead.next;
        while (cur != null){

            //因为cur.random 可能出现空 ，所以会出现空指针异常
            if(cur.random != null){
                pre.random = map.get(cur.random);
            }else{
                pre.random = null;
            }
            //然后往后走
            cur = cur.next;
            pre = pre.next;
        }

        return newHead.next;
    }

    //保存一个映射的关系
    //保存老节点 1  和 新结点1 之间的关系
    public Node copyRandomList1(Node head) {

        //老新映射
        Map<Node ,Node> map = new TreeMap<>((o1,o2)->{
            return o1.val - o2.val;
            //因为我并不进行真的排序，所以怎么排序的我不关心
            //只看它的映射关系
        });
        //因为map进行push操作需要有大小比较的能力
        Node cur = head;
        Node newHead = new Node(-1);
        Node pre = newHead;
        while(cur != null){
            Node node = new Node(cur.val);
            pre.next = node;
            pre = node;
            // 保存新老结点之间的关系
            map.put(cur,node);

            cur = cur.next;
        }
        //处理random 的关系
        cur = head;
        pre = newHead.next;
        while (cur != null){
            pre.random = map.get(cur.random);
            //然后往后走
            cur = cur.next;
            pre = pre.next;
        }

        return newHead.next;

    }


    //普通链表的复制
    public Node copy(Node head) {
        Node cur = head;
        Node newHead = new Node(-1);
        Node pre = newHead;
        while(cur != null){
            Node node = new Node(cur.val);
            pre.next = node;
            pre = node;
            cur = cur.next;
        }
        return newHead.next;
    }
}

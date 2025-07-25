package Day4.question1_24;

public class Soulution {
    public ListNode swapPairs(ListNode head) {
        // 添加虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 使用临时指针
        ListNode cur = dummy;

        /*
            遍历的结束条件
            偶数节点：cur.next != null
            奇数节点：cur.next.next != null
         */

        // 遍历节点
        while(cur.next != null && cur.next.next != null){
            // 首先用临时指针保存两个节点
            ListNode temp1 = cur.next; // 节点一
            ListNode temp2 = cur.next.next.next; // 节点三

            // 实现节点交换
            cur.next = cur.next.next; // dummy 指向节点二

            // 注意：此时cur的指向发生了变化，则后继节点的表示也需要变化
            cur.next.next = temp1; // 节点二指向节点一

            temp1.next = temp2; // 节点一指向节点三

            // 交换完成，cur向后移动一位，准备下一次交换
            cur = cur.next;
        }

        // 返回头节点
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
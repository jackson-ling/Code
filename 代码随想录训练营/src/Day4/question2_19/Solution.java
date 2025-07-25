package Day4.question2_19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 添加虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 定义快慢指针
        ListNode fast = dummy;
        ListNode slow = dummy;

        /*
            1. 找到倒数第n个节点，其次慢指针需要指向操作节点的前一个节点
            2. 即二者初始时相差 n + 1 个位置
            3. 到达末尾时，slow 指向的位置刚好是倒数第 n 个节点的前驱
            4. 然后就可以进行删除操作了
         */
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时移动
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        // 此时慢指针指向需要被操作节点的前一个节点
        if(slow.next!=null){
            slow.next = slow.next.next;
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
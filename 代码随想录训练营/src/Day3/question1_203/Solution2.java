package Day3.question1_203;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val){
        // 使用虚拟节点，统一删除方式
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p;
        p= dummy;
        while(p.next!=null){
            if(p.next.val == val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }

        return dummy.next; // 头节点可能被删除
    }
}


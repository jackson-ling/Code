package Day4.question4_142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 定义快慢指针
        ListNode fast;
        ListNode slow;

        fast = head;
        slow = head;

        // 快指针走两步，满指针走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果相遇，说明有环，需要找到环的入口
            if(slow == fast){
                ListNode index1 = head;
                ListNode index2 = fast;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while(index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1; // 环的入口
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
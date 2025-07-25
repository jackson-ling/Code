package Day3.question1_203;

public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        // head.val = val
        while (head != null && head.val == val) {
            head = head.next;
        }

        // head.next != val
        ListNode p;
        p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
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

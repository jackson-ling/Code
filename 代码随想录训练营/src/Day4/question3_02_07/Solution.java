package Day4.question3_02_07;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa;
        ListNode pb;

        pa = headA;
        pb = headB;

        int len_a = 0;
        int len_b = 0;

        // 1. 首先计算链表长度，目的是让二者同起点

        // 计算 a 的表长
        while (pa != null) {
            pa = pa.next;
            len_a++;
        }

        // 计算 b 的表长
        while (pb != null) {
            pb = pb.next;
            len_b++;
        }

        // 易错点：此时 pa 和 pb 都已经到达了标为，需要重置一下
        pa = headA;
        pb = headB;

        // 2. 由于表长差值可能是负数，就不知道谁是最长的，假定 pa 指向的是最长的链表
        if (len_b > len_a) {

            // 交换表长
            int temp_len = len_a;
            len_a = len_b;
            len_b = temp_len;

            // 交换头指针指向
            ListNode temp = pa;
            pa = pb;
            pb = temp;

        }

        // 3. 得到差值，实现同起点
        int gap = len_a - len_b;
        while(gap>0){
            pa = pa.next;
            gap--;
        }

        // 4. 同起点后，同步移动
        while(pa != null){
            // 易错：先判断再移动，否则会遗漏同起点这个点的判断
            if(pa == pb){
                return pa;
            }
            pa = pa.next;
            pb = pb.next;

        }

        // 5. 没有交点，返回空
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
package Day3.question1_707;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class MyLinkedList {

    //定义节点
    class ListNode {
        int val;
        ListNode next;

        // 构造器初始化
        ListNode(int val) {
            this.val = val;
        }
    }

    int size;
    ListNode head; // 使用虚拟头节点

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }


    public int get(int index) {
        if (index < 0 || index >= size) { // index是下标索引，index <= size - 1
            return -1;
        }

        ListNode p = head.next; // 指向第一个元素，下标索引为0
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        // 在头节点前添加新节点，确保 p.next 是新节点
        ListNode s;
        s = new ListNode(val);

        // 先修改后继指针，再修改前驱指针
        s.next = head.next;
        head.next = s;
        size++;
    }

    public void addAtTail(int val) {
        ListNode p;
        p = head;
        while (p.next != null) {
            p = p.next;
        }
        ListNode s = new ListNode(val);
        p.next = s;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) { // 末尾是的位置是size，允许index = size
            return;
        }

        ListNode p;
        p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        ListNode s = new ListNode(val);
        s.next = p.next;
        p.next = s;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        size--;
    }
}


package chapter3_链表.双向链表;

// 双向链表
public class DoubleLinkedList {
    // 定义头指针
    Node head;

    // 初始化：头指针指向头节点
    public DoubleLinkedList() {
        this.head = new Node(0);
    }
    // 获取长度
    public void
}

// 节点
class Node {
    int val;
    Node pre;
    Node next;

    public Node(int val) {
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}

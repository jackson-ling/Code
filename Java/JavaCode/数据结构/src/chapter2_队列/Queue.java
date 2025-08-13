package chapter2_队列;


public class Queue {
    // 定义属性
    public int front; // 队头指针
    public int rear; // 队尾指针
    public int maxsize; // 队列容量
    public int[] circleQueue; // 队列

    /*
        注意
        （1）循环队列采用预留一个空间大小的设计
        （2）即存储元素的个数为队列容量大小减一
     */
    // 构造器：初始化
    public Queue(int size) {
        this.front = 0;
        this.rear = 0;
        this.maxsize = size;
        this.circleQueue = new int[size];
    }

    // 判断是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 判断是否队满
    public boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    // 获取队列大小
    public int size() {
        return (rear - front + maxsize) % maxsize;
    }

    // 取队头元素
    public int getHead() {
        // 首先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取队头元素");
        }
        return circleQueue[front];
    }

    // 增
    public void enQueue(int val) {
        // 首先判断是否队满
        if (isFull()) {
            throw new RuntimeException("队列已满，无法继续添加");
        }
        // 队尾指针指向的是队尾元素的下一个位置，直接添加即可
        circleQueue[rear] = val;
        rear = (rear + 1) % maxsize;
    }

    // 删
    public void deQueue() {
        // 首先判断是否队空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法出队");
        }
        front = (front + 1) % maxsize;
    }

    // 查
    public void showQueue() {
        if (isEmpty()){
            System.out.println("队列为空，没有任何元素");
        }
        System.out.println("=======队列元素如下=======");
        for (int i = front; i < front + size(); i++) {
            System.out.print(circleQueue[i % maxsize] + " ");
        }
        System.out.println();
    }
}

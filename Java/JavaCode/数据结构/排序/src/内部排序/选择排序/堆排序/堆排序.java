package 内部排序.选择排序.堆排序;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 8, 7, 4, 3};
        sort.heap_sort(arr);
        sort.printarr(arr);
    }

}

class sort {

    /*
    堆排序思想（又叫二叉堆）
    分类：大顶堆，小顶堆

    堆符合二叉树的性质

    说明：数组的下标在树中是：从上到下，从左到右依次编号的

    排序过程说明

    1. 构建一个大顶堆，每次交换最小和最大的，并且堆大小缩小减一，
    2. 交换的过程：把最大的放在有序区，但是破坏了大顶堆的结构，需要重新调整堆

    3. 有序的过程：把最大的放在有序区，数组从后往前一次放入有序元素完成排序
     */

    // 堆调整（大顶堆）
    // n：表示数组的大小；i：表示最大值的下标索引
    public static void heapify(int[] arr, int n, int i) {

        /*
        易错：这里表示的下标值，然而二叉树中的性质指的是物理位置

        数组是从0开始编号的，举例说明
                     7
                   /   \
                  6     5

        7：下标索引是0
        6：按照物理位置计算方法（左孩子：2 * i = 0），结果还是0，但是下标索引是1

        得出的关系：在物理位置的基础上加一才是索引下标

         */
        int max_index = i; // 初始化最大值下标索引
        int left = 2 * i + 1; // 左孩子的下标索引
        int right = 2 * i + 2; // 右孩子的下标索引

        // 和左右孩子比较，更新最大值下标索引
        // 注意：防止越界，需要加上限制条件
        if (left < n && arr[left] > arr[max_index]) {
            max_index = left;
        }

        if (right < n && arr[right] > arr[max_index]) {
            max_index = right;
        }

        // 如果最大值不是初始化的值，说明找到了更大的值，把最大值放到根节点
        if (max_index != i) {
            int temp = arr[i];
            arr[i] = arr[max_index];
            arr[max_index] = temp;

            // 递归调整左右子树（max_index在这个过程中做了更新）
            heapify(arr, n, max_index);
        }
    }

    //堆排序
    public static void heap_sort(int[] arr) {

        /*
                     7
                   /   \
                  6     5
                 / \   / \
                4   3 2   1
            总节点数：7

            循环起点：7/2 - 1 = 3 - 1 = 2，即下标为2的元素开始（元素5）

         */

        // 构建大顶堆（如果每一个子树都是大顶堆，则整个二叉堆就是大顶堆）
        int n = arr.length;
        // 从最后一个非叶子节点开始向上进行堆调整
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 排序过程：交换元素，调整堆，进行 n - 1 趟排序
        // 初值：每交换一次，可以理解为排序一个元素，则堆中需要排序的元素总数减少一
        // 初值为 i -1 正好对应最后一个元素的下标，方便交换
        for (int i = n - 1; i > 0; i--) {
            // 把最大的和最小的进行交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 交换后破坏了大顶堆的结构，重新调整堆（排序的过程中堆的大小在递减）
            heapify(arr, i, 0);
        }
    }


    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
package 内部排序.归并排序;

public class 归并排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 8, 7, 4, 3};
        sort.merge_sort(arr,0, arr.length - 1);
        sort.printarr(arr);
    }
}

class sort {

    public static void merge(int[] arr, int left, int mid, int right) {
        // 双指针思想 + 顺序表合并的思路

        // 使用两个指针 i j 遍历两个子序列
        int i = left;
        int j = mid + 1;
        // 用临时数组保存合并结果，之后更新原数组
        int[] temp = new int[right - left + 1];
        int k = 0; // 合并成新数组的指针

        // 比较值，放入新数组（前提：不能越界）
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                // 简洁写法：先赋值后自增
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 把剩余的元素放入数组（这些数是有序的）
        /*
        说明：最开始把每一个数看成是有序的，通过不断递归回溯合并成子区间，
              所以能保证剩余的数是有序的
         */

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 给新数组赋值（赋值后就是由两个序列合并成的有序序列）
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }

    }

    public static void merge_sort(int[] arr, int left, int right) {
        // 采用递归思想

        // 设置递归出口
        if (left >= right) {
            return;
        }

        int mid = left + ((right - left) / 2);
        // 排序左右区间，然后合并
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }


    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
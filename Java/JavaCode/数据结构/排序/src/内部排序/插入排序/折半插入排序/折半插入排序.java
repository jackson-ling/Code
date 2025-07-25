package 内部排序.插入排序.折半插入排序;

import java.util.Arrays;

public class 折半插入排序 {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        sort.binary_insert_sort(arr);
        sort.printarr(arr);
    }
}

class sort {

    // 查找插入位置的方法采用二分思想（由于查找位置的序列本身就是有序的，所以可以使用二分）
    public static void binary_insert_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            // 初始时：把第一个元素看成是有序的，然后进行插入排序
            int insertvalue = arr[i];

            int left = 0;
            int right = i - 1; // 和 j = i -1 是等价的

            while (left <= right) {
                int mid = left + ((right - left) / 2);
                if (arr[mid] < insertvalue) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // 找到了插入位置，移动元素为插入做准备
            // 为了维持稳定性，应该插入到 right 的后边
            // 插入位置为 right + 1 , 需要把这个位置空出来才可以插入，所以要取等
            for (int j = i - 1; j >= right + 1; j--) {
                arr[j + 1] = arr[j]; //元素后移
            }
            arr[right + 1] = insertvalue;
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
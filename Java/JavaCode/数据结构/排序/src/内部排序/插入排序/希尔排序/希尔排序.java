package 内部排序.插入排序.希尔排序;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 8, 7, 4, 3};
        sort.shell_sort(arr);
        sort.printarr(arr);
    }
}

class sort{
    /*
    快速写希尔排序算法代码：只要把直接插入排序中为 1 的地方全部改成 gap 即可
     */
    public static void shell_sort(int[] arr){
        // 增量序列取中间值（常用方法）
        /*
        增量序列是递减的，并且最后一个值一定是一
         */
        int gap = arr.length / 2; // 向下取整
        while (gap >= 1) {
            shell(arr, gap);
            gap /= 2;
        }
    }

    // 一趟写入排序的过程
    public static void shell(int[] arr, int gap){
        // 思想和直接插入排序，不同点就在原来 “加/减一” 的位置全部变成 “gap”

        // 由于是分组排，这里需要包含分组的第一个元素，所以不加一
        for (int i = gap; i < arr.length; i++) {
            int insertvalue = arr[i];
            int j = i - gap;
            // 移动元素
            while(j >= 0 && insertvalue < arr[j]){
                arr[j + gap] = arr[j];
                j -= gap;
            }
            arr[j + gap] = insertvalue;
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
package 内部排序.交换排序.冒泡排序;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 8, 7, 4, 3};
        sort.bubble_sort(arr);
//        sort.bubble_sort_improve(arr);
        sort.printarr(arr);
    }
}

class sort{

    public static void bubble_sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 前面的比后面大，交换位置
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 改进版本：如果本身就有序，则无序交换，减少比较次数
    public static void bubble_sort_improve(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;  // 每次进入循环都标记为0，如果有序就不交换，flag = 0
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 前面的比后面大，交换位置
                if(arr[j] > arr[j + 1]){
                    flag = 1; // 交换了就标记为一
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if(flag == 0){
                /* 在一趟遍历之后，如果都没有发生交换，说明元素已经有序了，
                   后面的比较没有意义了，直接退出
                 */
                break;
            }
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
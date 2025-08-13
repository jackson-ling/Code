package 内部排序.选择排序.简单选择排序;

public class 简单选择排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 8, 7, 4, 3};
        sort.select_sort_improve(arr);
        sort.printarr(arr);
    }
}

class sort{

    public static void select_sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    // 找到最小的才交换，减少交换次数，提高效率
    public static void select_sort_improve(int[] arr){
        // 比较 n-1 趟
        for (int i = 0; i < arr.length; i++) {
            int min_index = i; // 假设当前元素是最小的，记录下标

            // 在当前元素的后面找有没有更小的，有就交换位置
            for (int j = i + 1; j < arr.length; j++) {

                // 如果找到更小的，就更新下标
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }

            // 如果最小元素不是本身（找到了更小的），就交换位置
            if(min_index != i){
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
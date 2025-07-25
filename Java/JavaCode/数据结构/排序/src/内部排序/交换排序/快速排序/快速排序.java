package 内部排序.交换排序.快速排序;

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 8, 7, 4, 3};

        int left = 0;
        int right = arr.length - 1;

        sort.quicksort(arr,left,right);
        sort.printarr(arr);
    }
}

class sort {
    /*
    快速排序是冒泡排序的改进版本，核心在于递归和双指针思想

    说明
    1.选取数组的第一个元素为枢纽
    2.left,right为数组下标
    3.延申：可以对任意区间排序

     */

    public static int partition(int[] arr, int left, int right) {
        /*
        双指针思想
        1.left：指向数组的 第一个 元素，从 左往右 找，如果比中间值 大，就搬到后面（high的位置）
        2.right：指向数组的 最后一个 元素，从 左右往左 找，如果比中间值 小，就搬到前面（left的位置）
         */
        int pivot = arr[left];
        // 两个指针的移动逐渐靠近，当两个指针重合时，退出循环
        // 此时指向的位置就是枢纽的位置
        while (left < right) {

            /*
            注意：指针的移动可能会越界，需要加上判断条件 left < right
            易错点：先找小的，后找大的
             */

            // 首先在后面找小的往前搬(那对立面就是不符合要求，right指针往前移)
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            arr[left] = arr[right];

            // 然后在前面找大的往后搬(那对立面就是不符合要求，left指针往后移)
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }

        // 此时 left = right，指向中间枢纽的位置，放入枢纽值，返回枢纽的位置
        arr[left] = pivot;
        return left;
    }


    public static void quicksort(int[] arr, int left, int right) {
        /*
        递归易错的地方：需要有一个递归出口
         */
        if(left < right){
            int pivot = partition(arr,left,right); // 首先计算枢纽值

            // 递归递归左子区间
            quicksort(arr,left,pivot - 1);

            // 递归排序右子区间
            quicksort(arr,pivot + 1,right);
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
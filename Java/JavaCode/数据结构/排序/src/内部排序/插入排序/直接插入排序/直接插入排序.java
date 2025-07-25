package 内部排序.插入排序.直接插入排序;

public class 直接插入排序 {
    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 2, 7, 8, 9, 1, 4};
        sort.insert_sort_1(arr);
        sort.printarr(arr);
    }
}

class sort {
    public static void insert_sort(int[] arr) {
        /*
        插入排序的思想：从无序的序列中拿一个数，通过比较的方式插入到有序序列中
        初始状态：假设第一个数是有序的，从第二个元素开始，和有序序列比较，然后插入
         */
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的元素值，位置位于有序序列的末尾
            int insertvalue = arr[i];

            // 在有序序列中从后往前和插入元素比较，找到插入位置
            int j = i - 1;

            /*

            1 2 3 9 10 15 5

            插入5：需要插入在3的后面。所以只要插入元素比当前比较元素小，就往后移

             */
            // 推荐这种写法，更规范
            while (j >= 0 && insertvalue < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 插入元素（插入到  比当前插入元素小的 元素  的后面）
            arr[j + 1] = insertvalue;
        }
    }

    public static void insert_sort_1(int[] arr) {
        // 第二种写法：使用for循环
        for (int i = 1; i < arr.length; i++) {
            int insertvalue = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (insertvalue < arr[j]) {
                    arr[j + 1] = arr[j];
                }
                else{
                    break; // 如果 insertvalue >= arr[j] 就退出循环
                }
            }
            arr[j + 1] = insertvalue;
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
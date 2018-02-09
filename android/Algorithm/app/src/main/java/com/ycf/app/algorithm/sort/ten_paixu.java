package com.ycf.app.algorithm.sort;

/**
 * Created by chenlongjian on 2018/2/7.
 * <p>
 * http://www.runoob.com/w3cnote/sort-algorithm-summary.html
 * 10种排序
 * 1 冒泡排序(BubbleSort)
 * 2 选择排序(SelctionSort)
 * 3 插入排序(Insertion Sort)
 * 4 希尔排序(Shell Sort) https://www.cnblogs.com/chengxiao/p/6104371.html 加深理解
 *
 */


//        冒泡排序	O(n2)
//        选择排序	O(n2)
//        插入排序	O(n2)
//        希尔排序	O(n1.5)
//        快速排序	O(N*logN)
//        归并排序	O(N*logN)
//        堆排序	O(N*logN)
//        基数排序	O(d(n+r))

public class ten_paixu {

    public static void main(String args[]) {
        System.out.println("Hello World!");

        System.out.println("测试提交上传!");

        int[] ints = new int[]{60, 20, 30, 100, 70, 80, 40, 90, 50, 10};

//        BubbleSort(ints);

//        BubbleSort1(ints);

        shell_sort(ints, ints.length);

    }


//   ------------------------- 1  冒泡排序(BubbleSort)-----------------------------


//    1 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
//    2 过程：
//    比较相邻的两个数据，如果第二个数小，就交换位置。
//    从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
//    继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
//    3 平均时间复杂度：O(n2)


    public static void BubbleSort(int[] arr) {

        int temp;//临时变量
        System.out.println("---------第" + 1 + "次刷过程------------");
        for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。
            for (int j = arr.length - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }


                for (int k = 0; k <= arr.length - 1; k++) {
                    System.out.print(arr[k] + "、");
                }
                System.out.println();

            }
            System.out.println("---------第" + (i + 1) + "次刷后效果------------");
            for (int k = 0; k <= arr.length - 1; k++) {
                System.out.print(arr[k] + "、");
            }
            System.out.println("");
            System.out.println("---------第" + (i + 2) + "次刷过程-----------");
        }
    }

//    从上面的过程可以看到。后续的步骤中，有许多是重复的。

//    5优化
//    针对问题：
//    数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义的。
//    方案：
//    设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
//    这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。


    public static void BubbleSort1(int[] arr) {

        int temp;//临时变量
        boolean flag;//是否交换的标志
        System.out.println("---------第" + 1 + "次刷过程------------");
        for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。

            System.out.println("---------第" + i + "次------------");
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }

                for (int k = 0; k <= arr.length - 1; k++) {
                    System.out.print(arr[k] + "、");
                }
                System.out.println();
            }

            System.out.println(flag);
            if (!flag) break;

            System.out.println("---------第" + (i + 1) + "次刷后效果------------");
            for (int k = 0; k <= arr.length - 1; k++) {
                System.out.print(arr[k] + "、");
            }
            System.out.println("");
            System.out.println("---------第" + (i + 2) + "次刷过程-----------");
        }
    }
//    ---------------------------   2 选择排序(SelctionSort)     ---------------------
//    基本思想：
//    在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
//    第二次遍历n-2个数，找到最小的数值与第二个元素交换；
//            。。。
//    第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。

//    平均时间复杂度：O(n2)

    public static void select_sort(int array[], int lenth) {

        for (int i = 0; i < lenth - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < lenth; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    ////   ------------------------------       3 插入排序(Insertion Sort)   -------------------
//    基本思想：
//    在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
//      平均时间复杂度：O(n2)
    public static void insert_sort(int array[], int lenth) {

        int temp;

        for (int i = 0; i < lenth - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {         //不需要交换
                    break;
                }
            }
        }
    }

    //    ------------------------------------- 4 希尔排序(Shell Sort) ---------------------
//    前言：
//    数据序列1： 13-17-20-42-28 利用插入排序，13-17-20-28-42. Number of swap:1;
//    数据序列2： 13-17-20-42-14 利用插入排序，13-14-17-20-42. Number of swap:3;
//    如果数据序列基本有序，使用插入排序会更加高效。
//    基本思想：
//    在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
//    然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。
    public static void shell_sort(int array[], int lenth) {

        int temp = 0;
        int incre = lenth;

        while (true) {
            incre = incre / 2;

            System.out.println("第" + (incre + 1) + "次 增量效果------------");

            for (int k = 0; k < incre; k++) {    //根据增量分为若干子序列

                for (int i = k + incre; i < lenth; i += incre) {

                    for (int j = i; j > k; j -= incre) {
                        if (array[j] < array[j - incre]) {
                            temp = array[j - incre];
                            array[j - incre] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }



                    }

                }

                System.out.println("--k-------第" + (incre + 1) + "次刷后效果------------");
                for (int t = 0; t <= array.length - 1; t++) {
                    System.out.print(array[t] + "、");
                }
                System.out.println("");
                System.out.println("---k------第" + (incre + 2) + "次刷过程-----------");

            }

            if (incre == 1) {
                break;
            }
        }
    }



}

package com.ycf.app.algorithm.sort;

/**
 * Created by chenlongjian on 2018/2/7.
 *
 * http://www.runoob.com/w3cnote/sort-algorithm-summary.html
 *
 */

public class maopaopaixu {

    public static void main(String args[]) {
        System.out.println("Hello World!");

        System.out.println("测试提交上传!");

        int [] ints = new int[]{60,20,30,100,70,80,40,90,50,10};

//        BubbleSort(ints);

        BubbleSort1(ints);

    }


//    1 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
//    2 过程：
//    比较相邻的两个数据，如果第二个数小，就交换位置。
//    从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
//    继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
//    3 平均时间复杂度：O(n2)


    public static void BubbleSort(int [] arr){

        int temp;//临时变量
        System.out.println("---------第"+1+"次刷过程------------");
        for(int i=0; i<arr.length-1; i++){   //表示趟数，一共arr.length-1次。
            for(int j=arr.length-1; j>i; j--){

                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }


                for (int k = 0;k<=arr.length-1;k++)
                {
                    System.out.print(arr[k]+"、");
                }
                System.out.println();

            }
            System.out.println("---------第"+(i+1)+"次刷后效果------------");
            for (int k = 0;k<=arr.length-1;k++)
            {
                System.out.print(arr[k]+"、");
            }
            System.out.println("");
            System.out.println("---------第"+(i+2)+"次刷过程-----------");
        }
    }

//    从上面的过程可以看到。后续的步骤中，有许多是重复的。

//    5优化
//    针对问题：
//    数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义的。
//    方案：
//    设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
//    这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。


    public static void BubbleSort1(int [] arr){

        int temp;//临时变量
        boolean flag;//是否交换的标志
        System.out.println("---------第"+1+"次刷过程------------");
        for(int i=0; i<arr.length-1; i++){   //表示趟数，一共arr.length-1次。

            System.out.println("---------第"+i+"次------------");
            flag = false;
            for(int j=arr.length-1; j>i; j--){

                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }

                for (int k = 0;k<=arr.length-1;k++)
                {
                    System.out.print(arr[k]+"、");
                }
                System.out.println();
            }

            System.out.println(flag);
            if(!flag) break;

            System.out.println("---------第"+(i+1)+"次刷后效果------------");
            for (int k = 0;k<=arr.length-1;k++)
            {
                System.out.print(arr[k]+"、");
            }
            System.out.println("");
            System.out.println("---------第"+(i+2)+"次刷过程-----------");
        }
    }

}

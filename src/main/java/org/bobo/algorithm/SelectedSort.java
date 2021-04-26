package org.bobo.algorithm;

import org.apache.commons.lang3.StringUtils;

/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description 选择排序
 */
class SelectedSort {

    public static void main(String[] args) {
        System.out.println("选择排序：最好情况O(n2)，最坏情况O(n2)");

        System.out.println("乱序情况");
        int[] unsorted1 = {1, 3, 4, 6, 78, 976, 3, 2, 4, 5};
        sort(unsorted1);
        System.out.println("最好情况");
        int[] unsorted2 = {1, 3, 4, 6, 11, 22, 33, 44, 78, 976};
        sort(unsorted2);
        System.out.println("第二好情况");
        int[] unsorted3 = {1, 3, 4, 11, 22, 33, 44, 79, 78, 976};
        sort(unsorted3);
        System.out.println("最坏情况");
        int[] unsorted4 = {13321, 1312, 123, 12, 10, 9, 4, 3, 2, 1};
        sort(unsorted4);
    }


    public static void sort(int[] args) {
        System.out.println("第0次排完前数据：" + StringUtils.join(args, ','));
        int count = 0;
        // 第一层循环
        for (int i = 0; i < args.length; i++) {
            // 第二层循环
            for (int j = i+1; j < args.length; j++) {
                count++;
                // 每次找出最小的值
                if (args[i] > args[j]) {
                    int temp = args[j];
                    args[j] = args[i];
                    args[i] = temp;
                }
            }
            System.out.println("第" + i + "次排完后数据：" + StringUtils.join(args, ','));
        }
        System.out.println("当n=" + args.length + "时，执行次数：" + count);
        System.out.println(StringUtils.join(args, ','));
    }
}
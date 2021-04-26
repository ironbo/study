package org.bobo.algorithm;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description 插入排序
 */
@Log4j2
class InsertSort {

    public static void main(String[] args) {
        log.info("插入排序：最好情况O(n)，最坏情况O(n2)");
        log.info("乱序情况");
        int[] unsorted1 = {1, 23, 10, 6, 78, 976, 3, 2, 4, 5};
        sort(unsorted1);
        log.info("最好情况");
        int[] unsorted2 = {1, 3, 4, 6, 11, 22, 33, 44, 78, 976};
        sort(unsorted2);
        log.info("第二好情况");
        int[] unsorted3 = {1, 3, 4, 11, 22, 33, 44, 79, 78, 976};
        sort(unsorted3);
        log.info("最坏情况");
        int[] unsorted4 = {13321, 1312, 123, 12, 10, 9, 4, 3, 2, 1};
        sort(unsorted4);
    }


    public static void sort(int[] args) {
        log.info("第0次排完前数据：" + StringUtils.join(args, ','));
        int count = 0;
        // 第一层循环，从第一个开始，默认第0个元素为有序序列
        for (int i = 1; i < args.length; i++) {
            // 第二层循环，从第i个开始，默认第i个前面的序列为有序的
            for (int j = i; j >= 1; j--) {
                count++;
                // 有序序列后面的元素往前做插入排序。由于前面的序列是有序的，若排到比前面的序列值大，则跳出循环
                if (args[j] < args[j - 1]) {
                    int temp = args[j];
                    args[j] = args[j - 1];
                    args[j - 1] = temp;
                } else {
                    break;
                }
            }
            log.info("第{}次排完后数据：{}", i, StringUtils.join(args, ','));
        }
        log.info("当n=" + args.length + "时，执行次数：" + count);
        log.info(StringUtils.join(args, ','));
    }
}
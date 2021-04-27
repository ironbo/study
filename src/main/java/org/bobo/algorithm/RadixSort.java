package org.bobo.algorithm;

import lombok.extern.log4j.Log4j2;

/**
 * @author huangjiangbo
 * @date 2021-04-27 13:31
 * @description 基数排序
 */
@Log4j2
public class RadixSort {

  public static void main(String[] args) {
    log.info("计数排序：当输入的元素是 n 个 0到 k 之间的整数时，时间复杂度是O(n+k)，空间复杂度也是O(n+k)");
    log.info("乱序情况");
    int[] unsorted1 = {1, 23, 10, 6, 22, 33, 3, 2, 4, 5};
    sort(unsorted1);
    log.info("最好情况");
    int[] unsorted2 = {1, 3, 4, 6, 11, 22, 33, 44, 78, 96};
    sort(unsorted2);
    log.info("第二好情况");
    int[] unsorted3 = {1, 3, 4, 11, 22, 33, 44, 79, 78, 97};
    sort(unsorted3);
    log.info("最坏情况");
    int[] unsorted4 = {1331, 132, 123, 12, 10, 9, 4, 3, 2, 1};
    sort(unsorted4);
  }

  private static void sort(int[] rows) {
    // TODO: 2021/4/27  
  }
}

package org.bobo.algorithm;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description 堆排序（大顶堆）
 */
@Log4j2
public class MaxHeapSort {

  public static AtomicInteger count = new AtomicInteger(0);

  public static void main(String[] args) {
    log.info("大顶堆排序");
    log.info("大顶堆排序：时间复杂度：O(nlog(2)(n))");
    log.info("大顶堆排序：空间复杂度：O(1)");
    log.info("大顶堆排序-稳定性：不稳定");
    log.info("乱序情况");
    int[] unsorted1 = {44, 54, 88, 66, 77, 976, 33, 2, 22, 5};
    sort(unsorted1);
    log.info("当n={}时，执行次数：{}", unsorted1.length, count);
    count = new AtomicInteger(0);

    log.info("最好情况");
    int[] unsorted2 = {1, 3, 4, 6, 11, 22, 33, 44, 78, 976};
    sort(unsorted2);
    log.info("当n={}时，执行次数：{}", unsorted2.length, count);
    count = new AtomicInteger(0);

    log.info("第二好情况");
    int[] unsorted3 = {1, 3, 4, 11, 22, 33, 44, 79, 78, 976};
    sort(unsorted3);
    log.info("当n={}时，执行次数：{}", unsorted3.length, count);
    count = new AtomicInteger(0);

    log.info("最坏情况");
    int[] unsorted4 = {13321, 1312, 123, 12, 10, 9, 4, 3, 2, 1};
    sort(unsorted4);
    log.info("当n={}时，执行次数：{}", unsorted4.length, count);
    count = new AtomicInteger(0);
  }


  public static void sort(int[] rows) {
    log.info("第0次排完前数据：" + StringUtils.join(rows, ','));

    // 初始化大顶堆
    int length = rows.length;
    for (int i = (length >> 1) - 1; i >= 0; i--) {
      buildMax(rows, length, i);
    }
    log.info("初始化大顶堆：" + StringUtils.join(rows, ','));

    for (; length >= 1; length--) {
      int temp = rows[0];
      rows[0] = rows[length - 1];
      rows[length - 1] = temp;
      log.info("第" + count.addAndGet(1) + "次排完后数据：" + StringUtils.join(rows, ','));
      buildMax(rows, length - 1, 0);

    }
  }

  public static void buildMax(int[] args, int length, int root) {
    int left = 2 * root + 1;
    int right = 2 * root + 2;
    int largest = root;
    // 左子节点比较
    if (left < length && args[left] > args[largest]) {
      largest = left;
    }
    // 右子节点比较
    if (right < length && args[right] > args[largest]) {
      largest = right;
    }
    // 当双亲节点不为最大值时，调整顺序，然后比较被调整顺序子节点是否仍然符合大顶堆的规则
    if (largest != root) {
      int temp = args[root];
      args[root] = args[largest];
      args[largest] = temp;
      buildMax(args, length, largest);
    }

  }
}
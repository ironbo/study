package org.bobo.algorithm;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description 选择排序
 */
@Log4j2
public class SelectedSort {

  public static void main(String[] args) {
    log.info("选择排序：时间复杂度：O(n2)");
    log.info("选择排序：空间复杂度：O(1)");
    log.info("选择排序-稳定性：不稳定");
    log.info("乱序情况");
    int[] unsorted1 = {1, 3, 4, 6, 78, 976, 3, 2, 4, 5};
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
    // 第一层循环
    for (int i = 0; i < args.length; i++) {
      // 第二层循环
      for (int j = i + 1; j < args.length; j++) {
        count++;
        // 每次找出最小的值
        if (args[i] > args[j]) {
          int temp = args[j];
          args[j] = args[i];
          args[i] = temp;
        }
      }
      log.info("第" + i + "次排完后数据：" + StringUtils.join(args, ','));
    }
    log.info("当n=" + args.length + "时，执行次数：" + count);
    log.info(StringUtils.join(args, ','));
  }
}
package org.bobo.algorithm;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.bobo.algorithm.entity.Bucket;

/**
 * @author huangjiangbo
 * @date 2021-04-27 13:31
 * @description 基数排序
 */
@Log4j2
public class RadixSort {

  public static void main(String[] args) {
    log.info("基数排序：时间复杂度：O(n*k)");
    log.info("基数排序：空间复杂度： O(n*k)");
    log.info("基数排序-稳定性：稳定");
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
    log.info("排序前：{}", StringUtils.join(rows, ','));

    int compareNum = 1;
    // 找出最大值,根据最大值的位数决定要比较的轮数，如果比较最大值的位数和最小值的位数差，可以减少比较的轮数
    int max = rows[0];
    for (int i : rows) {
      if (i > max) {
        max = i;
      }
    }

    int round = 0;
    while (compareNum <= max) {
      round++;
      compareNum = compareNum * 10;
    }
    log.info("一共需要排序{}轮", round);

    compareNum = 1;
    for (int i = 0; i < round; i++) {
      // 按0-9初始化10个桶
      List<Bucket> buckets = new ArrayList<>(10);
      for (int j = 0; j < 10; j++) {
        buckets.add(new Bucket());
      }
      for (int row : rows) {
        // 根据待比较的值的位数决定此轮比较的位数，先和待比较数的10倍值取模，再除以带比较数
        int num = row % (compareNum * 10);
        int radixNum = num / compareNum;
        Bucket bucket = buckets.get(radixNum);
        bucket.getElements().add(row);

      }
      int position = 0;
      for (Bucket bucket : buckets) {
        // 排序桶内的数据
        bucket.sortByInsertSort();
        // 写入数组
        position = bucket.set(rows, position);
      }
      log.info("第{}轮排序后数据列表：{}", i + 1, rows);
      // 比较个位、十位、百位...
      compareNum = compareNum * 10;
    }
  }
}

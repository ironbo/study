package org.bobo.algorithm;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.bobo.algorithm.entity.Bucket;

/**
 * @author huangjiangbo
 * @date 2021-04-27 13:31
 * @description 桶排序
 */
@Log4j2
public class BucketSort {

  public static void main(String[] args) {
    log.info("桶排序：时间复杂度：当输入的元素是 n 个 0到 k 之间的整数时，是O(n+k)");
    log.info("桶排序：空间复杂度：当输入的元素是 n 个 0到 k 之间的整数时，是O(n+k)");
    log.info("桶排序-稳定性：稳定");
    log.info("乱序情况");
    int[] unsorted1 = {1, 23, 10, 6, 22, 33, 3, 2, 4, 5};
    sort(unsorted1, 5);
    log.info("最好情况");
    int[] unsorted2 = {1, 3, 4, 6, 11, 22, 33, 44, 78, 96};
    sort(unsorted2, 4);
    log.info("第二好情况");
    int[] unsorted3 = {1, 3, 4, 11, 22, 33, 44, 79, 78, 97};
    sort(unsorted3, 4);
    log.info("最坏情况");
    int[] unsorted4 = {1331, 132, 123, 12, 10, 9, 4, 3, 2, 1};
    sort(unsorted4, 4);
  }

  private static void sort(int[] rows, int bucketNum) {
    log.info("排序前：{}", StringUtils.join(rows, ','));
    // 找出最大值和最小值
    int min = rows[0];
    int max = rows[0];
    for (int i : rows) {
      if (i > max) {
        max = i;
      }
      if (i < min) {
        min = i;
      }
    }
    int internal = (max - min) / bucketNum + 1;
    log.info("每个桶内包含的元素区间为：{}", internal);
    List<Bucket> buckets = new ArrayList<>(bucketNum);
    for (int j = 0; j < bucketNum; j++) {
      buckets.add(new Bucket());
    }
    for (int row : rows) {
      int num = (row - min) / internal;
      Bucket bucket = buckets.get(num);
      bucket.getElements().add(row);
    }
    int position = 0;
    for (Bucket bucket : buckets) {
      // 排序桶内的数据
      bucket.sortByInsertSort();
      // 写入数组
      position = bucket.set(rows, position);
    }
    log.info("排序后数据列表：{}", rows);

  }

}

package org.bobo.algorithm;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

/**
 * @author huangjiangbo
 * @date 2021-04-27 11:32
 * @description 计数排序，这里尝试了用bit数组作为下标值，这样可以减少空间复杂度 按照个人的理解，这种排序方式应该只适合最大值和最小值的差值不大的情况下
 */
@Log4j2
public class CountingSort {

  public static void main(String[] args) {
    log.info("计数排序：当输入的元素是 n 个 0到 k 之间的整数时，时间复杂度是O(n+k)，空间复杂度也是O(n+k)");
    log.info("乱序情况");
    int[] unsorted1 = {1, 23, 10, 6, 22, 33, 3, 2, 4, 5};
    sortByBit(unsorted1);
    log.info("最好情况");
    int[] unsorted2 = {1, 3, 4, 6, 11, 22, 33, 44, 78, 96};
    sortByBit(unsorted2);
    log.info("第二好情况");
    int[] unsorted3 = {1, 3, 4, 11, 22, 33, 44, 79, 78, 97};
    sortByBit(unsorted3);
    log.info("最坏情况");
    int[] unsorted4 = {1331, 132, 123, 12, 10, 9, 4, 3, 2, 1};
    sortByBit(unsorted4);
  }

  private static void sortByBit(int[] rows) {
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
    // 由于是按最小单位为bit的数组标记下标，
    // 但是java的最小处理单位为byte，所以这里左移3位，
    // 考虑到除不尽的情况，再增加一个byte
    byte[] counting = new byte[((max - min) >> 3) + 1];
    for (int i : rows) {
      //找出当前数字所对应的下标位置，先判断再哪个byte，再判断再哪个bit
      int byteIndex = (i - min) >> 3;
      byte bitIndex = (byte) ((i - min) % 8);
      byte b = (byte) (0x01 << bitIndex);
      counting[byteIndex] = (byte) (b + counting[byteIndex]);
    }
    log.info("排序中bit数组大小：{}，值：{}", counting.length, StringUtils.join(counting, ','));
    // 此时bit数组生成完毕，然后在查询bit位1的值，取出对应下标，最终就是排好序的序列了
    int index = 0;
    for (int i = 0; i < counting.length; i++) {
      // 当byte位0时，直接忽略，说明这个位置没有认为值
      if (counting[i] == 0) {
        continue;
      }
      int count = 0;
      // 由于一个byte只有8位，所以这里只需要向左位移7次，就能找到每个值位1的bit
      while (count < 8) {
        if (((0x01 << count) & (counting[i] & 0xff)) != 0) {
          rows[index++] = i * 8 + count + min;
        }
        count++;
      }
    }
    log.info("排序后：{}", StringUtils.join(rows, ','));

  }

}

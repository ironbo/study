package org.bobo.algorithm.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * @author huangjiangbo
 * @date 2021-04-28 16:39
 * @description 桶
 */
@Data
@Log4j2
public class Bucket {

  private List<Integer> elements = new ArrayList<>();

  public void sortByInsertSort() {
    if (elements.isEmpty()) {
      return;
    }
    elements.sort(Comparator.comparingInt(i -> i));
    log.info("插入排序后桶内数据：{}", elements);
  }

  public int set(int[] rows, int startPositon) {
    for (Integer element : elements) {
      rows[startPositon++] = element;
    }
    return startPositon;
  }
}

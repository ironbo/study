package org.bobo.algorithm.question;

import lombok.extern.log4j.Log4j2;

/**
 * @author huangjiangbo
 * @date 2021-05-05 17:16
 * @description 给定一个字符串，判断字符串是否是回文 1.字符串用数组的形式给定，char[] 2.字符串用链表的形式给定，SingleLinkedList
 */
@Log4j2
public class PalindromicQuestion {

  public static void main(String[] args) {
    log.info("数组形式字符串比较，时间复杂度为O(n)");
    String trueStr = "abcdefgfedcba";
    log.info("字符串：{}，数组比较结果：{}", trueStr, charDinstinguish(trueStr));
    log.info("字符串：{}，链表比较结果：{}", trueStr,
        linckedDinstinguish(SingleLinkedList.generateLinkedList(trueStr)));

    String falseStr = "abcdefsaewergfedcba";
    log.info("字符串：{}，数组比较结果：{}", falseStr, charDinstinguish(falseStr));
    log.info("字符串：{}，链表比较结果：{}", falseStr,
        linckedDinstinguish(SingleLinkedList.generateLinkedList(falseStr)));
  }

  public static boolean charDinstinguish(String str) {
    int length = str.length();
    int addIndex = 0;
    int decentIndex = length - 1;
    while (addIndex++ != decentIndex--) {
      if (str.charAt(addIndex) != str.charAt(decentIndex)) {
        return false;
      }
    }
    return true;
  }

  public static boolean linckedDinstinguish(SingleLinkedList head) {
    boolean isOdd = false;
    SingleLinkedList singleStep = head;
    SingleLinkedList doubleStep = head;
    SingleLinkedList tempLast = singleStep;
    SingleLinkedList tempNext = singleStep.getNext();

    while (doubleStep.getNext() != null) {
      doubleStep = doubleStep.getNext();
      if (doubleStep == null) {
        isOdd = true;
        break;
      }
      doubleStep = doubleStep.getNext();
      singleStep = tempNext;
      tempNext = singleStep.getNext();
      singleStep.setNext(tempLast);
      tempLast = singleStep;
    }
    if (isOdd) {
      tempNext = tempNext.getNext();
    }
    while ((tempNext = tempNext.getNext()) != null
        && (singleStep = singleStep.getNext()) != null) {
      if (tempNext.getData() != singleStep.getData()) {
        return false;
      }
    }

    return true;
  }
}

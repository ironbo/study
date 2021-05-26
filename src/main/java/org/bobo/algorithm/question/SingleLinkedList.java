package org.bobo.algorithm.question;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author huangjiangbo
 * @date 2021-05-05 17:12
 * @description 单链表结构
 */
@Data
@NoArgsConstructor
public class SingleLinkedList {

  private char data;
  private SingleLinkedList next;

  public SingleLinkedList(char data) {
    this.data = data;
  }


  /**
   * 构造单链表
   */
  public static SingleLinkedList generateLinkedList(String str) {
    char[] strChar = str.toCharArray();
    SingleLinkedList head = new SingleLinkedList(strChar[0]);
    SingleLinkedList last = head;
    for (int i = 1; i < strChar.length; i++) {
      SingleLinkedList singleLinkedList = new SingleLinkedList(strChar[i]);
      last.setNext(singleLinkedList);
      last = singleLinkedList;
    }
    return head;
  }

}

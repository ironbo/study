package org.bobo.function;

import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description java8中新引入的Stream类使用用例
 */
@Log4j2
public class StreamTest {

  public List<String> strList;

  @Before
  public void before() {
    strList = new ArrayList<>();
    strList.add("11122");
    strList.add("2");
    strList.add("5");
    strList.add("32");
    strList.add("421");
    strList.add("9");
    strList.add("4");
  }

  // terminal  intermediate
  @Test
  public void stream1() {
    Optional<String> any = strList.stream().filter(str -> Integer.parseInt(str) > 5).findAny();
    log.info("任何大于5的数字：" + any.orElse("error"));
    long count = strList.stream().filter(str -> Integer.parseInt(str) > 5).count();
    log.info("任何大于5的数字的个数：" + count);
    Set<Integer> collect = strList.stream().map(Integer::valueOf).collect(Collectors.toSet());
    log.info("转换后的集合个数：" + collect.size());
    List<String> collect1 = strList.stream().distinct().collect(Collectors.toList());
    log.info("原集合数量：" + strList.size());
    log.info("转换后集合数量：" + collect1.size());
    List<String> collect2 = strList.stream().flatMap(s -> Arrays.stream(s.split("")))
        .peek(e -> log.info("flatMap: " + e))
        .collect(Collectors.toList());
    log.info("flatMap后集合数量：" + collect2.size());
    String s = strList.stream()
        .reduce((a, b) -> String.valueOf((Integer.parseInt(a) + Integer.parseInt(b)))).get();
    log.info("reduce总数：" + s);
    String s1 =
        Stream.of("2", "4", "6")
            .parallel()
            .reduce(2, (a, b) -> a + Integer.parseInt(b), Integer::sum).toString();
    log.info("reduce多线程总数：" + s1);

    Map<String, Integer> map = strList.stream()
        .collect(Collectors.toMap(Function.identity(), String::length));
    map.forEach((k, v) -> {
      log.info("key:" + k);
      log.info("val:" + v);
    });


  }


}

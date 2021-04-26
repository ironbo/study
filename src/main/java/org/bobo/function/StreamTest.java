package org.bobo.function;

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
public class StreamTest {

    public List<String> strList;

    @Before
    public void before(){
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
    public void stream1(){
        Optional<String> any = strList.stream().filter(str -> Integer.parseInt(str) > 5).findAny();
        System.out.println("任何大于5的数字："+any.get());
        long count = strList.stream().filter(str -> Integer.parseInt(str) > 5).count();
        System.out.println("任何大于5的数字的个数："+count);
        Set<Integer> collect = strList.stream().map(Integer::valueOf).collect(Collectors.toSet());
        System.out.println("转换后的集合个数："+collect.size());
        List<String> collect1 = strList.stream().distinct().collect(Collectors.toList());
        System.out.println("原集合数量："+strList.size());
        System.out.println("转换后集合数量："+collect1.size());
        List<String> collect2 = strList.stream().flatMap(s -> Arrays.stream(s.split("")))
                .peek(e -> System.out.println("flatMap: " + e))
                .collect(Collectors.toList());
        System.out.println("flatMap后集合数量："+collect2.size());
        String s = strList.stream().reduce((a, b) -> String.valueOf((Integer.parseInt(a) + Integer.parseInt(b)))).get();
        System.out.println("reduce总数："+s);
        String s1 =
                Stream.of("2", "4", "6")
                        .parallel()
                        .reduce(2, (a, b) -> a + Integer.parseInt(b), Integer::sum).toString();
        System.out.println("reduce多线程总数："+s1);

        Map<String, Integer> map = strList.stream().collect(Collectors.toMap(Function.identity(), String::length));
        map.forEach((k,v)->{
            System.out.println("key:"+k);
            System.out.println("val:"+v);
        });





    }


}

package org.bobo.function;


import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description java8中新引入的双冒号表达式使用用例
 */
public class methodTest {

    @Test
    public void method() {
        //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        Car car = Car.create(Car::new);
        List<Car> cars = Collections.singletonList(car);

        //静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(Car::collide);

        //特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach(Car::repair);

        //特定对象的方法引用：它的语法是instance::method实例如下：
        Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

}
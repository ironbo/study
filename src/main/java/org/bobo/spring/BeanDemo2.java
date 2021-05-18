package org.bobo.spring;


import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Data
@Log4j2
@Service("123")
public class BeanDemo2 {

    private String aa;


    public static void main(String[] args) {
        int test = new BeanDemo2().test();
        System.out.println(test);
        BeanDemo2 beanDemo2 = new BeanDemo2().test1();
        System.out.println(beanDemo2.getAa());
    }

    public BeanDemo2 test1() {
        BeanDemo2 beanDemo2 = new BeanDemo2();
        try {
            beanDemo2.setAa("aa");
            return beanDemo2;
        } catch (Exception e) {
            beanDemo2.setAa("bb");
            return beanDemo2;
        } finally {
            beanDemo2.setAa("cc");
        }
    }

    public int test() {
        int x = 0;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

}

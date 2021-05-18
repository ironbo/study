package org.bobo.spring;


import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Data
@Log4j2
@Configuration
public class AutowirePostProcesserTest {

    @Autowired
    private String aa;
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AutowirePostProcesserTest.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean(AutowirePostProcesserTest.class).aa);



    }

    @Bean
    @Primary
    public  String hello2(){
        return "hello,word2";
    }

    @Bean
    public  String hello1(){
        return "hello,word1";
    }
}

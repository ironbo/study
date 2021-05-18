package org.bobo.spring;


import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.*;
import sun.misc.Signal;

@Data
@Log4j2
@ComponentScan("org.bobo.spring")
@Configuration
public class BeanDefiniton {

    private String aa;
    
    public static void main(String[] args) {

        Signal sig = new Signal("SIGTERM");

        Signal.handle(sig, new ShutdownHandler());

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDefiniton.class);
        applicationContext.refresh();
        applicationContext.getBeansOfType(String.class).forEach((s, s2) -> {
            System.out.println(s);
            System.out.println(s2);
        });


    }

    @Bean
    public  String hello2(){
        return "hello,word2";
    }

    @Bean
    public  String hello1(){
        return "hello,word1";
    }
}

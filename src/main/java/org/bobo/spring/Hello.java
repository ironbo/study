package org.bobo.spring;


import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.support.GenericApplicationContext;

@Data
@Log4j2
public class Hello {

    private String aa;
    
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext classPathXmlApplicationContext = new AnnotationConfigApplicationContext();
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
        beanDefinitionBuilder.addPropertyValue("aa","bb");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.setBeanClass(Hello.class);
        applicationContext.registerBeanDefinition("123",beanDefinition);
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition,applicationContext);
        applicationContext.refresh();
        System.out.println(applicationContext.getBeansOfType(Hello.class).size());
    }
}

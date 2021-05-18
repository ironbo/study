package org.bobo.spring;


import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Data
@Log4j2
@Service("123")
public class BeanDemo {

    private String aa;

}

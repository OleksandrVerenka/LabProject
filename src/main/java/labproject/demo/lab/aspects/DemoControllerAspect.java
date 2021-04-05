package labproject.demo.lab.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoControllerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @AfterThrowing(value = "execution(* labproject.demo.lab.DemoController.*(..))")
    public void afterReturn(JoinPoint joinPoint) {
        logger.info("{} returned with value", joinPoint);
    }



}

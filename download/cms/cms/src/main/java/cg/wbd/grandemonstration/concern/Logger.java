package cg.wbd.grandemonstration.concern;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))")
    public void log(){
        System.out.println("[CMS] error");
    }
}

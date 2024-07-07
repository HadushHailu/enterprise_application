package bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DAOLogAdvice {
    @After("execution(* bank.dao.*.*(..))")
    public void traceaftermethod(JoinPoint joinpoint) {
        System.out.println(" [+] after execution of method "+joinpoint.getSignature().getName());
    }
}

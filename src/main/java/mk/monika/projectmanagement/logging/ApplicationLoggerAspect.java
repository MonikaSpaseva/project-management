package mk.monika.projectmanagement.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(mk.monika.projectmanagement.controllers..*)")
    public void definePackagePointcuts(){
        // empty method just to name the location specified in the point cut
    }

//    @After("definePackagePointcuts()")
//    public void logAfter(JoinPoint jp){
//        log.debug("\n \n \n");
//        log.debug("*********** After Method Execution ********* \n {}.{} () with argument[s] = {}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
//        log.debug("_______________________________________________________________ \n \n \n");
//
//    }

    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint jp) throws Throwable {

        log.debug("\n \n \n");
        log.debug("*********** Before Method Execution ********* \n {}.{} () with argument[s] = {}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("_______________________________________________________________ \n \n \n");

       Object o = jp.proceed();

        log.debug("\n \n \n");
        log.debug("*********** After Method Execution ********* \n {}.{} () with argument[s] = {}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("_______________________________________________________________ \n \n \n");

        return o;
    }
}

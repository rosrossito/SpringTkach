package utility;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    Logger logger;

    @Pointcut("execution(* *.logevent(..))")
    private void allLogEventMethods(){}

    @Pointcut("allLogEventMethods()&&within(*.*File*Logger)")
    private void logEventInsideFileLoggers(){}

    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint){
        logger.info("Before: " +
        joinPoint.getTarget().getClass().getSimpleName()
        + " " +
        joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut="allLogEventMethods()",
    returning = "retVal")
    public void logAfter(Object retVal){
        logger.info("Returned value: " + retVal);
    }

    @AfterThrowing(pointcut="allLogEventMethods()",
            throwing = "ex")
    public void logAfterThrow(Throwable ex){
        logger.warning("Thrown: " + ex);
    }
}

package utility;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;

@Aspect
public class StatisticAspect {
    private Map <Class<?>, Integer> counter;

    @Pointcut("execution(* *.logevent(..))")
    private void allLogEventMethods(){}

    @AfterReturning("allLogEventMethods()")
    public void count (JoinPoint jp){
        Class<?> clazz = jp.getTarget().getClass();
        if(!counter.containsKey(clazz)){
            counter.put(clazz, 0);
        }
        counter.put(clazz,counter.get(clazz)+1);
    }
}

package db.schulung.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class TimerAspect {

    @Around("@annotation(timeMeAnnotation)")
    public Object timer(
            ProceedingJoinPoint joinPoint,
            TimeMe timeMeAnnotation) throws Throwable {

        Instant start = Instant.now();
        Object result = joinPoint.proceed();
        Thread.sleep(2L);
        Instant end = Instant.now();
        long time = timeMeAnnotation.value().between(start, end);
        System.out.println("Method time: " + time + " " + timeMeAnnotation.value());
        return result;
    }
}

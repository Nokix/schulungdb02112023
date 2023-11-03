package db.schulung.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class SafeResultsAspect {

    private final Map<String, Long> cache = new HashMap<>();

    @Around("@annotation(SafeResults)")
    public Object cacheMathResults(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = createKey(joinPoint);
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            long result = (Long) joinPoint.proceed();
            cache.put(key, result);
            return result;
        }
    }

    private String createKey(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        return methodName + "_" + java.util.Arrays.deepToString(args);
    }
}

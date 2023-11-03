package db.schulung.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.temporal.ChronoUnit;

@Retention(RetentionPolicy.RUNTIME)
public @interface TimeMe {
    ChronoUnit value() default ChronoUnit.NANOS;
}

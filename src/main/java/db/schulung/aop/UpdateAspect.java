package db.schulung.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UpdateAspect {

    @Pointcut("within(ShoppingCart)")
    void allShoppingCartMethods() {
    }

    @After("allShoppingCartMethods()")
//    @After("execution(* ShoppingCart.*Item(..))")
    void update(JoinPoint joinPoint) {
        ShoppingCart shoppingCart = (ShoppingCart) joinPoint.getTarget();

        shoppingCart.updateCountOfAll();
        shoppingCart.updatePriceOfAll();
    }

    @Around("allShoppingCartMethods() && args(item)")
    Object dontAllowExpensiveItems(
            ProceedingJoinPoint proceedingJoinPoint,
            Item item) throws Throwable {

        if (item.getPrice() > 5000) {
            return proceedingJoinPoint.proceed(new Object[]{null});
        }
        return proceedingJoinPoint.proceed();
    }
}

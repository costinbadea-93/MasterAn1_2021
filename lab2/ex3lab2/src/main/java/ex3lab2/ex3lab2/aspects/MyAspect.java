package ex3lab2.ex3lab2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class MyAspect {
    /**
     * JoinPoint => locul in care aspectul face interceptarea
     * PointCut => identifica locul unde trebuie sa se faca interceptarea
     *
     * Advice => cand si cum rulam noua logica raportat la locul interceptat
     * -Before (advice)
     * -After (ADVICE)
     * -After returning (advice)
     * -After throwing (advice)
     * -Around (advice)
     *
     * 1.@EnableAspectJAutoProxy
     * 2. definirea clasei de aspect prin adnotarea de @Aspect
     * 3. adaugarea aspectului in context(by default @Aspect nu adauga in context)
     */

    @Pointcut(value = "execution(* MainService.*(..))")
    public void operation(){}

//    @Before("operation()")
//    public void log(JoinPoint joinPoint){
//        System.out.println("Logging before " + joinPoint.getSignature().getName());
//    }

    @Around("operation()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Logging before " + proceedingJoinPoint.getSignature().getName());
        try {
           Object result = proceedingJoinPoint.proceed(new Object[] {"other test data"});
           return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}

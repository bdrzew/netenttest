package config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Class is used to automatically append logs to methods, which are used during tests
 */
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Defines which methods are going to be processed
     */
    @Pointcut("execution(public * page..*(..)) ||" +
            " execution(public * stepdefinition..*(..)) ||" +
            " execution(public * assertion..*(..))")
    public void defineEntryPoint() {}

    /**
     * Used to log class, name and arguments of selected method
     * @param joinPoint object storing information about selected method
     */
    @Before("defineEntryPoint()")
    public void executedMethod(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature().getDeclaringType().getSimpleName() + "."
            + joinPoint.getSignature().getName() + "("  + Arrays.toString(joinPoint.getArgs()) + ")");
    }
}
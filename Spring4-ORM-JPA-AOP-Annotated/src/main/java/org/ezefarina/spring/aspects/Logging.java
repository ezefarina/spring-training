package org.ezefarina.spring.aspects;

import com.google.common.base.Throwables;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

  private static Logger logger = LoggerFactory.getLogger(Logging.class);
	
	@Pointcut(value="execution( public * org.ezefarina.spring.repository.*.save*(..))")
	public void pointCut() {
	}
	
	@Before(value = "pointCut()")
	public void logParameters(final JoinPoint joinPoint){
    StringBuilder stringBuilder = new StringBuilder("Logging Advice: " + joinPoint.getSignature().toShortString());
    Object[] args = joinPoint.getArgs();
    if (args.length > 0) {
      stringBuilder.append(" - Input parameters: ");
      for (Object arg : args) {
        stringBuilder.append(arg);
      }
    } else {
      stringBuilder.append(" - No input parameters found ");
    }
    logger.info(stringBuilder.toString());
	}
	
	@AfterReturning(value="pointCut()",returning="returnedValue")
	public void logReturnValue(final JoinPoint joinPoint,Object returnedValue) {
    logger.info("Logging Advice: " + joinPoint.getSignature().toShortString() +
        (returnedValue==null ?
          " - Returned null or void" :
          " - Returning: " + returnedValue));
	}

	@AfterThrowing(pointcut = "execution( public * org.ezefarina.spring.repository.*.save*(..))", throwing = "ex")
	public void logException(Throwable ex) {
    logger.error("Logging Advice intercepted exception",ex);
    Throwables.propagate(ex);
  }

}

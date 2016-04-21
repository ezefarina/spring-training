package org.ezefarina.spring.aspects;

import com.google.common.base.Throwables;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component()
public class Validation {

  private static Logger logger = LoggerFactory.getLogger(Logging.class);

  @Around("execution( public * org.ezefarina.spring.repository.*.save*(..))")
	public Object isNotNull(ProceedingJoinPoint joinpoint){
    if (joinpoint.getArgs().length > 0 && joinpoint.getArgs()[0] == null) {
      logger.warn("Parámetro nulo. Evitando llamada");
    } else {
      if (joinpoint.getArgs().length > 0) {
        logger.info("Parámetro no nulo. Continuando llamada");
      } else {
        logger.info("No se recibieron parámetros. Continuando llamada");
      }
      try {
        return joinpoint.proceed(joinpoint.getArgs());
      } catch (Throwable throwable) {
        Throwables.propagate(throwable);
      }
    }
    return null;
	}

}

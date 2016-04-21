package org.ezefarina.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAnnotPointcuts {

  final Logger logger = LoggerFactory.getLogger(MyAnnotPointcuts.class);

  @Around(value="@annotation(myAnnot)")
  public Object display(ProceedingJoinPoint point, MyAnnot myAnnot) throws Throwable {

    Object result = point.proceed();
    logger.info("THIS IS MY ANNOTATION!! Result {}",result);

    return result;
  }

}

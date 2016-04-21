package org.ezefarina.spring.aspects;

import com.google.common.base.Throwables;
import org.aspectj.lang.ProceedingJoinPoint;

public class Validation {

  public Object isNotNull(ProceedingJoinPoint joinpoint) {
    if (joinpoint.getArgs().length > 0 && joinpoint.getArgs()[0] == null) {
      System.out.println("Parámetro nulo. Evitando llamada");
    } else {
      if (joinpoint.getArgs().length > 0) {
        System.out.println("Parámetro no nulo. Continuando llamada");
      } else {
        System.out.println("No se recibieron parámetros. Continuando llamada");
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

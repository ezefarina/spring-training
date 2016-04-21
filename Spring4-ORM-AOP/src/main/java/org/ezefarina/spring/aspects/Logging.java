package org.ezefarina.spring.aspects;

import com.google.common.base.Throwables;
import org.aspectj.lang.JoinPoint;

public class Logging {

  public void logParameters(final JoinPoint joinPoint) {
    System.out.print("*** Logging Advice: " + joinPoint.getSignature().toShortString());
    Object[] args = joinPoint.getArgs();
    if (args.length > 0) {
      System.out.print(" - Input parameters: ");
      for (Object arg : args) {
        System.out.print(arg);
      }
      System.out.println();
    } else {
      System.out.println(" - No input parameters found ");
    }
  }

  public void logReturnValue(final JoinPoint joinPoint, Object returnedValue) {
    System.out.print("*** Logging Advice: " + joinPoint.getSignature().toShortString());
    if (returnedValue == null) {
      System.out.println(" - Returned null or void");
    } else {
      System.out.println(" - Returning: " + returnedValue);
    }
  }

  public void logException(final JoinPoint joinPoint, Throwable ex) throws Throwable {
    System.out.println("*** Logging Advice intercepted exception: ");
    ex.printStackTrace();
    System.out.println();
    Throwables.propagate(ex);
  }

}

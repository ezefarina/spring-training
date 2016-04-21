package org.ezefarina.spring.repository;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AdviceTester {

  private static final Logger logger = LoggerFactory.getLogger(AdviceTester.class);

  public void saveReceiveSomething (Object o) {
    logger.debug("Ejecutado saveReceiveSomething");
  }

  public String saveRetrieveSomething () {
    logger.debug("Ejecutado saveRetrieveSomething");
    return getRandomString();
  }

  public String saveReceiveAndRetrieveSomething (Object o) {
    logger.debug("Ejecutado saveReceiveAndRetrieveSomething");
    return getRandomString();
  }

  public void saveThrowException () {
    logger.debug("Ejecutado saveThrowException");
    throw new java.lang.IllegalArgumentException();
  }

  private String getRandomString() {
    return RandomStringUtils.randomAlphanumeric(10);
  }

}

package org.ezefarina.spring.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class AdviceTester {

  public void receiveSomething (Object o) {
  }

  public String retrieveSomething () {
    return getRandomString();
  }

  public String receiveAndRetrieveSomething (Object o) {
    return getRandomString();
  }

  public void throwException () {
    throw new java.lang.IllegalArgumentException();
  }

  private String getRandomString() {
    return RandomStringUtils.randomAlphanumeric(10);
  }

}

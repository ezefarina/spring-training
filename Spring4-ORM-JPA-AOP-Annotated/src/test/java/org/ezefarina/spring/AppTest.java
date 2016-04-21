package org.ezefarina.spring;

import org.ezefarina.spring.config.TestAppConfig;
import org.ezefarina.spring.repository.AdviceTester;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.ezefarina.spring.entities.Articulo;
import org.ezefarina.spring.entities.Factura;
import org.ezefarina.spring.service.FacturaService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
@Rollback
@Transactional
public class AppTest extends TestCase {

  private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

  @Autowired ApplicationContext context;

  @Autowired AdviceTester adviceTester;

  @Test
  public void testApp() {
    FacturaService facturaService = context.getBean("facturaService", FacturaService.class);

    Factura factura = new Factura();
    Articulo tel = new Articulo("telefono", "caja", 1000.00f, 10);
    Articulo tv = new Articulo("tv", "caja", 3000.00f, 50);
    factura.getArticulos().add(tel);
    factura.getArticulos().add(tv);

    logger.debug("Factura insertada con ID {}", facturaService.crearFactura(factura));
  }

  @Test
  public void testNullParameter() {
    adviceTester.saveReceiveSomething(null);
  }

  @Test
  public void testLoggingInputParams() {
    adviceTester.saveReceiveSomething("test");
  }

  @Test
  public void testLoggingBothParams() {
    adviceTester.saveReceiveAndRetrieveSomething("test");
  }

  @Test
  public void testLoggingOutputParams() {
    adviceTester.saveRetrieveSomething();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLoggingException() {
    adviceTester.saveThrowException();
  }

  @Test
  public void testMyOwnAnnotation() {
    adviceTester.anotherTest();
  }

}

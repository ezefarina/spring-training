package org.ezefarina.spring;

import org.ezefarina.spring.test.AdviceTester;
import junit.framework.TestCase;

import org.ezefarina.spring.entities.Articulo;
import org.ezefarina.spring.entities.Factura;
import org.ezefarina.spring.service.FacturaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-test.xml"})
@Rollback
@Transactional
public class AppTest extends TestCase {

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

    System.out.println(facturaService.crearFactura(factura));
  }

  @Test
  public void testLoggingInputParams() {
    adviceTester.receiveSomething("test");
  }

  @Test
  public void testLoggingBothParams() {
    adviceTester.receiveAndRetrieveSomething("test");
  }

  @Test
  public void testLoggingOutputParams() {
    adviceTester.retrieveSomething();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLoggingException() {
    adviceTester.throwException();
  }

}

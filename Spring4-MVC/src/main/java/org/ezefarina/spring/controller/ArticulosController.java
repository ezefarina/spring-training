package org.ezefarina.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.ezefarina.spring.entities.Articulo;
import org.ezefarina.spring.service.ArticuloService;

@Controller
public class ArticulosController {

  @Autowired
  private ArticuloService articuloService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String root() {
    return "index";
  }

  @RequestMapping(value = "/articulos", method = RequestMethod.GET)
  public String init(ModelMap model) {
    model.addAttribute("articulo", new Articulo());

    List<Articulo> articulos = articuloService.listarArticulos();
    model.addAttribute("articulos", articulos);

    return "articulos";
  }

  @RequestMapping(value = "/agregarArticulo", method = RequestMethod.POST)
  public ModelAndView addContact(@ModelAttribute("articulo") @Valid Articulo articulo, BindingResult result) {

    ModelAndView model = new ModelAndView("articulos");

    if (result.hasErrors()) {
      return model;
    }

    articuloService.salvarArticulo(articulo);
    List<Articulo> articulos = articuloService.listarArticulos();

    model.addObject("articulos", articulos);

    return model;
  }

  @RequestMapping(value = "/articuloJson", method = RequestMethod.GET)
  public @ResponseBody Articulo articuloJson(ModelMap model) {
    Articulo articulo = new Articulo();
    articulo.setId(1L);
    articulo.setCantidad(12);
    return articulo;
  }

  @RequestMapping(value = "/illegal", method = RequestMethod.GET)
  public @ResponseBody Articulo illegal(ModelMap model) {
    throw new IllegalArgumentException("Test");
  }

  @RequestMapping(value = "/exception", method = RequestMethod.GET)
  public @ResponseBody Articulo exception(ModelMap model) throws Exception {
    throw new Exception();
  }

  @RequestMapping(value = "/data", method = RequestMethod.GET)
  public @ResponseBody Articulo data(ModelMap model) {
    throw new DataIntegrityViolationException("Test");
  }

}

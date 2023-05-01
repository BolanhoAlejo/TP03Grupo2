package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.util.*;

@Controller

public class ProductoController {
	/*
	public ProductoController(){
		
		Productos listado= new Productos();
		
	}
	*/
	
	@GetMapping("/producto")
	public ModelAndView solicitarProducto() {
		Producto unProducto= new Producto();
		ModelAndView name= new ModelAndView("producto");
		name.addObject("producto", unProducto);
		return name;
	}
	
	
	@PostMapping("/guardarProducto")
	public ModelAndView cargarProducto(@ModelAttribute("producto") Producto nuevoProducto, Productos listado) {
		nuevoProducto.setEstado(true);
		//Productos listado= new Productos();
		Productos.getListadoDeProductos().add(nuevoProducto);
		ModelAndView listadoFinal= new ModelAndView("mostrarListado");
		listadoFinal.addObject("listado", Productos.getListadoDeProductos());
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa: "+listado.getListadoDeProductos().get(0).getNombre());
		
		return listadoFinal;
	}
	
}

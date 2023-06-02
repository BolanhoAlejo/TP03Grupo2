package ar.edu.unju.edm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.util.Productos;
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
	
	@GetMapping("/eliminarProducto/{codigo}")
	public ModelAndView eliminarProducto(@PathVariable int codigo) {
	    for (Producto producto : Productos.getListadoDeProductos()) {
	        if (producto.getCodigo() == codigo) {
	            Productos.getListadoDeProductos().remove(producto);
	            break;
	        }
	    }
	    ModelAndView listadoFinal = new ModelAndView("mostrarListado");
	    listadoFinal.addObject("listado", Productos.getListadoDeProductos());
	    return listadoFinal;
	}


	@PostMapping("/guardarEdicion")
	public ModelAndView guardarEdicion(@ModelAttribute("producto") Producto productoEditado) {
	    for (int i = 0; i < Productos.getListadoDeProductos().size(); i++) {
	        Producto producto = Productos.getListadoDeProductos().get(i);
	        if (producto.getCodigo() == productoEditado.getCodigo()) {
	            Productos.getListadoDeProductos().set(i, productoEditado);
	            break;
	        }
	    }
	    ModelAndView listadoFinal = new ModelAndView("mostrarListado");
	    listadoFinal.addObject("listado", Productos.getListadoDeProductos());
	    return listadoFinal;
	}
	
}

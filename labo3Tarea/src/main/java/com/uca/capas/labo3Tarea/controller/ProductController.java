package com.uca.capas.labo3Tarea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.labo3Tarea.domain.Product;


@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		
		productos.add(new Product(0, "Hamburguesa", 30));
		productos.add(new Product(1, "Taco", 60));
		productos.add(new Product(2, "Pupusa", 60));
		productos.add(new Product(3, "Enchilada", 15));
		productos.add(new Product(4, "Quesadilla", 100));
	
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
	
		return mav;

	
	
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		Integer cantProducto = productos.get(product.getId()).getCantidad();
		Integer cantSolicitada = product.getCantidad();
		if(cantSolicitada>cantProducto) {
		mav.setViewName("error");
		mav.addObject("nombre", productos.get(product.getId()).getNombre());
		}
		else {
			mav.setViewName("compra");
			mav.addObject("nombre", productos.get(product.getId()).getNombre());
			
			
		}
		
		return mav;
		
	}
	
	
	
	
	
}

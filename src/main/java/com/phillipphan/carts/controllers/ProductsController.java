package com.phillipphan.carts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phillipphan.carts.models.Product;
import com.phillipphan.carts.services.ProductsRepository;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsRepository repo;

    @GetMapping({"", "/"})
    public String showProductList(Model model) {
        List<Product> products = repo.findAll(); // can add Sort.by() for sorting features. 
        model.addAttribute("products", products);
        return "products/index";
    }
}

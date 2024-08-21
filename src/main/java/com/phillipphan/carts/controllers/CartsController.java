package com.phillipphan.carts.controllers;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phillipphan.carts.models.Cart;
import com.phillipphan.carts.models.CartDto;
import com.phillipphan.carts.services.CartsRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/carts")
public class CartsController {
    @Autowired
    private CartsRepository repo;

    @GetMapping({"", "/"})
    public String showCartList(Model model) {
        List<Cart> carts = repo.findAll(); // can add Sort.by() for sorting features. 
        model.addAttribute("carts", carts);
        return "carts/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        CartDto cartDto = new CartDto();
        model.addAttribute("cartDto", cartDto);
        return "carts/CreateCart";
    }

    @PostMapping("/create")
    public String createCarts(@Valid @ModelAttribute CartDto cartDto, BindingResult result) {
        if(result.hasErrors()) {
            return "carts/CreateCart";
        }

        Date createdAt = new Date();

        Cart cart = new Cart();
        cart.setCartNumber(cartDto.getCartNumber());
        cart.setBuilding(cartDto.getBuilding());
        cart.setEid(cartDto.getEid());
        cart.setPhone(cartDto.getPhone());
        cart.setDescription(cartDto.getDescription());
        cart.setCreatedAt(createdAt);

        repo.save(cart);
        
        return "redirect:/carts";
    }

    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id) {
        try {
            Cart cart = repo.findById(id).get();
            model.addAttribute("cart", cart);

            CartDto cartDto = new CartDto();
            cartDto.setCartNumber(cart.getCartNumber());
            cartDto.setBuilding(cart.getBuilding());
            cartDto.setEid(cart.getEid());
            cartDto.setPhone(cart.getPhone());
            cartDto.setDescription(cart.getDescription());

            model.addAttribute("cartDto", cartDto);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/carts";
        }

        return "carts/EditCart";
    }

    @PostMapping("/edit")
    public String updateCart(Model model, @RequestParam int id, @Valid @ModelAttribute CartDto cartDto, BindingResult result) {
        try {
            Cart cart = repo.findById(id).get();
            model.addAttribute("cart", cart);

            if(result.hasErrors()) {
                return "carts/EditCart";
            }
            
            cart.setCartNumber(cartDto.getCartNumber());
            cart.setBuilding(cartDto.getBuilding());
            cart.setEid(cartDto.getEid());
            cart.setPhone(cartDto.getPhone());
            cart.setDescription(cartDto.getDescription());

            repo.save(cart);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        return "redirect:/carts";
    }

    @GetMapping("/delete")
    public String deleteCart(@RequestParam int id) {
        try {
            Cart cart = repo.findById(id).get();
            repo.delete(cart);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return "redirect:/carts";
    }
}

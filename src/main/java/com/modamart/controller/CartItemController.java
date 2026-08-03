package com.modamart.controller;

import com.modamart.entity.CartItem;
import com.modamart.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartItemService.addToCart(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCartItems(@PathVariable Long userId) {
        return cartItemService.getCartItemsByUserId(userId);
    }

    @DeleteMapping("/remove/{id}")
    public void removeCartItem(@PathVariable Long id) {
        cartItemService.removeCartItem(id);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable Long userId) {
        cartItemService.clearCartByUserId(userId);
    }

    @PutMapping("/update")
    public CartItem updateCartItem(@RequestBody CartItem item) {
        return cartItemService.updateCartItem(item);
    }
}




package com.modamart.service;

import com.modamart.entity.CartItem;
import com.modamart.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem addToCart(CartItem item) {
        return cartItemRepository.save(item);
    }

    public List<CartItem> getCartItemsByUserId(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    public void removeCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    public void clearCartByUserId(Long userId) {
        cartItemRepository.deleteByUserId(userId);
    }

    public CartItem updateCartItem(CartItem item) {
        return cartItemRepository.save(item);
    }
}



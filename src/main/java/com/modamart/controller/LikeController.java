package com.modamart.controller;

import com.modamart.entity.Like;
import com.modamart.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
@CrossOrigin(origins = "http://localhost:5173")
public class LikeController {

    @Autowired
    private LikeService likeService;

    // ✅ Like a product
    @PostMapping
    public Like likeProduct(@RequestBody Like like) {
        return likeService.likeProduct(like.getUserId(), like.getProductId());
    }

    // ✅ Unlike all products by user
    @DeleteMapping("/{userId}")
    public String unlikeAllByUser(@PathVariable Long userId) {
        likeService.unlikeAllByUser(userId);
        return "All liked products by user deleted successfully";
    }

    // ✅ Get liked products by user
    @GetMapping("/{userId}")
    public List<Like> getLikesByUser(@PathVariable Long userId) {
        return likeService.getLikesByUser(userId);
    }
}

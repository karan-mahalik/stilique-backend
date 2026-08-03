package com.modamart.service;

import com.modamart.entity.Like;
import com.modamart.repository.LikeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public Like likeProduct(Long userId, int productId) {
        Optional<Like> existing = likeRepository.findByUserIdAndProductId(userId, productId);
        if (existing.isPresent()) {
            return existing.get(); // Already liked
        }
        Like like = new Like(userId, productId);
        return likeRepository.save(like);
    }

    @Transactional
    public void unlikeAllByUser(Long userId) {
        likeRepository.deleteByUserId(userId);
    }

    public List<Like> getLikesByUser(Long userId) {
        return likeRepository.findByUserId(userId);
    }
}


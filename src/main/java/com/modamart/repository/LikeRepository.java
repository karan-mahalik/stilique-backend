package com.modamart.repository;

import com.modamart.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUserId(Long userId);
    Optional<Like> findByUserIdAndProductId(Long userId, int productId);
    void deleteByUserId(Long userId);
}
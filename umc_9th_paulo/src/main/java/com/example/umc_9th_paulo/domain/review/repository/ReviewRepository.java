package com.example.umc_9th_paulo.domain.review.repository;

import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {
    Page<Review> findAllByRestaurantAndUser(Restaurant restaurant, User user, Pageable pageable);
}

package com.example.umc_9th_paulo.domain.review.service;

import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.restaurant.exception.RestaurantException;
import com.example.umc_9th_paulo.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc_9th_paulo.domain.restaurant.repository.RestaurantRepository;
import com.example.umc_9th_paulo.domain.review.converter.ReviewConverter;
import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.review.repository.ReviewRepository;
import com.example.umc_9th_paulo.domain.user.entity.User;
import com.example.umc_9th_paulo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewCommandService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public ReviewResponseDto.SearchList searchReviewList(
            Integer page,
            Long restaurantId,
            Long userId
    ){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));

        //어차피 하드코딩이라 restaurant로 햇습니다
        User user = userRepository.findById(userId).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Review> result = reviewRepository.findAllByRestaurantAndUser(restaurant, user, pageRequest);
        return ReviewConverter.searchList(result);
    }
}

package com.example.umc_9th_paulo.domain.review.service;

import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.domain.review.entity.QReview;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.review.entity.ReviewPhoto;
import com.example.umc_9th_paulo.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public List<ReviewResponseDto.searchReview> searchReview(String regionName, Float star, Long userId) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(review.user.id.eq(userId));
        if(regionName != null) {
            builder.and(review.restaurant.region.name.eq(regionName));
        }
        if(star != null) {
            builder.and(review.score.goe(star));
        }
        List<Review> reviewList = reviewRepository.searchReview(builder);
        return reviewList.stream()
                .map(temp -> ReviewResponseDto.searchReview.builder()
                        .star(temp.getScore())
                        .restaurantName(temp.getRestaurant().getName())
                        .content(temp.getContent())
                        .images(temp.getReviewPhotos().stream()
                                .map(ReviewPhoto::getImageUrl)
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }
}

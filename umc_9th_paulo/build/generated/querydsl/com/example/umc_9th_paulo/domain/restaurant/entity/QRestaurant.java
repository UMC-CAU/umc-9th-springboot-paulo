package com.example.umc_9th_paulo.domain.restaurant.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurant is a Querydsl query type for Restaurant
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurant extends EntityPathBase<Restaurant> {

    private static final long serialVersionUID = 626833923L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurant restaurant = new QRestaurant("restaurant");

    public final com.example.umc_9th_paulo.global.entity.QBaseEntity _super = new com.example.umc_9th_paulo.global.entity.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final ListPath<com.example.umc_9th_paulo.domain.mission.entity.Mission, com.example.umc_9th_paulo.domain.mission.entity.QMission> missions = this.<com.example.umc_9th_paulo.domain.mission.entity.Mission, com.example.umc_9th_paulo.domain.mission.entity.QMission>createList("missions", com.example.umc_9th_paulo.domain.mission.entity.Mission.class, com.example.umc_9th_paulo.domain.mission.entity.QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<OwnerRestaurant, QOwnerRestaurant> ownerRestaurants = this.<OwnerRestaurant, QOwnerRestaurant>createList("ownerRestaurants", OwnerRestaurant.class, QOwnerRestaurant.class, PathInits.DIRECT2);

    public final QRegion region;

    public final EnumPath<com.example.umc_9th_paulo.domain.restaurant.enums.ResType> restaurantType = createEnum("restaurantType", com.example.umc_9th_paulo.domain.restaurant.enums.ResType.class);

    public final ListPath<com.example.umc_9th_paulo.domain.review.entity.Review, com.example.umc_9th_paulo.domain.review.entity.QReview> reviews = this.<com.example.umc_9th_paulo.domain.review.entity.Review, com.example.umc_9th_paulo.domain.review.entity.QReview>createList("reviews", com.example.umc_9th_paulo.domain.review.entity.Review.class, com.example.umc_9th_paulo.domain.review.entity.QReview.class, PathInits.DIRECT2);

    public final NumberPath<Integer> star = createNumber("star", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRestaurant(String variable) {
        this(Restaurant.class, forVariable(variable), INITS);
    }

    public QRestaurant(Path<? extends Restaurant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurant(PathMetadata metadata, PathInits inits) {
        this(Restaurant.class, metadata, inits);
    }

    public QRestaurant(Class<? extends Restaurant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}


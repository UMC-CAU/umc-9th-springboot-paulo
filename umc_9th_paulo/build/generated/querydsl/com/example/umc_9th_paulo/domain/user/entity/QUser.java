package com.example.umc_9th_paulo.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 822866847L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.example.umc_9th_paulo.global.entity.QBaseEntity _super = new com.example.umc_9th_paulo.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inactivedAt = createDateTime("inactivedAt", java.time.LocalDateTime.class);

    public final ListPath<com.example.umc_9th_paulo.domain.inquiry.entity.Inquiry, com.example.umc_9th_paulo.domain.inquiry.entity.QInquiry> inquiries = this.<com.example.umc_9th_paulo.domain.inquiry.entity.Inquiry, com.example.umc_9th_paulo.domain.inquiry.entity.QInquiry>createList("inquiries", com.example.umc_9th_paulo.domain.inquiry.entity.Inquiry.class, com.example.umc_9th_paulo.domain.inquiry.entity.QInquiry.class, PathInits.DIRECT2);

    public final StringPath nickname = createString("nickname");

    public final ListPath<com.example.umc_9th_paulo.domain.restaurant.entity.OwnerRestaurant, com.example.umc_9th_paulo.domain.restaurant.entity.QOwnerRestaurant> ownerRestaurants = this.<com.example.umc_9th_paulo.domain.restaurant.entity.OwnerRestaurant, com.example.umc_9th_paulo.domain.restaurant.entity.QOwnerRestaurant>createList("ownerRestaurants", com.example.umc_9th_paulo.domain.restaurant.entity.OwnerRestaurant.class, com.example.umc_9th_paulo.domain.restaurant.entity.QOwnerRestaurant.class, PathInits.DIRECT2);

    public final ListPath<com.example.umc_9th_paulo.domain.review.entity.Review, com.example.umc_9th_paulo.domain.review.entity.QReview> reviews = this.<com.example.umc_9th_paulo.domain.review.entity.Review, com.example.umc_9th_paulo.domain.review.entity.QReview>createList("reviews", com.example.umc_9th_paulo.domain.review.entity.Review.class, com.example.umc_9th_paulo.domain.review.entity.QReview.class, PathInits.DIRECT2);

    public final EnumPath<com.example.umc_9th_paulo.domain.user.enums.Role> role = createEnum("role", com.example.umc_9th_paulo.domain.user.enums.Role.class);

    public final BooleanPath status = createBoolean("status");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUserAuth userAuth;

    public final ListPath<UserFood, QUserFood> userFoods = this.<UserFood, QUserFood>createList("userFoods", UserFood.class, QUserFood.class, PathInits.DIRECT2);

    public final QUserInfo userInfo;

    public final ListPath<com.example.umc_9th_paulo.domain.mission.entity.UserMission, com.example.umc_9th_paulo.domain.mission.entity.QUserMission> userMissions = this.<com.example.umc_9th_paulo.domain.mission.entity.UserMission, com.example.umc_9th_paulo.domain.mission.entity.QUserMission>createList("userMissions", com.example.umc_9th_paulo.domain.mission.entity.UserMission.class, com.example.umc_9th_paulo.domain.mission.entity.QUserMission.class, PathInits.DIRECT2);

    public final QUserPoint userPoint;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userAuth = inits.isInitialized("userAuth") ? new QUserAuth(forProperty("userAuth"), inits.get("userAuth")) : null;
        this.userInfo = inits.isInitialized("userInfo") ? new QUserInfo(forProperty("userInfo"), inits.get("userInfo")) : null;
        this.userPoint = inits.isInitialized("userPoint") ? new QUserPoint(forProperty("userPoint"), inits.get("userPoint")) : null;
    }

}


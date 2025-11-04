package com.example.umc_9th_paulo.domain.restaurant.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOwnerRestaurant is a Querydsl query type for OwnerRestaurant
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOwnerRestaurant extends EntityPathBase<OwnerRestaurant> {

    private static final long serialVersionUID = 1574204234L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOwnerRestaurant ownerRestaurant = new QOwnerRestaurant("ownerRestaurant");

    public final com.example.umc_9th_paulo.global.entity.QBaseEntity _super = new com.example.umc_9th_paulo.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QRestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.umc_9th_paulo.domain.user.entity.QUser user;

    public QOwnerRestaurant(String variable) {
        this(OwnerRestaurant.class, forVariable(variable), INITS);
    }

    public QOwnerRestaurant(Path<? extends OwnerRestaurant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOwnerRestaurant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOwnerRestaurant(PathMetadata metadata, PathInits inits) {
        this(OwnerRestaurant.class, metadata, inits);
    }

    public QOwnerRestaurant(Class<? extends OwnerRestaurant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
        this.user = inits.isInitialized("user") ? new com.example.umc_9th_paulo.domain.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}


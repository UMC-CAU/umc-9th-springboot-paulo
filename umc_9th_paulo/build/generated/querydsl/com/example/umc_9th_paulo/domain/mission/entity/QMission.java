package com.example.umc_9th_paulo.domain.mission.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = -404032465L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final com.example.umc_9th_paulo.global.entity.QBaseEntity _super = new com.example.umc_9th_paulo.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath missionDescription = createString("missionDescription");

    public final NumberPath<Integer> remainingDuration = createNumber("remainingDuration", Integer.class);

    public final com.example.umc_9th_paulo.domain.restaurant.entity.QRestaurant restaurant;

    public final StringPath reward = createString("reward");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<UserMission, QUserMission> userMissions = this.<UserMission, QUserMission>createList("userMissions", UserMission.class, QUserMission.class, PathInits.DIRECT2);

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new com.example.umc_9th_paulo.domain.restaurant.entity.QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}


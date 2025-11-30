package com.example.umc_9th_paulo.domain.mission.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserMission is a Querydsl query type for UserMission
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserMission extends EntityPathBase<UserMission> {

    private static final long serialVersionUID = 794610788L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserMission userMission = new QUserMission("userMission");

    public final com.example.umc_9th_paulo.global.entity.QBaseEntity _super = new com.example.umc_9th_paulo.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isSuccess = createBoolean("isSuccess");

    public final QMission mission;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.umc_9th_paulo.domain.user.entity.QUser user;

    public QUserMission(String variable) {
        this(UserMission.class, forVariable(variable), INITS);
    }

    public QUserMission(Path<? extends UserMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserMission(PathMetadata metadata, PathInits inits) {
        this(UserMission.class, metadata, inits);
    }

    public QUserMission(Class<? extends UserMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
        this.user = inits.isInitialized("user") ? new com.example.umc_9th_paulo.domain.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}


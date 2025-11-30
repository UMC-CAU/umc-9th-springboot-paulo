package com.example.umc_9th_paulo.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserInfo is a Querydsl query type for UserInfo
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserInfo extends EntityPathBase<UserInfo> {

    private static final long serialVersionUID = 482206957L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserInfo userInfo = new QUserInfo("userInfo");

    public final com.example.umc_9th_paulo.global.entity.QBaseEntity _super = new com.example.umc_9th_paulo.global.entity.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DateTimePath<java.time.LocalDateTime> birth = createDateTime("birth", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.example.umc_9th_paulo.domain.user.enums.Gender> gender = createEnum("gender", com.example.umc_9th_paulo.domain.user.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath phoneNum = createString("phoneNum");

    public final BooleanPath phoneNumVerification = createBoolean("phoneNumVerification");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QUserInfo(String variable) {
        this(UserInfo.class, forVariable(variable), INITS);
    }

    public QUserInfo(Path<? extends UserInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserInfo(PathMetadata metadata, PathInits inits) {
        this(UserInfo.class, metadata, inits);
    }

    public QUserInfo(Class<? extends UserInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}


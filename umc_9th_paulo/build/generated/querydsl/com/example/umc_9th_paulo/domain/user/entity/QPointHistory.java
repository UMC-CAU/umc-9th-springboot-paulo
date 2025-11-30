package com.example.umc_9th_paulo.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPointHistory is a Querydsl query type for PointHistory
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPointHistory extends EntityPathBase<PointHistory> {

    private static final long serialVersionUID = -1267484488L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPointHistory pointHistory = new QPointHistory("pointHistory");

    public final com.example.umc_9th_paulo.global.entity.QBaseEntity _super = new com.example.umc_9th_paulo.global.entity.QBaseEntity(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.example.umc_9th_paulo.domain.user.enums.TransactionType> transactionType = createEnum("transactionType", com.example.umc_9th_paulo.domain.user.enums.TransactionType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUserPoint userPoint;

    public QPointHistory(String variable) {
        this(PointHistory.class, forVariable(variable), INITS);
    }

    public QPointHistory(Path<? extends PointHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPointHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPointHistory(PathMetadata metadata, PathInits inits) {
        this(PointHistory.class, metadata, inits);
    }

    public QPointHistory(Class<? extends PointHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userPoint = inits.isInitialized("userPoint") ? new QUserPoint(forProperty("userPoint"), inits.get("userPoint")) : null;
    }

}


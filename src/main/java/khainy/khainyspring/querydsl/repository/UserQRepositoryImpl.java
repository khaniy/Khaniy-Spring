package khainy.khainyspring.querydsl.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import khainy.khainyspring.querydsl.dto.FavoriteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@Service
@RequiredArgsConstructor
public class UserQRepositoryImpl implements UserQRepository {

    private final JPAQueryFactory queryFactory;
    private static final QUserEntity USER = QUserEntity.userEntity;
    private static final QUserFavoriteEntity USER_FAVORITE = QUserFavoriteEntity.userFavoriteEntity;

    @Override
    public List<FavoriteDTO> findUserFavorites() {
        return queryFactory.selectFrom(USER)
            .leftJoin(USER_FAVORITE).on(USER_FAVORITE.userId.eq(USER.id))
//            .orderBy(USER.id.asc())
            //
            .transform(groupBy(USER.id).list(Projections.constructor(
                FavoriteDTO.class,
                USER.name,
                list(USER_FAVORITE.favorite)))
            );
    }

//    @Override
//    public List<FavoriteDTO> findUserFavorites() {
//        Map<Long, FavoriteDTO> result = queryFactory.selectFrom(USER)
//            .leftJoin(USER_FAVORITE).on(USER_FAVORITE.userId.eq(USER.id))
//            .orderBy(USER.id.asc())
//            //
//            .transform(groupBy(USER.id).as(Projections.constructor(
//                FavoriteDTO.class,
//                USER.name,
//                list(USER_FAVORITE.favorite)))
//            );
//        return result.values().stream().toList();
//    }
}

package khainy.khainyspring.inheritance_entity.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import khainy.khainyspring.inheritance_entity.repository.entity.ParentEntity;
import khainy.khainyspring.inheritance_entity.repository.entity.QDogEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentQRepository {

    private final JPAQueryFactory queryFactory;
    private static final QDogEntity DOG = QDogEntity.dogEntity;

    public ParentEntity findDog(Long id) {
        return queryFactory.selectFrom(DOG).where(DOG.id.eq(id)).fetchOne();
    }


}

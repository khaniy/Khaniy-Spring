package khainy.khainyspring.inheritance_entity.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import khainy.khainyspring.inheritance_entity.repository.entity.ParentEntity;
import khainy.khainyspring.inheritance_entity.repository.entity.QChildEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentQRepository {

    private final JPAQueryFactory queryFactory;
    private static final QChildEntity CHILD = QChildEntity.childEntity;

    public ParentEntity findDog(Long id) {
        return queryFactory.selectFrom(CHILD).where(CHILD.id.eq(id)).fetchOne();
    }


}

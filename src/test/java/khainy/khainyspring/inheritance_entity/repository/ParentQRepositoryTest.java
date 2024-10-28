package khainy.khainyspring.inheritance_entity.repository;

import khainy.khainyspring.inheritance_entity.repository.entity.ChildEntity;
import khainy.khainyspring.inheritance_entity.repository.entity.ParentEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ParentQRepositoryTest {

    @Autowired
    ParentQRepository parentQRepository;

    @Autowired
    ParentClassRepository parentClassRepository;

    @Autowired
    ChildClassRepository childClassRepository;

    @Test
    void findDog() {
        ParentEntity parentEntity = parentClassRepository.save(ParentEntity.builder()
            .name("dog1")
            .build());
        ChildEntity childEntity = childClassRepository.save(ChildEntity.builder()
            .name("dog2")
            .color("white")
            .build());

        ParentEntity dog1 = parentQRepository.findDog(childEntity.getId());
        if (dog1 instanceof ChildEntity whiteDog) {
            System.out.println("whiteDog.getColor() = " + whiteDog.getColor());
        }
        Assertions.assertThat(dog1).isInstanceOf(ParentEntity.class);

        ParentEntity dog2 = parentQRepository.findDog(parentEntity.getId());
        Assertions.assertThat(dog2).isInstanceOf(ChildEntity.class);
    }
}
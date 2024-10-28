package khainy.khainyspring.inheritance_entity.repository;

import khainy.khainyspring.inheritance_entity.repository.entity.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildClassRepository extends JpaRepository<ChildEntity, Long> {
}

package khainy.khainyspring.inheritance_entity.repository;

import khainy.khainyspring.inheritance_entity.repository.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentClassRepository extends JpaRepository<ParentEntity, Long> {
}

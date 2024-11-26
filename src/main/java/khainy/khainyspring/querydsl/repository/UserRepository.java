package khainy.khainyspring.querydsl.repository;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>, UserQRepository{

}

package khainy.khainyspring.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserQRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFavoriteRepository userFavoriteRepository;

    UserEntity yuna;
    UserEntity minsu;

    @BeforeEach
    void setUp() {
        yuna = userRepository.save(UserEntity.builder().name("YuNa").build());
        minsu = userRepository.save(UserEntity.builder().name("MinSU").build());
        userFavoriteRepository.save(UserFavoriteEntity.builder().userId(yuna.getId()).favorite("APPLE1").build());
        userFavoriteRepository.save(UserFavoriteEntity.builder().userId(yuna.getId()).favorite("BANNA").build());
        userFavoriteRepository.save(UserFavoriteEntity.builder().userId(minsu.getId()).favorite("PIZZA").build());
        userFavoriteRepository.save(UserFavoriteEntity.builder().userId(yuna.getId()).favorite("APPLE3").build());
        userFavoriteRepository.save(UserFavoriteEntity.builder().userId(yuna.getId()).favorite("APPLE2").build());
        userFavoriteRepository.save(UserFavoriteEntity.builder().userId(minsu.getId()).favorite("CHICKEN").build());
        userFavoriteRepository.save(UserFavoriteEntity.builder().userId(minsu.getId()).favorite("CHICKEN").build());
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        userFavoriteRepository.deleteAll();
    }

    @Transactional
    @Test
    void findUserFavorites() {
        //given

        //when
        final var result = userRepository.findUserFavorites();
        System.out.println("result = " + result);

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Transactional
    @Test
    void findUserFavorites2() {


        //when
        final var result = userRepository.findUserFavorites();
        System.out.println("result = " + result);

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Test
//    void findUserFavorites3() {
//        //given
////        update();
//
//        //when
//        final var result = userRepository.findUserFavorites();
//        System.out.println("result = " + result);
//
//        //then
//        Assertions.assertThat(result.size()).isEqualTo(2);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    void update() {
//        var apple = userFavoriteRepository.findById(this.apple.getId()).orElseGet(null);
//        userFavoriteRepository.save(UserFavoriteEntity.builder()
//            .id(apple.getId())
//            .userId(apple.getUserId())
//            .favorite("PIZZA4").build());
//
//    }


}
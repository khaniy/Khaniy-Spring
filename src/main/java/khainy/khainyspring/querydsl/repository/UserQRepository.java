package khainy.khainyspring.querydsl.repository;

import khainy.khainyspring.querydsl.dto.FavoriteDTO;

import java.util.List;

public interface UserQRepository {
    List<FavoriteDTO> findUserFavorites();
}

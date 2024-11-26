package khainy.khainyspring.querydsl.dto;

import java.util.List;

public record FavoriteDTO(
    String name,
    List<String> favorites
) {
}

package khainy.khainyspring.inheritance_entity.repository.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "color_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("WHITE")
@NoArgsConstructor
@AllArgsConstructor
public class ChildEntity extends ParentEntity {

    private String color;
}

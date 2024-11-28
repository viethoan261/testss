package com.example.education.model;

import com.example.education.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "room")
public class RoomModel extends BaseEntity {
    @Column(name = "room_no", nullable = false)
    private String roomNo;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "capacity", nullable = false)
    private int capacity;
}

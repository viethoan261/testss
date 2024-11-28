package com.example.education.model;

import com.example.education.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "service")
public class ServiceModel extends BaseEntity {
    @Column(name = "service_no", nullable = false)
    private String serviceNo;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    private String price;

    @Column(name = "time_used", nullable = false)
    private double timeUsed;
}

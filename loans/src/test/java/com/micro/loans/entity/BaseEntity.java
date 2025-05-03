package com.micro.loans.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class BaseEntity {

    private LocalDateTime createdAt;

}

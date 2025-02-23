package com.micro.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.ToString;

import java.time.LocalDateTime;


@ToString
@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "created_by" ,updatable = false)
    private String createdBy;
    @Column(name = "updated_at",insertable = false)
    private LocalDateTime updatedAt;
    @Column(name = "updated_by" ,insertable = false)
    private String updatedBy;


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

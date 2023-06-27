package com.non.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.sql.Timestamp;

@Data
@MappedSuperclass
public class BaseEntity {
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createdBy;
    private String updatedBy;
}

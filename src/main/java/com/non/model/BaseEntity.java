package com.non.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    //    @CreatedBy
//    private String createdBy;
//
    @CreatedDate
    private Timestamp createdAt;

//    @LastModifiedBy
//    private String updatedBy;

    @LastModifiedDate
    private Timestamp updateAt;
}

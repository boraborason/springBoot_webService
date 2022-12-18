package com.sbr.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity클래스들이 BaseTimeEntity을 상속할 경우 하기 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity클래스에 Auditing기능을 포함시킨다.
public abstract class BaseTimeEntity { //모든 엔티티의 상위클래스로 날짜타입을 관리한다.

    @CreatedDate //엔티티들이 생성되어 저장될 때 시간이 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate//엔티티의 값을 변경할 때 시간이 자동저장
    private LocalDateTime modifiedDate;

}

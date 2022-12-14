package com.sbr.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
* 사용자 권한을 관리할 class
* */
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"), //스프링 시큐리티에서는 권한코드에 항상 ROLE_이 있어야함
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}

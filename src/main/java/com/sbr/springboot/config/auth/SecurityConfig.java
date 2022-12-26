package com.sbr.springboot.config.auth;

import com.sbr.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring Security설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()//h2-console화면을 사용하기 위해 해당 옵션 disable
                .and()
                .authorizeRequests()//url별 권한 관리를 설정하는 옵션 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //권한 관리 대상을 지정하는 옵션
                .anyRequest().authenticated()//설정된 값들 이외 나머지 url, 나머지 url들은 인증된 사용자에게만 허용하도록
                .and()
                .logout()//로그아웃 설정의 진입점
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()//로그인 기능에 대한 설정 진입점
                .userInfoEndpoint()//OAuth2로그인 이후 사용자 정보를 가져올 때 설정담당
                .userService(customOAuth2UserService);
    }
}
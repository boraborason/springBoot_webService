package com.sbr.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)  //TEST시 junit에 내장된 실행자 외 실행자(SpringRunner.class)를 실행시킨다. 스프링 부트와 jUnit사이 열결 역할
@WebMvcTest(controllers = HelloController.class)//Spring MVC 에만 집중 할 수 있는 테스트 어노테이션

public class HelloControllerTest {

    @Autowired//빈 주입받음
    private MockMvc mvc; //스프링 MVC테스트 시작점

    //@WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc를 통해 /hello주소로 HTTP GET을 요청합니다.
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    //@WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name) //api테스트시 사용될 요청 파라미터 설정 String만 가능
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //json응답값을 필드별로 검증할 수 있는 메소드 $필드명
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}

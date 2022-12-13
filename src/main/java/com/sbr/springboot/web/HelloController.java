package com.sbr.springboot.web;

import com.sbr.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//json을 반환하는 컨트롤러 -> @ResponseBody상위 버전
public class HelloController {

    @GetMapping("/hello")//get요청을 받을 수 있는 api
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, //외부에서 api로 넘긴 파라미터를 가져옴 String name에 저장
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}

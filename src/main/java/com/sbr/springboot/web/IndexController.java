package com.sbr.springboot.web;

import com.sbr.springboot.config.auth.LoginUser;
import com.sbr.springboot.config.auth.dto.SessionUser;
import com.sbr.springboot.service.PostsService;
import com.sbr.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController { //뷰 관련

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")                  //어느 컨트롤러든지 @LoginUser 만 사용하면 세션 정보를 가져올 수 있게 된다.
    public String index(Model model,  @LoginUser SessionUser user) { //Model -> postsService.findAllDesc()가져온 결과를 posts로 index.머스테치로 전달
        model.addAttribute("posts", postsService.findAllDesc());
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");//CustomOAuth2UserService에서 로그인 성공시 세션에
                                                                                // SessionUser를 저장

        if (user != null) { //세션에 지정된 값이 있을 때만 model에 userName으로 등록
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

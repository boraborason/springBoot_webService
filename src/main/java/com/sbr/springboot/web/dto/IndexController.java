package com.sbr.springboot.web.dto;

import com.sbr.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController { //뷰 관련

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { //Model -> postsService.findAllDesc()가져온 결과를 posts로 index.머스테치로 전달
        model.addAttribute("posts", postsService.findAllDesc());
        /*if (user != null) {
            model.addAttribute("userName", user.getName());
        }*/
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

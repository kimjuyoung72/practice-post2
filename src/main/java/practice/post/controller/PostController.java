package practice.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.post.domain.Article;
import practice.post.dto.PostList;
import practice.post.service.ArticleService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final ArticleService service;
    @GetMapping("")
    public String list(Model model) {
        List<PostList> list = service.findAllArticle();
        model.addAttribute("articles", list);
        return "list";
    }
    @GetMapping("post")
    public String editForm() {
        return "editForm";
    }

}

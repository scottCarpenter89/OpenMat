package com.example.restblog.web;

import com.example.restblog.data.CategoriesRepository;
import com.example.restblog.data.Category;
import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;

    public CategoriesController(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

//    @GetMapping("searchPostByCategory")
//    private List<Post> getPostsByCategory(@RequestParam String categoryName) {
//        List<Post> postsByCategory = new ArrayList<>();
//
//      return postsByCategory.;
//    }
}

package com.wzz.service;

import com.wzz.entity.Blog;

import java.util.List;
import java.util.Map;

public interface  BlogListService {
    List<Blog> findAll();

    void createBlog(Map params);
}

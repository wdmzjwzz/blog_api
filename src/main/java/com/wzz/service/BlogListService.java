package com.wzz.service;

import com.wzz.entity.Blog;

import java.util.List;
import java.util.Map;

public interface  BlogListService {
    List<Blog> findAll(Map params);

    void createBlog(Map params);
    int deleteBlogById(String id);

    int updateBlogById(Map params);

    List<Blog>  getBlogById(String id);
}

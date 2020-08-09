package com.wzz.impl;

import com.wzz.entity.Blog;
import com.wzz.mapper.BlogMapper;
import com.wzz.service.BlogListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("BlogDirListService")
public class BlogListServiceimpl implements BlogListService {
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public List<Blog> findAll(Map params) {
        return blogMapper.findAll(params);
    }


    @Override
    public void createBlog(Map params) {
        blogMapper.createBlog(params);
    }

    @Override
    public int deleteBlogById(String id) {
        return blogMapper.deleteBlogById(id);
    }

    @Override
    public int updateBlogById(Map params) {
        return blogMapper.updateBlogById(params);
    }

    @Override
    public List<Blog> getBlogById(String id) {
         return blogMapper.getBlogById(id);
    }

}

package com.wzz.impl;

import com.wzz.entity.Blog;
import com.wzz.mapper.BlogMapper;
import com.wzz.service.BlogListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BlogListService")
public class BlogServiceimpl implements BlogListService {
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public List<Blog> findAll() {
        return blogMapper.findAll();
    }
}

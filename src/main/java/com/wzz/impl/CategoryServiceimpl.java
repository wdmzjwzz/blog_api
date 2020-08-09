package com.wzz.impl;

import com.wzz.entity.BlogDir;
import com.wzz.mapper.CategoryMapper;
import com.wzz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CategoryService")
public class CategoryServiceimpl implements CategoryService {
    @Autowired
    private CategoryMapper blogDirMapper;
    @Override
    public List<BlogDir> findAllDir() {
        return blogDirMapper.findAllDir();
    }

    @Override
    public void createBlogDir(Map params) {
        blogDirMapper.createBlogDir(params);
    }

    @Override
    public int deleteBlogDirById(String id) {
        return blogDirMapper.deleteBlogDirById(id);
    }

    @Override
    public int updateBlogDirById(Map params) {
        return blogDirMapper.updateBlogDirById(params);
    }

}

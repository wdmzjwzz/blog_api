package com.wzz.impl;

import com.wzz.entity.BlogDir;
import com.wzz.mapper.BlogDirMapper;
import com.wzz.service.BlogDirListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("BlogDirListService")
public class BlogDirListServiceimpl implements BlogDirListService {
    @Autowired
    private BlogDirMapper blogDirMapper;
    @Override
    public List<BlogDir> findAllDir() {
        return blogDirMapper.findAllDir();
    }

    @Override
    public void createBlogDir(Map params) {
        blogDirMapper.createBlogDir(params);
    }

    @Override
    public int deleteBlogDirById(Long id) {
        return blogDirMapper.deleteBlogDirById(id);
    }

    @Override
    public int updateBlogDirById(Map params) {
        return blogDirMapper.updateBlogDirById(params);
    }

}

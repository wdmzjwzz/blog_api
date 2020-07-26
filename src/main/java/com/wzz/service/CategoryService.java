package com.wzz.service;

import com.wzz.entity.BlogDir;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<BlogDir> findAllDir();

    void createBlogDir(Map params);
    int deleteBlogDirById(Long id);

    int updateBlogDirById(Map params);
}

package com.wzz.mapper;


import com.wzz.entity.BlogDir;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper//指定这是一个操作数据库的mapper
public interface CategoryMapper {
    List<BlogDir> findAllDir();

    void createBlogDir(Map params);
    int deleteBlogDirById(String id);
    int updateBlogDirById(Map params);
}

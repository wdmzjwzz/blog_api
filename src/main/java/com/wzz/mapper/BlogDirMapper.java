package com.wzz.mapper;


import com.wzz.entity.BlogDir;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper//指定这是一个操作数据库的mapper
public interface BlogDirMapper {
    List<BlogDir> findAllDir();

    void createBlogDir(Map params);
    int deleteBlogDirById(Long id);
    int updateBlogDirById(Map params);
}

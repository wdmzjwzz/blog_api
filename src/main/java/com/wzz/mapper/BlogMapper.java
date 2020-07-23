package com.wzz.mapper;


import com.wzz.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper//指定这是一个操作数据库的mapper
public interface BlogMapper {
    List<Blog> findAll();

    void createBlog(Map params);
}


package com.wzz.mapper;
import com.wzz.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.Map;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    //注册用户
    boolean addUser(User params);
    //查询用户
    User getUserByName(String name);
    void deleteUser(String name);
}

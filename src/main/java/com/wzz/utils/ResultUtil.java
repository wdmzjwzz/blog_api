package com.wzz.utils;

public class ResultUtil {
    public static ResponseResult success(Object object){
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(object);
        return result;
    }
}

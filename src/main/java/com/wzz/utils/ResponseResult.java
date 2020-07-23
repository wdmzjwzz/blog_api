package com.wzz.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

/**
 * 统一的公共响应体
 * @author NULL
 * @date 2020-07-19
 */
@Data
@AllArgsConstructor
public class ResponseResult implements Serializable {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    

    public static ResponseResult ok(Object data){
        return new ResponseResult(200,"success",data);
    }



    public static ResponseResult fail(String mes){
        return new ResponseResult(200,mes,null);
    }

}
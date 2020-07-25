package com.wzz.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Blog implements Serializable {
    private Long id;//编号
    private String title;//
    private String category;//
    private String content;//
    private Long create_time;
    private String user_name;

}



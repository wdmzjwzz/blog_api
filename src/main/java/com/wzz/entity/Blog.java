package com.wzz.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Blog implements Serializable {
    private String id;//编号
    private String title;//
    private String category;//
    private String content;//
    private Long create_time;
    private String user_name;
    private String overview;
    private  int is_deleted;
}



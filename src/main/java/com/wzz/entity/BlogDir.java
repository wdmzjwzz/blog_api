package com.wzz.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogDir implements Serializable {
    private String id;//编号
    private String name;//
    private  int is_deleted;
}

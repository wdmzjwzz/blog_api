package com.wzz.controls;

import com.wzz.entity.Blog;
import com.wzz.service.BlogListService;
import com.wzz.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/api")
@RestController
public class BlogListController {

    @Autowired
    private BlogListService blogListService;

    @RequestMapping(value = "/getBlogList",method = RequestMethod.GET)
    public ResponseResult findAll() {
        return ResponseResult.ok(blogListService.findAll());
    }

//    @GetMapping("/get_by_id")
//    public ResponseResult getData(Integer id){
//        if(id == null){
//            return ResponseResult.fail("id is null");
//        }
//        return ResponseResult.ok();
//    }

}
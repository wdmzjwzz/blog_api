package com.wzz.controls;

import com.wzz.entity.Blog;
import com.wzz.service.BlogListService;
import com.wzz.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RequestMapping("/api")
@RestController
//@ControllerAdvice
public class BlogListController {

    @ExceptionHandler(Exception.class) //表示让Spring捕获到所有抛出的SignException异常，并交由这个被注解的方法处理。
    @ResponseStatus(HttpStatus.BAD_REQUEST)
        //表示设置状态码。
    String handleException() {
        return "Exception Deal!";
    }

    @Autowired
    private BlogListService blogListService;

    @RequestMapping(value = "/getBlogList", method = RequestMethod.GET)
    public ResponseResult findAll() {
        return ResponseResult.ok(blogListService.findAll());
    }


    @RequestMapping(value = "/createBlog", method = RequestMethod.POST)
    public ResponseResult createBlog(@RequestBody Map params) {
        params.put("id", Math.random() * 1000 + new Date().getTime());
        System.out.print(params.toString());
        try {
            blogListService.createBlog(params);
        } catch (Exception e) {
            return ResponseResult.fail(e.toString());
        }

        return ResponseResult.ok(1);
    }
//    @GetMapping("/get_by_id")
//    public ResponseResult getData(Integer id){
//        if(id == null){
//            return ResponseResult.fail("id is null");
//        }
//        return ResponseResult.ok();
//    }

}
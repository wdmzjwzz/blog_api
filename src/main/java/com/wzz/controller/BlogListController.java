package com.wzz.controller;

import com.wzz.entity.Blog;
import com.wzz.service.BlogListService;
import com.wzz.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api")
@RestController
//@ControllerAdvice
@Api(value = "blogList")
public class BlogListController {

    @ExceptionHandler(Exception.class) //表示让Spring捕获到所有抛出的SignException异常，并交由这个被注解的方法处理。
    @ResponseStatus(HttpStatus.BAD_REQUEST)
        //表示设置状态码。
    String handleException() {
        return "Exception Deal!";
    }

    @Autowired
    private BlogListService blogListService;

    @ResponseBody
    @RequestMapping(value = "/getBlogList", method = RequestMethod.GET)
    @ApiOperation(value = "获取blogList", notes = "")

    public ResponseResult findAll(String category) {
        return ResponseResult.ok(blogListService.findAll(category));
    }


    @ResponseBody
    @RequestMapping(value = "/createBlog", method = RequestMethod.POST)
    @ApiOperation(value = "新增blog", notes = "")


    public ResponseResult createBlog(@RequestBody Map params) {
        params.put("id", new Date().getTime());
        params.put("create_time", new Date().getTime());
        params.put("user_name", "wangzz");

        if (params.get("title") == null || params.get("content") == null||"".equals(params.get("name").toString().trim())) {
            return ResponseResult.fail("缺少必要参数");
        }
        ;
        try {
            blogListService.createBlog(params);
        } catch (Exception e) {
            return ResponseResult.fail(e.toString());
        }

        return ResponseResult.ok(1);
    }


    @ResponseBody
    @ApiOperation(value = "根据id删除blog", notes = "")

    @DeleteMapping("/deleteBlogById/{id}")
    public ResponseResult deleteBlogById(@PathVariable("id") String id) {
        if (id == null) {
            return ResponseResult.fail("id is null");
        }
        try {
            int delete_number = blogListService.deleteBlogById(Long.parseLong(id));
            if (delete_number > 0) {
                return ResponseResult.ok("删除成功！");
            } else {
                return ResponseResult.fail("要删除的数据不存在！");
            }

        } catch (Exception e) {
            return ResponseResult.fail(e.toString());
        }

    }

    @ResponseBody
    @ApiOperation(value = "根据修改blog", notes = "")

    @PutMapping("/updateBlogById/{id}")
    public ResponseResult updateBlogById(@RequestBody Map params, @PathVariable("id") String id) {

        if (id == null) {
            return ResponseResult.fail("id is null");
        }

        if ("".equals(params.get("title").toString().trim())) {
            return ResponseResult.fail("title is null");
        }
        ;
        if (params.get("title") == null && params.get("content") == null) {
            return ResponseResult.fail("参数有误");
        }
        ;
        Map<String, Object> paramsObject = new HashMap<String, Object>();
        paramsObject.put("id", Long.parseLong(id));
        paramsObject.put("title", params.get("title").toString().trim());
        paramsObject.put("content", params.get("content"));
        try {
            int update_number = blogListService.updateBlogById(paramsObject);
            if (update_number > 0) {
                return ResponseResult.ok("修改成功！");
            } else {
                return ResponseResult.fail("要修改的id不存在！");
            }

        } catch (Exception e) {
            return ResponseResult.fail(e.toString());
        }

    }

    @ResponseBody
    @ApiOperation(value = "获取详情", notes = "")
    @GetMapping("/getBlogById/{id}")
    public ResponseResult getBlogById(@PathVariable("id") String id) {

        if (id == null) {
            return ResponseResult.fail("id is null");
        }
        try {
            List<Blog> blog = blogListService.getBlogById(id);
            if (blog.isEmpty()) {
                return ResponseResult.ok(new HashMap<>());
            } else {
                return ResponseResult.ok(blog.get(0));
            }


        } catch (Exception e) {
            return ResponseResult.fail(e.toString());
        }

    }
}
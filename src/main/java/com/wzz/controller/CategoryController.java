package com.wzz.controller;

import com.wzz.entity.Blog;
import com.wzz.service.BlogListService;
import com.wzz.service.CategoryService;
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


@RequestMapping("/api/dir")
@RestController
//@ControllerAdvice
@Api(value = "blogDirList")
public class CategoryController {

    @ExceptionHandler(Exception.class) //表示让Spring捕获到所有抛出的SignException异常，并交由这个被注解的方法处理。
    @ResponseStatus(HttpStatus.BAD_REQUEST)
        //表示设置状态码。
    String handleException() {
        return "Exception Deal!";
    }

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogListService blogListService;

    @ResponseBody
    @GetMapping("/list")
    @ApiOperation(value = "获取blogDirList", notes = "")

    public ResponseResult findAllDir() {
        return ResponseResult.ok(categoryService.findAllDir());
    }


    @ResponseBody
    @RequestMapping(value = "/createBlogDir", method = RequestMethod.POST)
    @ApiOperation(value = "新增blogDir", notes = "")


    public ResponseResult createBlogDir(@RequestBody Map params) {
        params.put("id", "Lab-" + new Date().getTime());
        params.put("name", params.get("name"));

        if (params.get("name") == null||"".equals(params.get("name").toString().trim())) {
            return ResponseResult.fail("name不能为空");
        }
        try {
            categoryService.createBlogDir(params);
        } catch (Exception e) {
            return ResponseResult.fail(e.toString());
        }

        return ResponseResult.ok(1);
    }


    @ResponseBody
    @ApiOperation(value = "根据id删除blog", notes = "")

    @DeleteMapping("/deleteBlogDirById/{id}")
    public ResponseResult deleteBlogDirById(@PathVariable("id") String id) {


        if (id == null) {
            return ResponseResult.fail("id is null");
        }
        Map<String, Object> paramsObject = new HashMap<String, Object>();
        paramsObject.put("category", id);
        paramsObject.put("start", 0);
        paramsObject.put("end",10);
        List<Blog> list =  blogListService.findAll(paramsObject);
        if (list.size()>0){
            return ResponseResult.fail("该分类不为空！不能删除！");
        }
        try {
            int delete_number = categoryService.deleteBlogDirById(id);
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

    @PutMapping("/updateBlogDirById/{id}")
    public ResponseResult updateBlogDirById(@RequestBody Map params, @PathVariable("id") String id) {

        if (id == null) {
            return ResponseResult.fail("id is null");
        }

        if ("".equals(params.get("name").toString().trim())) {
            return ResponseResult.fail("name is null");
        }

        Map<String, Object> paramsObject = new HashMap<String, Object>();
        paramsObject.put("id", id);
        paramsObject.put("name", params.get("name").toString().trim());
        try {
            int update_number = categoryService.updateBlogDirById(paramsObject);
            if (update_number > 0) {
                return ResponseResult.ok("修改成功！");
            } else {
                return ResponseResult.fail("要修改的id不存在！");
            }

        } catch (Exception e) {
            return ResponseResult.fail(e.toString());
        }

    }


}
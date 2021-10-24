package com.design.composite.web.action;

import com.design.composite.bean.ResponseResult;
import com.design.composite.entity.Classify;
import com.design.composite.service.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @desc 类别控制层
 * @author liuyajun
 */
@RestController
@RequestMapping(value = "/class")
public class ClassifyController {

    @Autowired
    private IClassifyService classifyService;
    /**
     * @Description: 获取分类列表
     */
    @RequestMapping("/list")
    public ResponseResult fiindList() {
        try {
            List<Classify> list = classifyService.findlist();
            return ResponseResult.success(list);
        } catch (Exception e) {
            return ResponseResult.fail("获取分类列表异常:"+e.getMessage());
        }
    }

    @RequestMapping("/add")
    public ResponseResult add(@RequestBody Classify classify) {
        try {
            classifyService.add(classify);
            return ResponseResult.success(null);
        } catch (Exception e) {
            return ResponseResult.fail("新增分类异常:"+e.getMessage());
        }
    }
}

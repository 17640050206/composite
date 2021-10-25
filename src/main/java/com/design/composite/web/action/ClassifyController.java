package com.design.composite.web.action;

import com.design.composite.bean.PageAbleCondition;
import com.design.composite.bean.ResponseResult;
import com.design.composite.entity.Classify;
import com.design.composite.repository.ClassifyRepository;
import com.design.composite.service.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyajun
 * @desc 类别控制层
 */
@RestController
@RequestMapping(value = "/class")
public class ClassifyController {

    @Autowired
    private IClassifyService classifyService;
    @Autowired
    private ClassifyRepository classifyRepository;

    /**
     * 获取分类列表(带分页)
     *
     * @param pageAbleCondition
     * @return
     */
    @RequestMapping("/findPage")
    public ResponseResult fiindList(@RequestBody PageAbleCondition pageAbleCondition) {
        try {
            Page<Classify> list = classifyService.findPage(pageAbleCondition);
            return ResponseResult.success(list);
        } catch (Exception e) {
            return ResponseResult.fail("获取分类列表异常:" + e.getMessage());
        }
    }

    /**
     * 新增/更新分类 (id空为新增，反之更新)
     *
     * @param classify
     * @return
     */
    @RequestMapping("/createOrUpdate")
    public ResponseResult add(@RequestBody Classify classify) {
        try {
            return classifyService.add(classify);
        } catch (Exception e) {
            return ResponseResult.fail("新增分类异常:" + e.getMessage());
        }
    }

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public ResponseResult add(@PathVariable(name = "id") Integer id) {
        try {
            return classifyService.delete(id);
        } catch (Exception e) {
            return ResponseResult.fail("删除分类异常:" + e.getMessage());
        }
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    public ResponseResult get(@PathVariable(name = "id") Integer id) {
        try {
            return ResponseResult.success(classifyRepository.getOne(id));
        } catch (Exception e) {
            return ResponseResult.fail("查询分类详情异常:" + e.getMessage());
        }
    }
}

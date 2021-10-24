package com.design.composite.web.action;

import com.design.composite.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 类别控制层
 * @author liuyajun
 */
@RestController
@RequestMapping(value = "/material")
public class MaterialController {

    @Autowired
    private IMaterialService materialService;
}

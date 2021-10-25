package com.design.composite.service;


import com.design.composite.bean.PageAbleCondition;
import com.design.composite.bean.ResponseResult;
import com.design.composite.entity.Material;
import org.springframework.data.domain.Page;

/**
 * @author liuyajun
 */
public interface IMaterialService {

    ResponseResult delete(Integer id);

    Page<Material> findPage(PageAbleCondition pageAbleCondition);

    ResponseResult add(Material material);
}


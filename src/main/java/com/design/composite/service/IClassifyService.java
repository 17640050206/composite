package com.design.composite.service;


import com.design.composite.bean.PageAbleCondition;
import com.design.composite.bean.ResponseResult;
import com.design.composite.entity.Classify;
import org.springframework.data.domain.Page;

/**
 * @author liuyajun
 */
public interface IClassifyService {

    Page<Classify> findPage(PageAbleCondition pageAbleCondition);

    ResponseResult add(Classify classify);

    ResponseResult delete(Integer id);
}


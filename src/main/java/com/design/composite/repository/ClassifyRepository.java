package com.design.composite.repository;

import com.design.composite.entity.Classify;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyajun
 */
public interface ClassifyRepository extends JpaRepository<Classify, Integer> {

    /**
     * 通过分类名称查询分类
     * @param classifyName
     * @return
     */
    Classify findByClassifyName(String classifyName);

}


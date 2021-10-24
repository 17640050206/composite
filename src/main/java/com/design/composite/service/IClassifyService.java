package com.design.composite.service;


import com.design.composite.entity.Classify;

import java.util.List;

/**
 * @author liuyajun
 */
public interface IClassifyService {

    List<Classify> findlist();

    void add(Classify classify);
}


package com.design.composite.service.impl;

import com.design.composite.entity.Classify;
import com.design.composite.repository.ClassifyRepository;
import com.design.composite.service.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyajun
 */
@Service
public class ClassifyServiceImpl implements IClassifyService {

	@Autowired
	private ClassifyRepository classifyRepository;

	@Override
	public List<Classify> findlist() {
		return classifyRepository.findAll();
	}

	@Override
	public void add(Classify classify) {
		classifyRepository.save(classify);
	}
}


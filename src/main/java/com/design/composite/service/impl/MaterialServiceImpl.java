package com.design.composite.service.impl;

import com.design.composite.repository.MaterialRepository;
import com.design.composite.service.IClassifyService;
import com.design.composite.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyajun
 */
@Service
public class MaterialServiceImpl implements IMaterialService {

	@Autowired
	private MaterialRepository materialRepository;

}


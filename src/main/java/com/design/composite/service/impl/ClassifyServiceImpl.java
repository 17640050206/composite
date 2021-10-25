package com.design.composite.service.impl;

import com.design.composite.bean.PageAbleCondition;
import com.design.composite.bean.ResponseResult;
import com.design.composite.entity.Classify;
import com.design.composite.entity.Material;
import com.design.composite.repository.ClassifyRepository;
import com.design.composite.repository.MaterialRepository;
import com.design.composite.service.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyajun
 */
@Service
public class ClassifyServiceImpl implements IClassifyService {

    @Autowired
    private ClassifyRepository classifyRepository;
    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public Page<Classify> findPage(PageAbleCondition pageAbleCondition) {
        int page = pageAbleCondition.getPage() == null ? 0 : pageAbleCondition.getPage();
        int size = pageAbleCondition.getSize() == null ? 10 : pageAbleCondition.getSize();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        return classifyRepository.findAll(pageable);
    }

    @Override
    public ResponseResult add(Classify classify) {
        Classify has = classifyRepository.findByClassifyName(classify.getClassifyName());
        if (has != null) {
            boolean flag = true;
            if (classify.getId() == null) {
                flag = false;
            } else {
                if (has.getId().intValue() != classify.getId().intValue()) {
                    flag = false;
                }
            }
            if (flag == false) {
                return ResponseResult.fail("分类已存在,不可重复创建！");
            }
        }
        classifyRepository.save(classify);
        return ResponseResult.success(null);
    }

    @Override
    public ResponseResult delete(Integer id) {
        List<Material> materialsUnderClassify = materialRepository.findByClassifyId(id);
        if (materialsUnderClassify != null && materialsUnderClassify.size() > 0) {
            return ResponseResult.fail("该分类下存在素材，不可删除！");
        }
        classifyRepository.deleteById(id);
        return ResponseResult.success(null);
    }
}


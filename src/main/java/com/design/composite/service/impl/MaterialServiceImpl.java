package com.design.composite.service.impl;

import com.design.composite.bean.PageAbleCondition;
import com.design.composite.bean.ResponseResult;
import com.design.composite.entity.Material;
import com.design.composite.repository.MaterialRepository;
import com.design.composite.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author liuyajun
 */
@Service
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public ResponseResult delete(Integer id) {
        materialRepository.deleteById(id);
        return ResponseResult.success(null);
    }

    @Override
    public Page<Material> findPage(PageAbleCondition pageAbleCondition) {
        int page = pageAbleCondition.getPage() == null ? 0 : pageAbleCondition.getPage();
        int size = pageAbleCondition.getSize() == null ? 10 : pageAbleCondition.getSize();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        return materialRepository.findAll(pageable);
    }

    @Override
    public ResponseResult add(Material material) {
        Material has = materialRepository.findByMaterialNameAndClassifyId(material.getMaterialName(), material.getClassifyId());
        if (has != null) {
            boolean flag = true;
            if (material.getId() == null) {
                flag = false;
            } else {
                if (has.getId().intValue() != material.getId().intValue()) {
                    flag = false;
                }
            }
            if (flag == false) {
                return ResponseResult.fail("该分类下已包含同名素材,不可重复创建！");
            }
        }
        materialRepository.save(material);
        return ResponseResult.success(null);
    }
}


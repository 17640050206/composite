package com.design.composite.repository;

import com.design.composite.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liuyajun
 */
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    /**
     * 通过素材名称和分类id查询素材
     *
     * @param materialName
     * @param classifyId
     * @return
     */
    Material findByMaterialNameAndClassifyId(String materialName, Integer classifyId);

    /**
     * 获取分类下的素材
     *
     * @param classifyId
     * @return
     */
    List<Material> findByClassifyId(Integer classifyId);

}


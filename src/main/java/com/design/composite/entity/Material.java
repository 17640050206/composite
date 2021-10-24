package com.design.composite.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 素材分类
 * @author liuyajun
 */
@Entity
@Data
@Table(name="t_material")
public class Material {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 素材名称
     */
    @Column(name = "material_name")
    private String materialName;

    /**
     * 素材所属类别id
     */
    @Column(name = "classify_id")
    private Integer classifyId;

    /**
     * 素材所属类别名称
     */
    @Column(name = "classify_name")
    private String classifyName;

    /**
     * 素材文件路径
     */
    @Column(name = "file_path")
    private String filePath;


}

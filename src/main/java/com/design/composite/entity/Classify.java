package com.design.composite.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 素材分类
 * @author liuyajun
 */
@Entity
@Data
@Table(name="t_classify")
public class Classify {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类别名称
     */
    @Column(name = "classify_name")
    private String classifyName;

}

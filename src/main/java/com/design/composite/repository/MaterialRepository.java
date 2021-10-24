package com.design.composite.repository;

import com.design.composite.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyajun
 */
public interface MaterialRepository extends JpaRepository<Material, Integer> {


//    @Query("select m from Menu m where m.id in ?1 order by m.id ")
//    List<Menu> findMenu(List<Integer> menuIds);

}


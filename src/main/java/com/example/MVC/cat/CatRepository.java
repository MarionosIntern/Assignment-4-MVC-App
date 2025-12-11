package com.example.MVC.Cat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long>{

    List<Cat> getCatsByBreed(String breed);

    @Query(value = "select * from cats c where c.cat_id = ?1", nativeQuery = true)
    Cat getCatById(Long catId);

    @Query(value = "select * from cats c where c.sex = ?1", nativeQuery = true)
    List<Cat> getCatsBySex(String sex);

    @Query(value = "select * from cats c where c.name = ?1", nativeQuery = true)
    List<Cat> getCatsByName(String name);
}
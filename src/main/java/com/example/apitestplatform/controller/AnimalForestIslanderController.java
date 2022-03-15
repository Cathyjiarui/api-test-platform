package com.example.apitestplatform.controller;

import com.example.apitestplatform.enums.DispositionEnum;
import com.example.apitestplatform.service.AnimalForestIslanderService;
import com.example.apitestplatform.utils.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AnimalForestIslanderController
 * @Description 小动物接口层
 * @Author ZhangJia
 * @Date 2021/1/26
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/pro/animal_forest_islander")
public class AnimalForestIslanderController {

    @Autowired
    private AnimalForestIslanderService animalForestIslanderService;

    @GetMapping("getAll")
    public JsonData getAll(@Param("current") int current, @Param("size") int size, @Param("disposition") String disposition) {
        return JsonData.buildSuccess(animalForestIslanderService.listAll(current, size, DispositionEnum.getDisposition(disposition)));
    }

    @GetMapping("get_animal_by_id")
    public JsonData getAnimalById(@Param("id") int id) {
        return JsonData.buildSuccess(animalForestIslanderService.getAnimalById(id));
    }

    @GetMapping("get_animal_by_disposition_index")
    public JsonData getAnimalByDisposition(@Param("dispositionId") String disposition) {
        return JsonData.buildSuccess(animalForestIslanderService.getAnimalByDisposition(DispositionEnum.getDisposition(disposition)));
    }
}

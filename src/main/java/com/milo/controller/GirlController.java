package com.milo.controller;

import com.milo.domain.Girl;
import com.milo.repository.GirlRepository;
import com.milo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by milo on 02/06/2017.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    //添加
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age,
                        @RequestParam(value = "height", defaultValue = "170", required = false) Double height,
                        @RequestParam(value = "weight", defaultValue = "120",required = false) Double weight
                        ){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setWeight(weight);
        girl.setCupSize(cupSize);
        girl.setHeight(height);

        return girlRepository.save(girl);

    }

    //查询
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("height")  Double height,
                           @RequestParam("weight")  Double weight
                           ){
        Girl girl = new Girl();

        girl.setId(id);
        girl.setHeight(height);
        girl.setWeight(weight);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);

    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
         girlRepository.delete(id);
    }

    //通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);

    }

    //添加两个
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

}

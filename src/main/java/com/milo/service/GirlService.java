package com.milo.service;

import com.milo.domain.Girl;
import com.milo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by milo on 02/06/2017.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA  = new Girl();
        girlA.setAge(20);
        girlA.setCupSize("B");
        girlA.setHeight(165.0);
        girlA.setWeight(100.0);
        girlRepository.save(girlA);


        Girl girlB  = new Girl();
        girlB.setAge(21);
        girlB.setCupSize("C");
        girlB.setHeight(168.0);
        girlB.setWeight(110.0);
        girlRepository.save(girlB);


    }
}

package com.milo.repository;

import com.milo.domain.Girl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * Created by milo on 12/06/2017.
 */
@Repository
public interface GirlCRUDRepository extends CrudRepository<Girl, Integer> {

    public Girl findAllById(Integer id);

    public  void deleteById(Integer id);

    public long countByAge(Integer age);

}

package com.mvc.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.lenguajes.models.Leng;

@Repository
public interface LengRepository extends CrudRepository<Leng, Long>{
	
	List<Leng> findAll();
}

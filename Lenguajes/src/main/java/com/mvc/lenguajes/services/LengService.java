package com.mvc.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.lenguajes.models.Leng;
import com.mvc.lenguajes.repositories.LengRepository;

@Service
public class LengService {

	@Autowired
	private LengRepository lengRepository;
	
	public List<Leng> allLengs(){
		return lengRepository.findAll();	
	}
	
	public Leng createLeng(Leng l) {
		return lengRepository.save(l);
	}
	
	public Leng findLeng(Long id) {	
		Optional<Leng> optionalLeng = lengRepository.findById(id);
	    if(optionalLeng.isPresent()) {
	    	return optionalLeng.get();
	    }else {
	        return null;
	    }
	 }
	
    public Leng update(Leng l) {
    	Leng temp = findLeng(l.getId());
    	temp.setName(l.getName());
    	temp.setCreator(l.getCreator());
    	temp.setCurrentVersion(l.getCurrentVersion());
    	return lengRepository.save(temp);
    }
    
    public void delete(long id) {
    	lengRepository.deleteById(id);
    }
}
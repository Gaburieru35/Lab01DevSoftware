package com.lab01.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab01.demo.entities.DisciplinasOfertadas;
import com.lab01.demo.repository.DisciplinasOfertadasRepository;

@Service
public class DisciplinasOfertadasService {
    
    @Autowired
    private DisciplinasOfertadasRepository repository;

    public List<DisciplinasOfertadas> findAll() {
		return repository.findAll();
	}
	
	public DisciplinasOfertadas findById(Long id) {
		Optional<DisciplinasOfertadas> obj =  repository.findById(id);
		return obj.get();
	}
	
	public DisciplinasOfertadas insert(DisciplinasOfertadas obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}


}

package com.lab01.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab01.demo.entities.Disciplina;
import com.lab01.demo.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository repository;
	
	public List<Disciplina> findAll() {
		return repository.findAll();
	}
	
	public Disciplina findById(Long id) {
		Optional<Disciplina> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Disciplina insert(Disciplina obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
package com.lab01.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lab01.demo.entities.DisciplinasOfertadas;
import com.lab01.demo.service.DisciplinasOfertadasService;

@RestController
@RequestMapping(value = "/disciplinasofertadas")
public class DisciplinasOfertadasResource {
    
    @Autowired
    private DisciplinasOfertadasService service;

    @GetMapping
	public ResponseEntity<List<DisciplinasOfertadas>> findAll() {
		List<DisciplinasOfertadas> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DisciplinasOfertadas> findById(@PathVariable Long id) {
		DisciplinasOfertadas obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);
	} 
	
	@PostMapping
	public ResponseEntity<DisciplinasOfertadas> insert(@RequestBody DisciplinasOfertadas obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

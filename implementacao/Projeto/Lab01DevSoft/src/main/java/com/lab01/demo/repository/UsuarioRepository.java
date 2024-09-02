package com.lab01.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab01.demo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
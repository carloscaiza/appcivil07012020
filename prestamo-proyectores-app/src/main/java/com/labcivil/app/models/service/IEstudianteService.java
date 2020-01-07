package com.labcivil.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.labcivil.app.models.entity.Estudiante;

public interface IEstudianteService {
	
	public List<Estudiante> findAll();
	
	public List<Estudiante> findAllOrder();
	
	public Page<Estudiante> findAll(Pageable pageable);
	
	public void save(Estudiante estudiante);
	
	public Estudiante findOne(Long id);
	
	public void delete(Long id);

}

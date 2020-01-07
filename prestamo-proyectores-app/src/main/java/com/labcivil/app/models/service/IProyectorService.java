package com.labcivil.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.labcivil.app.models.entity.Proyector;

public interface IProyectorService {
	
	public List<Proyector> findAll();
	
	public List<Proyector> findAllOrder();
	
	public Page<Proyector> findAll(Pageable pageable);
	
	public void save(Proyector proyector);
	
	public Proyector findOne(Long id);
	
	public void delete(Long id);

}

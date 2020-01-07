package com.labcivil.app.models.service;

import java.util.List;

import com.labcivil.app.models.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> findAll();
	
	public void save(Persona persona);
	
	public void send(String fromAddress, String toAddress, String subject, String content) throws Exception;
	
	public Persona findOne(Long id);
	
	public void delete(Long id);

}

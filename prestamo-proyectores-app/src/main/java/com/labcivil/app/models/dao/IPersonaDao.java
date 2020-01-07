package com.labcivil.app.models.dao;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.labcivil.app.models.entity.Persona;

@Repository
public interface IPersonaDao extends CrudRepository<Persona, Long> {
	

}

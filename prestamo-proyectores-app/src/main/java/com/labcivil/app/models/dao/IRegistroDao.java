package com.labcivil.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.labcivil.app.models.entity.Registro;

@Repository
public interface IRegistroDao extends JpaRepository<Registro, Long>{
	
//	@Query("select r.id, r.observacion from Registro r where r.observacion like %?1%")
	@Query("select r from Registro r where r.descripcion like %?1%")	
	public List<Registro> findByObservacion(String term);

}

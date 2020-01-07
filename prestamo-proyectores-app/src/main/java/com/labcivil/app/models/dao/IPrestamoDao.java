package com.labcivil.app.models.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.labcivil.app.models.entity.Prestamo;

@Repository
public interface IPrestamoDao extends JpaRepository<Prestamo, Long>{
		
	public List<Prestamo> findByOrderByIdAsc();
	
//	@Query("select p from Prestamo p where p.estado='Activo'")
//	public List<Prestamo> findByEstado();
	
	public List<Prestamo> findByEstadoOrderByIdAsc(String estado);

	public List<Prestamo> findByCreatePrBetweenOrderByIdAsc(Date fecha1, Date fecha2);
	
	public List<Prestamo> findByCreatePrAndHoraInBetweenOrderByIdAsc(Date fecha,Date timeStart, Date timeEnd);
	
}

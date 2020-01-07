package com.labcivil.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labcivil.app.models.dao.IProyectorDao;
import com.labcivil.app.models.entity.Proyector;

@Service
public class ProyectorServiceImpl implements IProyectorService {
	
	@Autowired
	private IProyectorDao proyectorDao;

	@Override
	@Transactional(readOnly=true)
	public List<Proyector> findAll() {		
		return proyectorDao.findAll();
	}

	@Override
	@Transactional
	public void save(Proyector proyector) {	
		proyectorDao.save(proyector);
	}

	@Override
	@Transactional(readOnly=true)
	public Proyector findOne(Long id) {		
		return proyectorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		proyectorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Proyector> findAll(Pageable pageable) {		
		return proyectorDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Proyector> findAllOrder() {
		return proyectorDao.findByOrderByIdAsc();
	}

}

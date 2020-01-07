package com.labcivil.app.models.service;

import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labcivil.app.models.dao.IPersonaDao;
import com.labcivil.app.models.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	//@Transactional
	public void send(String fromAddress, String toAddress, String subject, String content) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom(fromAddress);
		mimeMessageHelper.setTo(toAddress);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(content, true);
		mimeMessageHelper.setSentDate(new Date());
		
		javaMailSender.send(mimeMessage);
	}

	@Override
	@Transactional(readOnly=true)
	public Persona findOne(Long id) {
		
		return personaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personaDao.deleteById(id);;
	}
	
	

}

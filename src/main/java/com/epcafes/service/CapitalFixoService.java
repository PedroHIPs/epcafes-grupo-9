package com.epcafes.service;

import java.util.List;

import com.epcafes.entity.CapitalFixo;

public interface CapitalFixoService{
	
	CapitalFixo findById(Long id);
	
	List<CapitalFixo> findAll();
	
	CapitalFixo register(CapitalFixo CapitalFixo);
	
	CapitalFixo update(CapitalFixo capitalFixo, Long id);
	
	String delete(Long id);
}

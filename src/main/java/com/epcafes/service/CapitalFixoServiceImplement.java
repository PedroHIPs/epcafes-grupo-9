package com.epcafes.service;

import java.util.*;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.epcafes.entity.CapitalFixo;
import com.epcafes.repository.CapitalFixoRepository;
import com.epcafes.util.CapitalFixoMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class CapitalFixoServiceImplement implements CapitalFixoService{

	private final CapitalFixoRepository capitalfixoRepository;
	
	private final CapitalFixoMapper capitalfixoMapper;
	
	public CapitalFixo findById(Long id) {
		return returnCapitalFixo(id);
	}
	
	public List<CapitalFixo> findAll(){
		return capitalfixoRepository.findAll();
	}
	
	public CapitalFixo register(CapitalFixo CapitalFixo) {
		CapitalFixo capitalfixo = CapitalFixo;
		return capitalfixoRepository.save(capitalfixo);
	}
	
	public CapitalFixo update(CapitalFixo capitalFixo, Long id) {
		CapitalFixo capitalfixo = returnCapitalFixo(id);
		capitalfixoMapper.updateCapitalFixoData(capitalfixo, capitalFixo);
		return capitalfixoRepository.save(capitalfixo);
	}
	
	public String delete(Long id) {
		capitalfixoRepository.deleteById(id);
		return "Capital Fixo de id: " + id + " foi deletado.";
	}
	
	private CapitalFixo returnCapitalFixo(Long id) {
		return capitalfixoRepository.findById(id).orElseThrow(()-> new RuntimeException("Renda de Fator de Capital Fixo não foi encontrada no banco de dados."));
	}

}

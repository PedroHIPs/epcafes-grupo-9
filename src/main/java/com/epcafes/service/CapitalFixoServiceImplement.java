package com.epcafes.service;

import java.util.*;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.epcafes.dto.request.CapitalFixoRequestDTO;
import com.epcafes.dto.response.CapitalFixoResponseDTO;
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
	
	public CapitalFixoResponseDTO findById(Long id) {
		return capitalfixoMapper.toCapitalFixoDTO(returnCapitalFixo(id));
	}
	
	public List<CapitalFixoResponseDTO> findAll(){
		return capitalfixoMapper.toCapitalFixoDTO(capitalfixoRepository.findAll());
	}
	
	public CapitalFixoResponseDTO register(CapitalFixoRequestDTO CapitalFixoDTO) {
		CapitalFixo capitalfixo = capitalfixoMapper.toCapitalFixo(CapitalFixoDTO);
		return capitalfixoMapper.toCapitalFixoDTO(capitalfixoRepository.save(capitalfixo));
	}
	
	public CapitalFixoResponseDTO update(CapitalFixoRequestDTO capitalFixoDTO, Long id) {
		CapitalFixo capitalfixo = returnCapitalFixo(id);
		capitalfixoMapper.updateCapitalFixoData(capitalfixo, capitalFixoDTO);
		return capitalfixoMapper.toCapitalFixoDTO(capitalfixoRepository.save(capitalfixo));
	}
	
	public String delete(Long id) {
		capitalfixoRepository.deleteById(id);
		return "Capital Fixo de id: " + id + " foi deletado.";
	}
	
	private CapitalFixo returnCapitalFixo(Long id) {
		return capitalfixoRepository.findById(id).orElseThrow(()-> new RuntimeException("Renda de Fator de Capital Fixo não foi encontrada no banco de dados."));
	}

}

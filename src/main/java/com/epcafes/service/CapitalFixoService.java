package com.epcafes.service;

import java.util.List;

import com.epcafes.dto.request.CapitalFixoRequestDTO;
import com.epcafes.dto.response.CapitalFixoResponseDTO;

public interface CapitalFixoService{
	
	CapitalFixoResponseDTO findById(Long id);
	
	List<CapitalFixoResponseDTO> findAll();
	
	CapitalFixoResponseDTO register(CapitalFixoRequestDTO CapitalFixoDTO);
	
	CapitalFixoResponseDTO update(CapitalFixoRequestDTO capitalFixoDTO, Long id);
	
	String delete(Long id);
}

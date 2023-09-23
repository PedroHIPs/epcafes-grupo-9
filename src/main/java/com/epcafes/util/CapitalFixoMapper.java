package com.epcafes.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epcafes.dto.request.CapitalFixoRequestDTO;
import com.epcafes.dto.response.CapitalFixoResponseDTO;
import com.epcafes.entity.CapitalFixo;

@Component
public class CapitalFixoMapper {
	
	public CapitalFixo toCapitalFixo(CapitalFixoRequestDTO capitalFixoDTO) {
		return CapitalFixo.builder()
				.valorBemNovo(capitalFixoDTO.getValorBemNovo())
				.taxaDePoupanca(capitalFixoDTO.getTaxaDePoupanca())
				.vidaHoras(capitalFixoDTO.getVidaHoras())
				.vidaAnos(capitalFixoDTO.getVidaAnos())
				.horasTrabalhadas(capitalFixoDTO.getHorasTrabalhadas())
				.build();
	}
	
	
	public CapitalFixoResponseDTO toCapitalFixoDTO(CapitalFixo capitalfixo) {
		return new CapitalFixoResponseDTO(capitalfixo);
	}
	
	public List<CapitalFixoResponseDTO> toCapitalFixoDTO(List<CapitalFixo> capitalfixoList){
		return capitalfixoList.stream().map(CapitalFixoResponseDTO::new).collect(Collectors.toList());
	}
	
	public void updateCapitalFixoData(CapitalFixo capitalfixo, CapitalFixoRequestDTO capitalfixorequestDTO) {
		capitalfixo.setValorBemNovo(capitalfixorequestDTO.getValorBemNovo());
		capitalfixo.setTaxaDePoupanca(capitalfixorequestDTO.getTaxaDePoupanca());
		capitalfixo.setVidaHoras(capitalfixorequestDTO.getVidaHoras());
		capitalfixo.setVidaAnos(capitalfixorequestDTO.getVidaAnos());
		capitalfixo.setHorasTrabalhadas(capitalfixorequestDTO.getHorasTrabalhadas());
	}
}

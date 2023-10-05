package com.epcafes.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epcafes.entity.CapitalFixo;

@Component
public class CapitalFixoMapper {
	

	
	public void updateCapitalFixoData(CapitalFixo capitalfixo, CapitalFixo capitalfixorequest) {
		capitalfixo.setValorBemNovo(capitalfixorequest.getValorBemNovo());
		capitalfixo.setTaxaDePoupanca(capitalfixorequest.getTaxaDePoupanca());
		capitalfixo.setVidaHoras(capitalfixorequest.getVidaHoras());
		capitalfixo.setVidaAnos(capitalfixorequest.getVidaAnos());
		capitalfixo.setHorasTrabalhadas(capitalfixorequest.getHorasTrabalhadas());
	}
}

package com.epcafes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.epcafes.dto.request.CapitalFixoRequestDTO;
import com.epcafes.dto.response.CapitalFixoResponseDTO;
import com.epcafes.service.CapitalFixoService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value = "/capitalfixo")
@RequiredArgsConstructor
public class CapitalFixoController {
	
	private final CapitalFixoService capitalfixoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CapitalFixoResponseDTO> findById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(capitalfixoService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CapitalFixoResponseDTO>> findAll(){
		return ResponseEntity.ok().body(capitalfixoService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<CapitalFixoResponseDTO> register(@RequestBody CapitalFixoRequestDTO capitalfixoDTO, UriComponentsBuilder uriBuilder){
		CapitalFixoResponseDTO capitalfixoResponseDTO = capitalfixoService.register(capitalfixoDTO);
		URI uri = uriBuilder.path("/capitalfixo/{id}").buildAndExpand(capitalfixoResponseDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(capitalfixoResponseDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CapitalFixoResponseDTO> update(@RequestBody CapitalFixoRequestDTO capitalfixoDTO, @PathVariable(name = "id") Long id){
		return ResponseEntity.ok().body(capitalfixoService.update(capitalfixoDTO, id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok().body(capitalfixoService.delete(id));
	}
}

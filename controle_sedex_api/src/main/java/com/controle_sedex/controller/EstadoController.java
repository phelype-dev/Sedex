package com.controle_sedex.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle_sedex.exception.ResourceNotFoundException;
import com.controle_sedex.model.Estado;
import com.controle_sedex.repository.EstadoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Estado>> get() {
		return ResponseEntity.ok(estadoRepository.findAll());
	}
	
	@PostMapping
	public Estado addEstado(@Validated @RequestBody Estado estado) {
		return estadoRepository.save(estado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> getEstadoById(@PathVariable(value = "id") Long idEstado)
		throws ResourceNotFoundException{
		Estado estado = estadoRepository.findById(idEstado)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idEstado));
		return ResponseEntity.ok().body(estado);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Estado> updateEstado(@PathVariable(value = "id") Long idEstado,
			@Validated @RequestBody Estado estadoDetalhe) throws ResourceNotFoundException{
		Estado estado = estadoRepository.findById(idEstado)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idEstado));
		
		estado.setEst_codigo(estadoDetalhe.getEst_codigo());
		estado.setEstado(estadoDetalhe.getEstado());
		estado.setSigla_estado(estadoDetalhe.getSigla_estado());
		
		final Estado estadoT = estadoRepository.save(estado);
		return ResponseEntity.ok(estadoT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idEstado)
		throws ResourceNotFoundException{
		Estado Estado = estadoRepository.findById(idEstado)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Estado para esse :: " +idEstado));
		estadoRepository.delete(Estado);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}

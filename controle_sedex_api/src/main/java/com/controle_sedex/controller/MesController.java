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
import com.controle_sedex.model.Mes;
import com.controle_sedex.repository.MesRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mes")
public class MesController {
	
	@Autowired
	private MesRepository mesRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Mes>> get() {
		return ResponseEntity.ok(mesRepository.findAll());
	}
	
	@PostMapping
	public Mes addMes(@Validated @RequestBody Mes Mes) {
		return mesRepository.save(Mes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mes> getMesById(@PathVariable(value = "id") Long idMes)
		throws ResourceNotFoundException{
		Mes Mes = mesRepository.findById(idMes)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idMes));
		return ResponseEntity.ok().body(Mes);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Mes> updateMes(@PathVariable(value = "id") Long idMes,
			@Validated @RequestBody Mes MesDetalhe) throws ResourceNotFoundException{
		Mes Mes = mesRepository.findById(idMes)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idMes));
		
			Mes.setMes_codigo(MesDetalhe.getMes_codigo());
			Mes.setMes_sistema(MesDetalhe.getMes_sistema());
			Mes.setMes_texto(MesDetalhe.getMes_texto());
		
		final Mes MesT = mesRepository.save(Mes);
		return ResponseEntity.ok(MesT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idMes)
		throws ResourceNotFoundException{
		Mes Mes = mesRepository.findById(idMes)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Mes para esse :: " +idMes));
		mesRepository.delete(Mes);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}

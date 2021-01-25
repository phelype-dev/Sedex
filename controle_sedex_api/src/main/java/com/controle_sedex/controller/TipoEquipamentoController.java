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
import com.controle_sedex.model.Tipo_Equipamento;
import com.controle_sedex.repository.TipoEquipamentoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipoequipamento")
public class TipoEquipamentoController {
	
	@Autowired
	private TipoEquipamentoRepository tpEquipamentoRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Tipo_Equipamento>> get() {
		return ResponseEntity.ok(tpEquipamentoRepository.findAll());
	}
	
	@PostMapping
	public Tipo_Equipamento addTipoEquipamento(@Validated @RequestBody Tipo_Equipamento tipoEquipamento) {
		return tpEquipamentoRepository.save(tipoEquipamento);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tipo_Equipamento> getTipoEquipamentoById(@PathVariable(value = "id") Long idTipoEquipamento)
		throws ResourceNotFoundException{
		Tipo_Equipamento tipoEquipamento = tpEquipamentoRepository.findById(idTipoEquipamento)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idTipoEquipamento));
		return ResponseEntity.ok().body(tipoEquipamento);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tipo_Equipamento> updateTipoEquipamento(@PathVariable(value = "id") Long idTipoEquipamento,
			@Validated @RequestBody Tipo_Equipamento tipoEquipamentoDetalhe) throws ResourceNotFoundException{
		Tipo_Equipamento tipoEquipamento = tpEquipamentoRepository.findById(idTipoEquipamento)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idTipoEquipamento));
		
		tipoEquipamento.setEqu_codigo(tipoEquipamentoDetalhe.getEqu_codigo());
		tipoEquipamento.setEqu_tipo(tipoEquipamentoDetalhe.getEqu_tipo());
		
		final Tipo_Equipamento tipoEquipamentoT = tpEquipamentoRepository.save(tipoEquipamento);
		return ResponseEntity.ok(tipoEquipamentoT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarTipo_Equipamento(@PathVariable(value = "id") Long idTipoEquipamento)
		throws ResourceNotFoundException{
		Tipo_Equipamento Tipo_Equipamento = tpEquipamentoRepository.findById(idTipoEquipamento)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Equipamento para esse :: " +idTipoEquipamento));
		tpEquipamentoRepository.delete(Tipo_Equipamento);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}

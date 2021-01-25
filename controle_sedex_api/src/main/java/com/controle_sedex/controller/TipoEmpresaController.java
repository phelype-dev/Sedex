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
import com.controle_sedex.model.Tipo_Empresa;
import com.controle_sedex.repository.TipoEmpresaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipoempresa")
public class TipoEmpresaController {
	
	@Autowired
	private TipoEmpresaRepository tpEmpresaRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Tipo_Empresa>> get() {
		return ResponseEntity.ok(tpEmpresaRepository.findAll());
	}
	
	@PostMapping
	public Tipo_Empresa addRemetente(@Validated @RequestBody Tipo_Empresa tpEmpresa) {
		return tpEmpresaRepository.save(tpEmpresa);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tipo_Empresa> getTipoEmpresaById(@PathVariable(value = "id") Long idTipoEmpresa)
		throws ResourceNotFoundException{
		Tipo_Empresa tipoEmpresa = tpEmpresaRepository.findById(idTipoEmpresa)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idTipoEmpresa));
		return ResponseEntity.ok().body(tipoEmpresa);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tipo_Empresa> updateTipoEmpresa(@PathVariable(value = "id") Long idTipoEmpresa,
			@Validated @RequestBody Tipo_Empresa tipoEmpresaDetalhe) throws ResourceNotFoundException{
		Tipo_Empresa tipoEmpresa = tpEmpresaRepository.findById(idTipoEmpresa)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idTipoEmpresa));
		
		tipoEmpresa.setTem_codigo(tipoEmpresa.getTem_codigo());
		tipoEmpresa.setTem_tipo_empresa(tipoEmpresaDetalhe.getTem_tipo_empresa());
		
		final Tipo_Empresa tipoEmpresaT = tpEmpresaRepository.save(tipoEmpresa);
		return ResponseEntity.ok(tipoEmpresaT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarTipo_Empresa(@PathVariable(value = "id") Long idTipoEmpresa)
		throws ResourceNotFoundException{
		Tipo_Empresa tipo_empresa = tpEmpresaRepository.findById(idTipoEmpresa)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Remetente para esse :: " +idTipoEmpresa));
		tpEmpresaRepository.delete(tipo_empresa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}

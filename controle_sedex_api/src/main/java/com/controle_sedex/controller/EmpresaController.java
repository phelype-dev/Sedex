package com.controle_sedex.controller;

import java.util.HashMap;
import java.util.List;
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
import com.controle_sedex.model.Empresa;
import com.controle_sedex.repository.EmpresaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Empresa>> get() {
		return ResponseEntity.ok(empRepository.findAll());
	}
	
	@PostMapping
	public Empresa addEmpresa(@Validated @RequestBody Empresa empresa) {
		return empRepository.save(empresa);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> getEmpresaById(@PathVariable(value = "id") Long idEmpresa)
		throws ResourceNotFoundException{
		Empresa empresa = empRepository.findById(idEmpresa)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idEmpresa));
		return ResponseEntity.ok().body(empresa);
	}
	
	@GetMapping("/transportadora")
	public List<Empresa> findAllByTransp(){
		return empRepository.findEmpresaByTransp();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Empresa> updateEmpresa(@PathVariable(value = "id") Long idEmpresa,
			@Validated @RequestBody Empresa empDetalhe) throws ResourceNotFoundException{
		Empresa empresa = empRepository.findById(idEmpresa)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel realizar o update ::"+idEmpresa));
		
		empresa.setEmp_codigo(empDetalhe.getEmp_codigo());
		empresa.setEmp_cnpj(empDetalhe.getEmp_cnpj());
		empresa.setEmp_razao_social(empDetalhe.getEmp_razao_social());
		empresa.setEmp_operacoa(empDetalhe.getEmp_operacoa());
		empresa.setEmp_descricao(empDetalhe.getEmp_descricao());
		empresa.setEmp_descricao(empDetalhe.getEmp_descricao());
		empresa.setEmp_logradouro(empDetalhe.getEmp_logradouro());
		empresa.setEmp_numero(empDetalhe.getEmp_numero());
		empresa.setEmp_complemento(empDetalhe.getEmp_complemento());
		empresa.setEmp_bairro(empDetalhe.getEmp_bairro());
		empresa.setEmp_cidade(empDetalhe.getEmp_cidade());
		empresa.setEmp_estado(empDetalhe.getEmp_estado());
		empresa.setEmp_cep(empDetalhe.getEmp_cep());
		empresa.setEmp_fixo(empDetalhe.getEmp_fixo());
		empresa.setTem_codigo(empDetalhe.getTem_codigo());
		
		final Empresa empresaT = empRepository.save(empresa);
		return ResponseEntity.ok(empresaT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarEmpresa(@PathVariable(value = "id") Long idEmpresa)
		throws ResourceNotFoundException{
		Empresa empresa = empRepository.findById(idEmpresa)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Empresa para esse :: " +idEmpresa));
		empRepository.delete(empresa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
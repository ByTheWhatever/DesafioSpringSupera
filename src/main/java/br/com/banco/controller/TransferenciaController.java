package br.com.banco.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
public class TransferenciaController {

	private final TransferenciaService transferenciaService;

	public TransferenciaController(TransferenciaService transferenciaService) {
		this.transferenciaService = transferenciaService;
	}

	// Método que retorna todas as transferências
	
	@GetMapping("/transferencias")
	public List<Transferencia> getAllTransferencias() {
		return transferenciaService.findAll();
	}

	// Método que retorna transferências por período
	
	@GetMapping("/transferencias/periodo")
	public List<Transferencia> getTransferenciasByPeriodo(@RequestParam("inicio") LocalDateTime inicio,
			@RequestParam("fim") LocalDateTime fim) {
		return transferenciaService.findByPeriodo(inicio, fim);
	}

	// Método que retorna transferência por operador
	
	@GetMapping("/transferencias/operador")
	public List<Transferencia> getTransferenciasByOperador(@RequestParam("operador") String operador) {
		return transferenciaService.findByOperador(operador);
	}

	// Método que retorna transferência por período e operador
	
	@GetMapping("/transferencias/periodo-operador")
	public List<Transferencia> getTransferenciasByPeriodoOperador(@RequestParam("inicio") LocalDateTime inicio,
			@RequestParam("fim") LocalDateTime fim, @RequestParam("operador") String operador) {
		return transferenciaService.getTransferenciasByPeriodoOperador(inicio, fim, operador);
	}

	// Método para consulta com todos os métodos com Page para paginação
	
	@GetMapping("/transferencias/filtro")
	public ResponseEntity<Page<Transferencia>> getByFilter(@RequestParam(name = "idConta", required = false) Long idConta, 
			@RequestParam(name = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate, 
			@RequestParam(name = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate, 
			@RequestParam(name = "operador", required = false)String nomeOperador){
		return ResponseEntity.ok(transferenciaService.findByFilter(idConta, startDate, endDate, nomeOperador));
		
	}
}

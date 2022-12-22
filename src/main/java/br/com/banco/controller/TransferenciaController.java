package br.com.banco.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
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
	public List<Transferencia> getTransferenciasByPeriodo(@RequestParam("startDate") LocalDateTime startDate,
			@RequestParam("endDate") LocalDateTime endDate) {
		return transferenciaService.findByPeriodo(startDate, endDate);
	}

	// Método que retorna transferência por operador

	@GetMapping("/transferencias/operador")
	public List<Transferencia> getTransferenciasByOperador(@RequestParam("nomeOperador") String nomeOperador) {
		return transferenciaService.findByOperador(nomeOperador);
	}

	// Método que retorna transferência por período e operador

	@GetMapping("/transferencias/periodo-operador")
	public List<Transferencia> getTransferenciasByPeriodoOperador(@RequestParam("startDate") LocalDateTime startDate,
			@RequestParam("endDate") LocalDateTime endDate, @RequestParam("nomeOperador") String nomeOperador) {
		return transferenciaService.getTransferenciasByPeriodoOperador(startDate, endDate, nomeOperador);
	}

	// Método para consulta com todos os métodos com Page para paginação

	@GetMapping("/transferencias/filtro")
	public ResponseEntity<Page<Transferencia>> getByFilter(
			@RequestParam(name = "idConta", required = false) Long idConta,
			@RequestParam(name = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
			@RequestParam(name = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
			@RequestParam(name = "operador", required = false) String nomeOperador) {
		return ResponseEntity.ok(transferenciaService.findByFilter(idConta, startDate, endDate, nomeOperador));

	}
}

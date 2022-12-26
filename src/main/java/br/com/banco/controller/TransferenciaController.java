package br.com.banco.controller;

import java.time.LocalDate;

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
@CrossOrigin(origins = "*") // Optei por deixar como acesso de qualquer porta ao invés de deixar apenas 3000
							// por motivo de não saber em qual porta o usuário rodará o front
public class TransferenciaController {

	private final TransferenciaService transferenciaService;

	public TransferenciaController(TransferenciaService transferenciaService) {
		this.transferenciaService = transferenciaService;
	}

	@GetMapping("/transferencias/filtro")
	public ResponseEntity<Page<Transferencia>> getByFilter(
			@RequestParam(name = "idConta", required = false) Long idConta,
			@RequestParam(name = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(name = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam(name = "operador", required = false) String nomeOperador,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer pagina,
			@RequestParam(name = "pageSize", required = false, defaultValue = "4") Integer paginaTamanho) {
		return ResponseEntity.ok(
				transferenciaService.findByFilter(idConta, startDate, endDate, nomeOperador, pagina, paginaTamanho));
	}

}

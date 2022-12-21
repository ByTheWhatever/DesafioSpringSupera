package br.com.banco.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Service
public class TransferenciaService {

	private TransferenciaRepository transferenciaRepository;

	@Autowired
	public TransferenciaService(TransferenciaRepository transferenciaRepository) {
		this.transferenciaRepository = transferenciaRepository;
	}

	public List<Transferencia> findAll() {
		return transferenciaRepository.findAll();
	}

	public List<Transferencia> findByPeriodo(LocalDateTime startDate, LocalDateTime endDate) {
		return transferenciaRepository.findByPeriodo(startDate, endDate);
	}

	public List<Transferencia> findByOperador(String nomeOperador) {
		return transferenciaRepository.findByOperador(nomeOperador);
	}

	public List<Transferencia> findByContaId(Integer contaId) {
		return transferenciaRepository.findByContaId(contaId);
	}

	public List<Transferencia> getTransferenciasByPeriodoOperador(LocalDateTime inicio, LocalDateTime fim,
			String operador) {
		return transferenciaRepository.findByPeriodoAndOperador(inicio, fim, operador);
	}

	public Page<Transferencia> findByFilter (Long idConta, LocalDateTime startDate, LocalDateTime endDate, String nomeOperador) {
		return transferenciaRepository.findByFilter(idConta, startDate, endDate, nomeOperador, PageRequest.of(0, 4));
	}
}

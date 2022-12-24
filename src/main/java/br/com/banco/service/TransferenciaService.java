package br.com.banco.service;

import java.time.LocalDate;

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

	public Page<Transferencia> findByFilter(Long idConta, LocalDate startDate, LocalDate endDate,
			String nomeOperador, Integer pagina, Integer paginaTamanho) {
		return transferenciaRepository.findByFilter(idConta, startDate, endDate, nomeOperador, PageRequest.of(pagina, paginaTamanho));
	}
}
